package lesson;

import java.io.*;
import java.util.*;

// 풀이사간 40분
public class string_1157 {

    static StringBuilder sb;
    static String inputWord;
    static String inputWordList;
    static char[] inputWordArray;
    static int inputWordLength;
    static HashMap<String, Integer> inputWordCount;
    static int maxWordCount;
    static String maxWord;

    static void input() {
        FastReader fr = new FastReader();
        String rawInputWord = fr.next();

        sb = new StringBuilder();
        inputWord = rawInputWord.toLowerCase();
        inputWordList = "";
        inputWordArray = inputWord.toCharArray();
        inputWordLength = inputWord.length();
        inputWordCount = new HashMap<>();
        maxWordCount = 0;
        maxWord = "";
    }

    static void preprocessing() {
        for(int index = 0; index < inputWordLength; index++){
            String key = String.valueOf(inputWordArray[index]);

            // sol: 단어에서 사용된 클자수 count
            if(inputWordCount.containsKey(key)) {
                inputWordCount.put(key, inputWordCount.get(key) + 1);

            // sol: 단어에서 사용된 글자 최초 등록
            } else {
                sb.append(key);
                inputWordCount.put(key, 1);
            }
        }
        inputWordList = sb.toString();
    }

    // ##### Challenge Point ######
    // 핵심풀이: 딕셔너리 자료형에 저장된 모든 정보들을 순환하며 최대값을 찾아내는것이 목표
    // 풀이과정:
    // * 딕셔너리 자료형의 전체순환 방식이 기억나지 않아, 별도의 입력받은 단어에 사용된 단어를 저장하는 배열을 추가선언
    // * 해당 배열에 저장된 문자데이터를 key값으로 value 데이터를 추출하여 max 값을 도출
    // * max값을 도출한 다음, 같은 값을 가지고 있는 단어들이 있는지 딕셔너리 데이터를 다시순환
    // 개선점: 딕셔너리 데이터를 2회 순환하여 성능저하 가능성...

    static void calc() {
        int maxCount = 0;
        int inputWordListLength = inputWordList.length();
        char[] inputWordListArray = inputWordList.toCharArray();

        for(int index = 0; index < inputWordListLength; index++){
            String key = String.valueOf(inputWordListArray[index]);
            if(inputWordCount.get(key) > maxCount) {
                maxCount = inputWordCount.get(key);
            }
        }

        for(int index = 0; index < inputWordListLength; index++){
            String key = String.valueOf(inputWordListArray[index]);
            if(inputWordCount.get(key) == maxCount) {
                maxWordCount++;
                maxWord = key;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        preprocessing();
        calc();
        if(maxWordCount > 1){
            System.out.println("?");
        } else {
            System.out.println(maxWord.toUpperCase());
        }
    }

    static class FastReader {

        BufferedReader br;
        StringTokenizer st;

        public FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next(){
            while(st == null || !st.hasMoreElements()){
                try {
                    st = new StringTokenizer(br.readLine());
                } catch(IOException error){
                    error.printStackTrace();
                }
            }
            return st.nextToken();
        }
    }
}
