package lesson5.sum;

import java.util.*;

// 풀이시간: 40분
// 결과: 실패, 0인 경우에는 break 되지만, 0에 가까운수를 잡아내지 못하며 outOfIndex...
// 0에 가까운 수에 접근하였을때, 빠져나오는 로직 보강이 필요해보임ㅠ
public class assignment_14 {

    static int N, ans;
    static int[] ary;

    private static void input() {
        Scanner sc = new Scanner(System.in);
        N = Integer.parseInt(sc.nextLine());
        ary = new int[N];

        String[] temp = sc.nextLine().split(" ");
        for(int i = 0; i < N; i++){
            ary[i] = Integer.parseInt(temp[i]);
        }
        Arrays.sort(ary);
    }

    private static void calc() {
        int l = 0;
        int r = ary.length - 1;
        int min = Integer.MAX_VALUE;

        while(l <= r) {
            int sum = ary[l] + ary[r];
            int m = (l + r) / 2;
            if (sum > 0) {
                l = m + 1;
            } else if (sum < 0) {
                r = m - 1;
            } else {
                break;
            }
        }
        System.out.println(ary[l] + " " + ary[r]);
    }

    public static void main(String[] args){
        input();
        calc();
    }
}
