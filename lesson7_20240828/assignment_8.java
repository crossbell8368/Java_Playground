package lesson7.twoPointer;

import java.util.*;

public class assignment_8 {

    static int N;
    static int[] dist;

    private static void input(){
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        dist = new int[N];
        for(int i = 0; i < N; i++){
            dist[i] = sc.nextInt();
        }
    }

    private static void calc() {
        int start = 0, end = 0, ans = 0, temp = 0;
        while (end < N) {
            temp = dist[start] + dist[end];

            // 정방향 or 반대방향 두가지로 나눠서 연산필요...
        }
    }
}
