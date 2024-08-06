package lesson3.bruteforce;

import java.util.*;

// 풀이시간: 40분, 성공!
public class bruteforce_11005 {

    static int n, b;
    static String ans;
    static char[] alphabet;

    // ##### ----- ChallengePoint ----- #####
    // * 26개의 알파벳을 저장하는 더 좋은 방법이 있을 것 같지만...
    // * 생각나는건 배열에 저장하고 남은 값에서 10을 빼서 index로 접근하는 방법밖에는ㅠ
    static private void input(){
        Scanner sc = new Scanner(System.in);

        ans = "";
        n = Integer.parseInt(sc.next());
        b = Integer.parseInt(sc.next());

        alphabet = new char[26];
        for(int i = 0; i < 26; i++){
            alphabet[i] = (char)('A' + i);
        }
    }

    // ##### ----- ChallengePoint ----- #####
    // * 진법 수를 구하는 과정을 구현하는데 초점
    // * 몫은 나누는 수보다 작아질때 까지 계속 나누고
    // * 나머지를 계속 붙여나가는 것이 핵심이라고 생각
    static private void calc(){
        while(n > 0) {
            int leftNum = n % b;

            if(leftNum < 10) {
                ans = leftNum + ans;
            } else {
                ans = (alphabet[leftNum - 10]) + ans;
            }
            n = n / b;
        }

        // ##### ----- ChallengePoint ----- #####
        // * 입력값으로 0이 들어왔을때 처리가 변수였음
        // * n == 0 으로 조건식 처리시, 지금까지 연산값이 초기화 된다는 문제가 확인
        // * 이에 입력값이 0이 들어오면, ans 값이 갱신되지 않았다고 판단하여 equals 사용
        if(ans.equals("")){
            ans = "0";
        }
    }

    public static void main(String[] args) {
        input();
        calc();
        System.out.println(ans);
    }
}
