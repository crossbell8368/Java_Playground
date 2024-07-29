package lesson;

import java.io.*;
import java.util.*;

// 풀이시간: 20분
public class string_frequency {
    static StringBuilder sb;
    static String inputString;
    static int inputStringLength;
    static char[] inputStringArray;
    static HashMap<String, Integer> alphabetDict;
    static int alphabetCount;
    static char[] alphabetArray;

    static void input(){
        sb = new StringBuilder();
        FastReader fr = new FastReader();

        // ##### challengePoint ######
        // * 입력받은 문자열의 모든 공백을 제거하는데 지속적인 split() 사용은 적절하지 않다고 판단
        // * 탐색을 통해 여러가지 방식중, 앞/뒤/중간 등 모든 공백을 제거하는데 replaceAll() 함수가 가장 적절해보였음

        String rawInputString = fr.next();
        inputString = rawInputString.replaceAll("\\s", "").toLowerCase();
        inputStringArray = inputString.toCharArray();
        inputStringLength = inputString.length();
        alphabetDict = new HashMap<>();
        alphabetArray = new char[inputStringLength];
        alphabetCount = 0;
    }

    // ##### challengePoint ######
    // 풀이핵심: 알파벳 순서대로 저장데이터를 정렬
    // 풀이과정:
    // * 아직 HashMap 내부에 저장된 Key값들을 순화하는 방식이 애매하고 헷갈리는 상황ㅠ
    // * 이에 Key값들을 별도의 String 배열에 저장하고 관리, 해당 배열을 기반으로 Value값 추출
    // * 이후 가장 기본적이고 간단한 정렬 알고리즘으로 알파벳 정렬 => 더 나은 정렬법이 있을것 같음..
    // * char 배열을 통해 직접적인 문자 비교연산 수행후 StringBuilder 를 통해 출력값 구축
    static void preprocessing(){
        for(int i = 0; i < inputStringLength; i++){
            String key = String.valueOf(inputStringArray[i]);

            if(alphabetDict.containsKey(key)){
                alphabetDict.put(key, alphabetDict.get(key) + 1);
            } else {
                alphabetDict.put(key, 1);
                alphabetArray[alphabetCount] = inputStringArray[i];
                alphabetCount++;
            }
        }
    }

    static void calc() {
        for(int i = 0; i < alphabetCount; i++){
            for(int j = 0; j < alphabetCount; j++){
                if(alphabetArray[i] < alphabetArray[j]){
                    char temp = alphabetArray[j];
                    alphabetArray[j] = alphabetArray[i];
                    alphabetArray[i] = temp;
                }
            }
        }
        for(int i = 0; i < alphabetCount; i++){
            String alphabetKey = String.valueOf(alphabetArray[i]);
            int alphabetValue = alphabetDict.get(alphabetKey);
            sb.append(alphabetKey).append(": ").append(alphabetValue).append("\n");
        }
    }

    public static void main(String[] args) throws IOException{
        input();
        preprocessing();
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
                    st = new StringTokenizer(br.readLine(), "\n", true);
                } catch(IOException error) {
                    error.printStackTrace();
                }
            }
            return st.nextToken();
        }
    }
}
