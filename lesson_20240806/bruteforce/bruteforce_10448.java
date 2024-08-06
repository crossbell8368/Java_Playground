package lesson3.bruteforce;

import java.util.*;

// 출이시간: 50분, 시간초과...
public class bruteforce_10448 {

    static int testCase;
    static int[] testNums;
    static boolean[] ans;

    private static void input() {
        Scanner sc = new Scanner(System.in);

        testCase = Integer.parseInt(sc.next());
        testNums = new int[testCase];
        ans = new boolean[testCase];
        for(int i = 0; i < testCase; i++){
            testNums[i] = Integer.parseInt(sc.next());
        }
    }

    private static int eureka(int num) {
        return (num * (num + 1)) / 2;
    }

    // ##### ----- ChallengePoint ----- #####
    // * 최초 재귀방식으로 구현시도
    //   * 들어갈 수 있는 모든 삼각수 후보군들을 추리다가 시간초과 및 스택버퍼 오버플로우...
    // * 결국 그냥 모든 숫자들을 집어넣어서 삼각수면 탈출하는 방식으로 변경
    //   * 정답은 나오지만 시간초과...
    private static void calc(int idx) {
        int num = testNums[idx];

        for(int i = 1; i <= num; i++){
            for(int j = 1; j <= num; j++){
                for(int k = 1; k <= num; k++){
                    int candiSum = eureka(i) + eureka(j) + eureka(k);
                    if(candiSum == num) {
                        ans[idx] = true;
                        break;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        input();
        for(int i = 0; i < testCase; i++){
            calc(i);
            if(ans[i] == true){
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}
