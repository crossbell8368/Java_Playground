package lesson;

import java.io.*;
import java.util.*;

public class string_duplicate {

    static StringBuilder sb;
    static String inputString;
    static int inputStringLength;
    static char[] inputStringArray;
    static HashMap<String, Integer> inputStringDict;
    static void input(){
        sb = new StringBuilder();
        FastReader fr = new FastReader();

        inputString = fr.next();
        inputStringLength = inputString.length();
        inputStringArray = inputString.toCharArray();
        inputStringDict = new HashMap<>();
    }

    // ##### challengePoint ######
    // 풀이핵심: 중복문자를 어떻게 저장하고 조회할 것인지
    // 풀이과정: HashMap의 containsKey 기능을 통해 손쉽게 중복문자를 확인하고 처리
    // 개선점: Set 자료형을 통해 더 간단하게 이를 처리 가능했던 것으로 기억만 남...
    static void calc(){
        for(int i = 0; i < inputStringLength; i++) {
            String key = String.valueOf(inputStringArray[i]);

            if (inputStringDict.containsKey(key)) {
                continue;
            } else {
                inputStringDict.put(key, 1);
                sb.append(key);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        calc();
        System.out.println(sb.toString());
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
                    st = new StringTokenizer(br.readLine());
                } catch(IOException error) {
                    error.printStackTrace();
                }
            }
            return st.nextToken();
        }
    }
}
