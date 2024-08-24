package lesson6.parametricSearch;

import java.util.*;

// 풀이시간: 40분, 실패ㅠ
public class assignment_6 {

    static int K, N;
    static int[] wires;

    private static void input() {
        Scanner sc = new Scanner(System.in);

        K = sc.nextInt();
        N = sc.nextInt();
        wires = new int[K];

        for(int i = 0; i < K; i++){
            int temp = sc.nextInt();
            wires[i] = temp;
        }
        // 이분탐색을 위해 정렬
        Arrays.sort(wires);
    }

    private static void calc() {
        int low = 0;
        int high = wires[K - 1];
        int ans = 0;

       while(low <= high) {
           int wireCount = 0;
           int mid = (low + high) / 2;

           // 예비길이(mid)로 생성 가능한 랜선길이를 도출
           for(int wire : wires){
               wireCount += wire / mid;
           }

           // 제작갯수가 충족되어도, 더 긴 랜선길이로 만들수 있는지 확인필요
           // low 값 상승
           if (wireCount >= N) {
               ans = mid;
               low = mid + 1;

           // 제작갯수가 만족되지 않았기에 길이를 줄이는 작업수행
           } else {
               high = mid - 1;
           }
       }
       System.out.println(ans);
    }

    public static void main(String[] args) {
        input();
        calc();
    }
}
