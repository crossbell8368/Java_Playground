package lesson5.sum;

import java.util.*;

// 풀이시간: 40분
// 결과: 실패..
public class assignment_16 {

    static int N, M;
    static int[] aryN, aryM, ans;

    private static void input(){
        Scanner sc = new Scanner(System.in);

        N = Integer.parseInt(sc.nextLine());
        aryN = new int[N];
        String[] temp = sc.nextLine().split(" ");
        for(int i = 0; i < N; i++){
            aryN[i] = Integer.parseInt(temp[i]);
        }
        Arrays.sort(aryN);

        M = Integer.parseInt(sc.nextLine());
        aryM = new int[M];
        ans = new int[M];
        temp = sc.nextLine().split(" ");
        for(int i = 0; i < N; i++){
            aryM[i] = Integer.parseInt(temp[i]);
        }
    }

    private static int search(int num) {
        int l = 0;
        int r  = N - 1;

        while(l <= r) {
            int m = (l + r) / 2;
            int temp = aryN[m];
            if (temp < num) {
                l = m + 1;
            } else if (temp > num) {
                r = m - 1;
            } else {
                return m;
            }
        }
        return 0;
    }

    private static int count(int idx){
        int result = 0;
        int num = aryN[idx];
        int index = idx;

        while(aryN[index] == num){
            index++;
            result++;
        }
        return result;
    }

    private static void calc() {
        for(int i = 0; i < M; i++){
            int point = search(aryM[i]);
            if (point == 0){
                ans[i] = 0;
            } else {
                ans[i] = count(point);
            }
        }
    }

    public static void main(String[] args){
        input();
        calc();
        for(int i = 0; i < M; i++){
            System.out.print(ans[i] + " ");
        }
    }
}
