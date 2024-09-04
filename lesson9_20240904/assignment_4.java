package lesson9.recursive;

import java.util.*;

// 풀이시간: 40분, 결과 : 성공!
// 이전 수보다 큰 숫자만 조합해야된다는 점을 조건식에 넣는데 가장 큰 시간 소요;;
public class assignment_4 {

    static int N, M;
    static int[] ary, select;
    static boolean[] pick;
    static StringBuilder sb;

    private static void input(){
        Scanner sc = new Scanner(System.in);
        sb = new StringBuilder();
        N = sc.nextInt();
        M = sc.nextInt();
        ary = new int[N+1];
        pick = new boolean[N+1];
        select = new int[M+1];

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
            for(int i = k; i <= N; i++){
                if (pick[i]){
                    continue;
                } else {
                    if (ary[i] > select[k - 1]) {
                        select[k] = ary[i];
                        pick[i] = true;
                        calc(k+1);
                        select[k] = 0;
                        pick[i] = false;
                    }
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
