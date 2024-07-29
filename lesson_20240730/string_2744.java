package lesson;

import java.io.*;
import java.util.*;

public class string_2744 {
    static StringBuilder sb;            // var: 대소문자를 변환결과를 저장할 변수
    static String inputWord;            // var: 입력받은 전체 단어를 저장할 변수
    static String extractWord;          // var: 문자단위로 추출된 글자를 저장할 변수
    static char[] wordArray;            // var: 대소문자 비교를 위해 char 단위로 구분된 변수를 저정할 변수
    static int wordLength;              // var: 단어길이를 저장할 변수


    // func: 사용자 변수입력 함수
    // desc: 입력받은 변수를 전역변수에 저장하는 역할수행
    static void input() {
        FastReader fr = new FastReader();
        sb = new StringBuilder();
        inputWord = fr.next();

        // ##### challengePoint ######
        // 1. 글자단위로 String 데이터 변환이 기억나지 않음
        // 2. Split() 을 활용하여 String[] 형태로 변환하였으나, String 데이터의 대소문자 구분방식 구현실패
        //   - 기억나는 대소문자 구분방식(char 데이터는 아스키데이터를 활용한 문자비교가 가능) 적용을 위해 char[]로 변환
        // 3. 와중에 toCharArray 도 기억이 안나서, 강의자료 참조
        wordArray = inputWord.toCharArray();
        wordLength = inputWord.length();
    }

    // func: 입력받은 단어를 글자단위로 대소문자를 비교하여 변환하는 작업수행
    // desc: char 자료형은 아스키코드 데이터를 활용하여 문자 비교가 된다는 점을 활용
    static void converter() {
        for(int i = 0; i < wordLength; i++) {
            if(wordArray[i] >= 'A' && wordArray[i] <= 'Z') {
                // ##### challengePoint ######
                // 1. char 자료형의 String 데이터 변환방식이 기억나지 않음...
                // 2. 인텔리제이의 도움으로 String.valueOf() 함수활용
                extractWord = String.valueOf(wordArray[i]);
                sb.append(extractWord.toLowerCase());

            } else if (wordArray[i] >= 'a' && wordArray[i] <= 'z') {
                extractWord = String.valueOf(wordArray[i]);
                sb.append(extractWord.toUpperCase());
            }
        }
    }
    public static void main(String args[]) throws IOException {
        input();
        converter();
        System.out.println(sb.toString());
    }

    // class: StringTokenizer 및 BufferedReader 기반 입력보조 클래스
    static class FastReader {

        // var: 콘솔에 입력된 데이터를 읽어들이기 위한 인스턴스 변수
        BufferedReader br;
        // var: 입력 정보를 토큰단위(문자열 기준, 단어, 글자 등 다양하게 조정가능)로 분할하기위한 인스턴스 변수
        StringTokenizer st;

        // func: 클래스 생성자
        // desc: 콘솔로 입력받은 정보(new InputStreamReader(System.in))를 메모리 버퍼에 저장하기위한 초기화
        // 메모리 버퍼에 저장된 정보를 기반으로 문자열 데이터 추출작업 수행
        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        // func: 단어 추출함수
        // desc: StringTokenizer 의 기본설정인, 공백단위의 토큰화 설정 사용
        // 입력받은 문자열에서 공백문자를 만나기 전까지를 하나의 토큰데이터로 간주하여 추출하여 String 데이터로 반환
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException error) {
                    error.printStackTrace();
                }
            }
            return st.nextToken();
        }
    }
}
