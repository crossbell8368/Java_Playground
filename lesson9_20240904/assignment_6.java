package lesson9.recursive;

import java.util.*;

// 풀이시간: 15분, 결과: 성공!
// 중복을 오히려 관리하지 않아서 이전 문제보다 간단했었음
public class assignment_6 {

    static int N, M;
    static int[] ary, select;
    static StringBuilder sb;

    private static void input(){
        Scanner sc = new Scanner(System.in);
        sb = new StringBuilder();

        N = sc.nextInt();
        M = sc.nextInt();
        ary = new int[N+1];
        select = new int[M+1];
        for(int i = 1; i <= N; i++){
            ary[i] = sc.nextInt();
        }
        Arrays.sort(ary);
    }

    private static void calc(int k) {
        if(k == M+1){
            for(int i = 1; i <= M; i++){
                sb.append(select[i]).append(' ');
            }
            sb.append('\n');
        } else {
            for(int i = 1; i <= N; i++){
                select[k] = ary[i];
                calc(k+1);
                select[k] = 0;
            }
        }
    }

    public static void main(String[] args){
        input();
        calc(1);
        System.out.println(sb.toString());
    }
}
