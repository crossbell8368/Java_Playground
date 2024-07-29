package lesson;

import java.io.*;
import java.util.*;

public class string_wordCount {

    static String inputString;
    static String[] inputStringArray;
    static int inputStringCount;

    // ##### challengePoint ######
    // 풀이핵심: 공백을 기준으로 문자열을 분리하고, 그 갯수를 세는 것
    // 풀이과정:
    // * 드디어 그나마 알고있엇던 split 이 핵심적으로 쓰이는 문제ㅠ
    // * 입력받은 문자열을 공백기준으로 분할한 다음, 분할된 데이터가 저장된 배열변수의 크기를 확인하는 방식으로 풀이
    static void input() {
        FastReader fr = new FastReader();

        inputString = fr.next();
        inputStringArray = inputString.split(" ");
        inputStringCount = inputStringArray.length;
    }

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(inputStringCount);
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