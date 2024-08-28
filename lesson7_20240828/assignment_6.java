package lesson7.twoPointer;

import java.util.*;

// 풀이시간: 40분
// 결과: 미완성... 조건문 구성에 실패ㅠ
public class assignment_6 {

    static int S, P;
    static String ary;
    static int[] limitList, countList;

    private static void input() {
        Scanner sc = new Scanner(System.in);

        S = sc.nextInt();
        P = sc.nextInt();
        ary = sc.nextLine();
        limitList = new int[4];
        countList = new int[4];

        for(int i = 0; i < 4; i++){
            limitList[i] = sc.nextInt();
        }
    }

    private static void calc() {
        int start = 0, end = 0, ans = 0, count = 0;

        while(end < P){
            if(checkChar(ary.charAt(end)) )
        }

    }

    private static boolean checkChar(char word) {
        switch (word) {
            case 'A': if (countList[0] < limitList[0]) {
                countList[0]++;
                return true;
            } else {
                return false;
            }
            case 'C': if (countList[1] < limitList[1]) {
                countList[1]++;
                return true;
            } else {
                return false;
            }
            case 'G': if (countList[2] < limitList[2]) {
                countList[2]++;
                return true;
            } else {
                return false;
            }
            case 'T': if (countList[3] < limitList[3]) {
                countList[3]++;
                return true;
            } else {
                return false;
            }
        }
    }
}
