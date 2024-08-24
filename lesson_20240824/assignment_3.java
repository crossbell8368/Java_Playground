package lesson6.parametricSearch;

import java.util.*;

// 풀이시간: 40분, 실패..
public class assignment_3 {

    static int N, M;
    static int[] woods;

    private static void input() {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        woods = new int[N];

        for(int i = 0; i < N; i++) {
            int temp = sc.nextInt();
            woods[i] = temp;
        }
        // 이분탐색을 위해 나무길이 정렬
        Arrays.sort(woods);
    }

    private static void calc() {
        int low = 0;
        int high = woods[N - 1];
        int ans = 0;

        while (low <= high) {
            int mid = (low + high) / 2;
            int woodCount = 0;

            // 지정한 나무값(mid) 값으로 나무를 Cut
            // 얻을 수 있는 나무의 길이를 count
            for (int wood : woods) {
                if(wood > mid){
                    woodCount += wood - mid;
                }
            }

            // 얻은 나무가 기준값보다 많은경우
            // 환경을 생각해서 시작값을 높여 잘리는 길이를 낮추기
            if (woodCount >= M) {
                ans = mid;
                low = mid + 1;

            // 얻은 나무가 부족하다는 것, 잘려진 나무의 갯수가 없다는 것
            // 잘리는 수치를 낮춰서 잘리는 부분이 많도록 설정
            } else {
                high = mid - 1;
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args){
        input();
        calc();
    }
}
