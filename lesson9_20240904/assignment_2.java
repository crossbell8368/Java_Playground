package lesson9.recursive;

import java.util.*;

// 풀이시간: 50분, 결과 : 성공!
// 오름차순으로 결과를 뽑기위해서 사전 정렬이 필요하다는것을 찾아내기에 많은 시간이 소요
public class assignment_2 {

    static int N, M;
    static int[] ary, select;
    static boolean[] pick;
    static StringBuilder sb;

    private static void input(){
        Scanner sc = new Scanner(System.in);
        sb = new StringBuilder();
        N = sc.nextInt();
        M = sc.nextInt();

        ary = new int[N + 1];
        pick = new boolean[N+ 1];
        select = new int[M + 1];

        for(int i = 1; i <= N; i++){
            ary[i] = sc.nextInt();
        }
        Arrays.sort(ary);
    }

    private static void calc(int k) {
        if (k == M + 1) {
            for(int i = 1; i <= M; i++){
                sb.append(select[i]).append(' ');
            }
            sb.append('\n');
        } else {
            for(int i = 1; i <= N; i++){
                if(!pick[i]){
                    select[k] = ary[i];
                    pick[i] = true;
                    calc(k + 1);
                    pick[i] = false;
                    select[k] = 0;
                }
            }
        }
    }

    public static void main(String[] args){
        input();
        calc(1);
        System.out.println(sb.toString());
    }
}
