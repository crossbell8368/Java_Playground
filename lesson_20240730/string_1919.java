package lesson;

import java.util.*;
import java.io.*;

// 풀이 시간: 70분
public class string_1919 {

    static StringBuilder sb;
    static String firstWord;
    static int firstWordLength;
    static char[] firstWordArray;
    static String secondWord;
    static int secondWordLength;
    static char[] secondWordArray;
    static HashMap<String, Integer> sharedWord;
    static int removeCount;

    static void input() {
        FastReader fr = new FastReader();
        sb = new StringBuilder();
        firstWord = fr.nextLine();
        firstWordLength = firstWord.length();
        firstWordArray = firstWord.toCharArray();
        secondWord = fr.nextLine();
        secondWordLength = secondWord.length();
        secondWordArray = secondWord.toCharArray();
        sharedWord = new HashMap<>();
        removeCount = 0;
    }

    // ##### Challenge Point ######
    // 1. 해당 단어가 포함되어있는지 확인하는 함수가 기억나지 않음
    // 2. 그렇기에 char 배열을 모두 순환하는 구조로 구성
    // 3. 초기 공통된 문자추출만 진행하였으나, 이내 공통된 문자의 갯수까지 파악해야함을 확인
    // 4. Dictionary 자료형이 필요함을 깨닫고 기본적인 Java Dictionary 자료형인 HashMap의 활용법을 검색하고 적용
    static void extractSharedWord() {
        for(int i = 0; i < firstWordLength; i++) {
            String key = String.valueOf(firstWordArray[i]);

            // sol: 중복되는 공유단어 제거
            if(sharedWord.containsKey(key)) {
                continue;
            }
            for (int j = 0; j < secondWordLength; j++) {

                // sol: 공유하는 문자정보 확인
                if (firstWordArray[i] == secondWordArray[j]) {

                    // sol: 공유하는 문자가 여러개인 경우
                    if(sharedWord.containsKey(key)) {
                        sharedWord.put(key, sharedWord.get(key) + 1);

                    // sol: 최초로 공유하는 문자를 확인한 경우
                    } else {
                        sharedWord.put(key, 1);
                    }
                }
            }
        }
    }

    // ##### Challenge Point ######
    // 풀이핵심: 애너그램 관계 = 두 단어가 가지고 있는 글자의 갯수와 종류가 같아야 함
    // 풀이과정:
    // 1. 입력받은 단어가 서로 공유하는 글자추출
    // 2. 서로 공유하지 않거나, 공유해도 그 갯수가 공유하는 수보다 많을경우 제거해야 됨
    static void calc(char[] ary, int len) {

        // ##### Challenge Point ######
        // 1. 첫번째 단어와, 두번쨰 단어를 모두 공유단어 딕셔너리 자료형과 비교를 진행
        // 2. 공유단어 갯수를 맞추기 위해, 공유단어의 갯수연산을 위해 복사 자료형 생성
        // 3. 초기에 '''HashMap<String, Integer> compareDict = sharedWord''' 코드로 선언하여 사용
        // 4. 위와같이 사용시 전역변수와 지역변수가 서로 연동되어, 전역변수의 값까지 연산결과가 적용되는 현상확인
        // 5. 이후 검색을 통해 딕셔너리 자료형 복사를 위해서는 아래와 같은 코드선언이 필요함을 확인
        HashMap<String, Integer> compareDict = new HashMap<>(sharedWord);

        for(int i = 0; i < len; i++) {
            String key = String.valueOf(ary[i]);

            // sol: 공유단어에 포함된 단어인지 확인
            if (compareDict.containsKey(key)) {
                compareDict.put(key, compareDict.get(key) - 1);

                // sol: 공유하지만, 그 갯수가 공유단어 이상인 경우 = 제거필요
                if (compareDict.get(key) < 0) {
                    removeCount++;
                }

            // sol: 공유단어가 아닌경우 제거필요
            } else {
                removeCount++;
            }
        }
    }

    public static void main(String args[]) {
        input();
        extractSharedWord();
        calc(firstWordArray, firstWordLength);
        calc(secondWordArray, secondWordLength);
        System.out.println(removeCount);
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while(st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch(IOException error) {
                    error.printStackTrace();
                }
            }
            return st.nextToken();
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch(IOException error) {
                error.printStackTrace();
            }
            return str;
        }
    }
}
