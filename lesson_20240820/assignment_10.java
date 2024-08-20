package lesson5.sum;

import java.util.*;

// 풀이시간: 40분
// 결과: 실패, 예제통과

// #===== Key Solution =====#
// 이전 과제의 이진탐색 코드를 참조하여 String 데이터의 이진탐색 코드를 구축
// 예제는 통과하였으나, 채점시 실패...

public class assignment_10 {

    static int N, M;
    static String[] S, ary;

     private static void input(){
         Scanner sc = new Scanner(System.in);
         String[] temp = sc.nextLine().split(" ");
         N = Integer.parseInt(temp[0]);
         M = Integer.parseInt(temp[1]);
         S = new String[N];
         ary = new String[M];

         for(int i = 0; i < N; i++){
             S[i] = sc.nextLine();
         }
         Arrays.sort(S);

         for(int i = 0; i < M; i++){
             ary[i] = sc.nextLine();
         }
         Arrays.sort(ary);
     }

     private static boolean calc(String word) {
         int l = 0;
         int r = ary.length - 1;
         while(l <= r){
             int m = (l + r) / 2;
             int res = word.compareTo(ary[m]);
             if (res < 0) {
                 r = m - 1;
             } else if (res > 0) {
                l = m + 1;
             } else {
                 return true;
             }
         }
         return false;
     }

     public static void main(String[] args){
         int res = 0;
         input();
         for(int i = 0; i < N; i++){
             if (calc(S[i])) {
                 res++;
             }
         }
         System.out.println(res);
     }
}
