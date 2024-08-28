package lesson7.twoPointer;

import java.util.*;

// 풀이시간: 40분
// 결과: 50%에서 실패...
public class assignment_2 {

    static int N, S;
    static int[] ary;

    private static void input() {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        S = sc.nextInt();
        ary = new int[N];

        for(int i = 0; i < N; i++) {
            ary[i] = sc.nextInt();
        }
    }

    private static void calc() {
        int start = 0, end = 0, sum = 0;
        int ans = Integer.MAX_VALUE;

        // end 포인트가 배열의 끝에 도달할때까지 반복
        while (end < N) {
            // 목표수치(S) 이상이 되면, start 값을 상승시켜서 최대한 길이를 감소시키는 동작수행
            if (sum >= S) {
                ans = Math.min(ans, end - start);
                sum -= ary[start];
                start++;

            // 목표수치 이하는 end 값을 늘리면서 목표수치에 도달하도록 동작수행
            } else {
                sum += ary[end];
                end++;
            }
        }
        if(ans == Integer.MAX_VALUE){
            System.out.println(0);
        } else {
            System.out.println(ans);
        }
    }

    public static void main(String[] args){
        input();
        calc();
    }
}
