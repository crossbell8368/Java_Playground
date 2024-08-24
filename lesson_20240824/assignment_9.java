package lesson6.parametricSearch;

import java.util.*;

// 풀이시간: 40분, 미완성ㅠ
public class assignment_9 {

    static int N, M;
    static int[] expense;

    private static void input(){
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        expense = new int[N];

        for(int i = 0; i < N; i++) {
            expense[i] = sc.nextInt();
        }
        Arrays.sort(expense);
    }

    private static void calc() {
        int low = 0;
        int high = 10000;
        int ans = 0;

        while(low <= high){
            int mid = (low + high) / 2;
            int wallet = mid;
            int withdrawCount = M;

            for(int cost : expense){
                if((wallet - cost) < 0) {
                    if(withdrawCount)

                    wallet = mid;
                    withdrawCount--;
                }
                wallet -= cost;
            }
        // ##### ChallengePoint
        // 지출과 인출횟수 2가지를 가지고 종료로직을 구성하는데 실패..ㅠ

        }
    }

}
