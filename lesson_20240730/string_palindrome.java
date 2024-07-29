package lesson;

import java.util.*;
import java.io.*;

// 풀이시간: 20분
public class string_palindrome {
    static StringBuilder sb;
    static String inputString;
    static int inputStringLength;
    static char[] inputStringArray;
    static Boolean isPailndrome;

    // ##### challengePoint ######
    // 개선점:
    // * 문자열에서 공백제거 함수가 있었던것으로 기억만...
    // * 그래도 어떻게든 문제해결을 위해, split() 으로 공백을 제거
    // * 분해된 문자열을 다시 합치는 방식으로 진행ㅠ
    static void input(){
        sb = new StringBuilder();
        FastReader fr = new FastReader();

        String rawInputString = fr.next();
        String[] tempString = rawInputString.split(" ");
        for(int i = 0; i < tempString.length; i++){
            sb.append(tempString[i].toLowerCase());
        }
        inputString = sb.toString();
        inputStringLength = inputString.length();
        inputStringArray = inputString.toCharArray();
        isPailndrome = true;
    }

    // ##### challengePoint ######
    // 개선점:
    // * 글자수의 짝수/홀수에 따라 중복코드가 너무 많음...
    static void calc(){
        // sol:
        // * 글자 수가 홀수일 경우, 가운데 문자는 자동으로 조건에 만족됨으로 연산범위에서 제거 필요
        if(inputStringLength % 2 == 0){
            int stringMid = inputStringLength / 2;

            for(int i = 0; i <= stringMid; i++) {
                if(inputStringArray[i] == inputStringArray[(inputStringLength - 1) - i]) {
                    continue;
                } else {
                    isPailndrome = false;
                    break;
                }
            }
            isPailndrome = true;

        // sol:
        // * 글자 수가 짝수일 경우, 가운데 문자도 확인범위에 들어가기에 포함시켜야함
        } else {
            int stringMid = inputString.length() / 2;

            for(int i = 0; i < stringMid; i++) {
                if(inputStringArray[i] == inputStringArray[(inputStringLength - 1) - i]) {
                    continue;
                } else {
                    isPailndrome = false;
                    break;
                }
            }
            isPailndrome = true;
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        calc();
        if(isPailndrome){
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    static class FastReader{

        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next(){
            while(st == null || !st.hasMoreElements()){
                try {
                    st = new StringTokenizer(br.readLine(), "\n", true);
                } catch(IOException error) {
                    error.printStackTrace();
                }
            }
            return st.nextToken();
        }
    }
}
