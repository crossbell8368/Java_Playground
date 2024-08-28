package lesson7.twoPointer;

import java.util.*;

// 풀이시간: 50분
// 결과: 실패... 이유는..??
public class assignment_4 {

    static int N, M;
    static int[] ary;

    private static void input(){
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        ary = new int[N];

        for(int i = 0; i < N; i++) {
            ary[i] = sc.nextInt();
        }
    }

    private static void calc() {
        int start = 0, end = 0, temp = 0;
        int ans = Integer.MAX_VALUE;

        // 구하려는 값이 조건을 만족시킬때까지 end 값 상승
        while(end < N) {
            temp = Math.abs(ary[start] - ary[end]);

            // 값이 조건을 만족시킨경우, 가장 작은 값을 찾아내기위해 start 값을 감소
            if(temp >= M) {
                ans = Math.min(ans, temp);
                start++;
            } else {
                end++;
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args){
        input();
        calc();
    }
}
