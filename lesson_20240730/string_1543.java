package lesson;

import java.io.*;
import java.util.*;

// 풀이시간: 30분
public class string_1543 {

    static String inputDocs;
    static char[] inputDocsArray;
    static String inputWord;
    static char[] inputWordArray;
    static int inputWordLength;
    static int totalWordCount;

    static void input() {
        // sol: 기존 '단어추출' 방식이였던 next() 함수의 인자값을 조정하여 문장을 추출하는 방식으로 변경
        // sol: 단어 추출시, 띄어쓰기가 포함된 문서나 단어가 모두 담기지 못함을 확인
        FastReader fr = new FastReader();
        inputDocs = fr.next();
        inputDocsArray = inputDocs.toCharArray();
        inputWord = fr.next();
        inputWordArray = inputWord.toCharArray();
        inputWordLength = inputWord.length();
        totalWordCount = 0;
    }

    // ##### Challenge Point ######
    // 풀이핵심: 입력받은 문서에서 겹치는 단어를 확인하고, 그 다음 문자열부터 중복되는 단어를 찾는 것
    // 풀이과정:
    // * 오리엔테이션에서 문자열 내 문자의 위치탐색 함수 'indexOf' 가 생각났음
    // * 그러나, 문제에 핵심이 되는, 최초등장 이후 두번째, 세번째 등장하는 단어의 탐색에 어려움을 확인
    // * 강의자료를 통해, 'indexOf' 의 두번째 인자값을 통해, 그 다음부터 최초의 index값 도출이 가능함을 확인
    static void calc(int index) {
        if(index + inputWordLength > inputDocs.length()){
            return;
        } else {
            int wordIndex = 0;
            int candidateLength = 0;

            for(int i = index; i < index + inputWordLength; i++){
                if(inputDocsArray[i] == inputWordArray[wordIndex]) {
                    candidateLength++;
                    wordIndex++;
                // sol: 한글자라도 일치하지 않으면 의미가 없기에 바로 break
                } else {
                    break;
                }
            }

            // sol: 겹치는 단어를 찾은경우, 해당 단어의 길이 이후부터 탐색
            if(candidateLength == inputWordLength) {
                totalWordCount++;
                int nextIndex = inputDocs.indexOf(inputWordArray[0], index + inputWordLength);
                calc(nextIndex);

            // sol: 단어탐색이 실패하였다면, 바로 다음 index부터 탐색 재개
            } else {
                int nextIndex = inputDocs.indexOf(inputWordArray[0], index + 1);
                calc(nextIndex);
            }
        }
    }

    public static void main(String args[]) throws IOException {
        input();
        int firstIndex = inputDocs.indexOf(inputWordArray[0]);
        calc(firstIndex);
        System.out.println(totalWordCount);
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine(), "\n", true);
                } catch (IOException error) {
                    error.printStackTrace();
                }
            }
            return st.nextToken();
        }
    }
}
