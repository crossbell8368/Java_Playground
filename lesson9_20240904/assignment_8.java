package lesson9.recursive;

import java.util.*;

// 풀이시간: 20분, 결과: 성공!
// 중복일 경우, 이전에 뽑은 수와 같거나 크다는 것을 조건에 넣는 것이 핵심
public class assignment_8 {

    static int N, M;
    static int[] select, ary;
    static StringBuilder sb;

    private static void input(){
        Scanner sc = new Scanner(System.in);
        sb = new StringBuilder();

        N = sc.nextInt();
        M = sc.nextInt();
        ary = new int[N + 1];
        select = new int[M + 1];

        for(int i = 1; i <= N; i++){
            ary[i] = sc.nextInt();
        }
        Arrays.sort(ary);
    }

    private static void calc(int k){
        if (k == M+1) {
            for(int i = 1; i <= M; i++){
                sb.append(select[i]).append(' ');
            }
            sb.append('\n');
        } else {
            for(int i = 1; i <= N; i++){
                if(ary[i] >= select[k-1]){
                    select[k] = ary[i];
                    calc(k+1);
                    select[k] = 0;
                }
            }
        }
    }

    public static void main(String[] args){
        input();
        calc(1);
        System.out.print(sb.toString());
    }
}
