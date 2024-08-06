package lesson3.bruteforce;

import java.util.*;

// 풀이시간: 30분, 미완성
public class bruteforce_11068 {

    static int t;
    static int[] nums;
    static boolean[] ans;

    static private void input() {
        Scanner sc = new Scanner(System.in);

        t = Integer.parseInt(sc.nextLine());
        nums = new int[t];
        ans = new boolean[t];

        for(int i = 0; i < t; i++){
            nums[i] = Integer.parseInt(sc.nextLine());
        }
    }

    // ##### ----- ChallengePoint ----- #####
    // * 회문검사 로직까지는 어느정도 구현
    // * 문제는 힌트에 나온것 처럼, 큰 자리수의 진법 수들이 들어오는 경우
    // * 10진법보다 작은 수의 경우, 이전 문제를 참조하여 String 데이터에 붙여가며 변환값을 도출
    // * 10진법보다 큰 값의 경우, 힌트를 통해 굳이 변환하는게 아닌 바뀐 값을 그대로 비교하기 위해 배열을 사용
    //    * 문제는 배열의 크기를 어떻게 잡야할지 감이 안잡힌다는 것...ㅠ
    static private boolean calc(int num, int val){
        String res = "";

        while(num > 0) {
            int leftNum = num % val;

            if(leftNum < 10) {
                res = res + leftNum;
            } else {

            }
            num = num / val;
        }

        int cnt = 0;
        int max = res.length();
        if(max < 2){
            return false;
        }

        for(int i = 0; i < max / 2; i++){
            if(res.charAt(i) == res.charAt(max - 1 - i)){
                cnt++;
            }
        }
        if(cnt == (max / 2)){
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args){
        input();

        for(int i = 0; i < t; i++){
            for(int j = 2; j < 65; j++){
                if(calc(nums[i], j)){
                    ans[i] = true;
                    break;
                }
            }
        }

        for(int i = 0; i < t; i++) {
            if(ans[i]){
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}
