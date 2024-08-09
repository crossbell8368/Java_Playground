package lesson4.sort;

import java.util.*;

// 풀이시간: 40분, 결과: 실패... Array out of Bounds..
public class sort_1181 {

    static int wordCount;
    static String[] wordList;

    private static void input(){
        Scanner sc = new Scanner(System.in);

        wordCount = Integer.parseInt(sc.nextLine());
        wordList = new String[wordCount];

        for(int i = 0; i < wordCount; i++){
            wordList[i] = sc.nextLine();
        }
    }

    private static void calc() {
        for(int i = 0; i < wordCount - 1; i++){
            int minWordIdx = i;
            for(int j = i + 1; j < wordCount; j++){
                // 단어길이 정렬
                if (wordList[j].length() < wordList[minWordIdx].length()){
                    minWordIdx = j;
                // 길이가 같은경우, 사전순 정렬 (같은글자는 비교제외)
                } else if (wordList[j].length() == wordList[minWordIdx].length() &&
                        !wordList[j].equals(wordList[minWordIdx])) {
                    if(wordList[j].compareTo(wordList[minWordIdx]) < 0){
                        minWordIdx = j;
                    }
                }
            }
            String temp = wordList[minWordIdx];
            wordList[minWordIdx] = wordList[i];
            wordList[i] = temp;
        }

        // 중복글자 제거출력 (이 부분에서 에러가 발생되는 것으로 추정...)
        for(int i = 0; i < wordCount ; i++){
            System.out.println(wordList[i]);
            if(i == wordCount - 1){
                break;
            } else {
                while(wordList[i].equals(wordList[i + 1])){
                    i++;
                }
            }
        }
    }

    public static void main(String[] args){
        input();
        calc();
    }
}
