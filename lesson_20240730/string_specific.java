package lesson;

import java.io.*;
import java.util.*;

// 풀이시간: 10분
public class string_specific {
    static String inputString;
    static String inputWord;

    static void input(){
        FastReader fr = new FastReader();

        inputString = fr.next();
        inputWord = fr.next();
    }

    // ##### challengePoint ######
    // 풀이핵심: 특정 문자를 모두 없애는 것이 핵심
    // 풀이과정: 이전 공백을 제거하는데 사용한 replaceAll() 함수가 기억남
    // 이번엔 공백이 아닌, 입력받은 문자를 넣어서 요구사항을 충족시킬 수 있었음
    static void calc() {
        String newString = inputString.replaceAll(inputWord, "");
        System.out.println(newString);
    }

    public static void main(String[] args) throws IOException {
        input();
        calc();
    }

    static class FastReader{

        BufferedReader br;
        StringTokenizer st;

        public FastReader(){
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
