package lesson5.sum;

import java.util.*;

// 풀이시간: 70분
// 결과: 실패, 일부 에제통과
public class assignment_2 {

    static int N, Q;
    static int[] ary;
    static String[] binArray;
    static int[][] query;
    static String[] queryResult;

    private static void input() {

        Scanner sc = new Scanner(System.in);
        String[] temp = sc.nextLine().split(" ");
        N = Integer.parseInt(temp[0]);
        Q = Integer.parseInt(temp[1]);

        ary = new int[N];
        binArray = new String[N];
        query = new int[Q][2];
        queryResult = new String[Q];

        temp = sc.nextLine().split(" ");
        for(int i = 0; i < N; i++){
            ary[i] = Integer.parseInt(temp[i]);
        }

        for(int i = 0 ; i < Q; i++){
            temp = sc.nextLine().split(" ");
            query[i][0] = Integer.parseInt(temp[0]);
            query[i][1] = Integer.parseInt(temp[1]);
        }
    }

    // Key Solution
    // 1. 입력배열을 2진법으로 변환
    // 2. 쿼리별 범위에 따른 XOR 연산합을 산출
    // 3. 쿼리별 XOR 연산결과를 모두 XOR 연산수행

    public static void main(String[] args){
        input();

        for(int i = 0; i < N; i++){
            binArray[i] = convertToBin(ary[i]);
        }
        for(int i = 0; i < Q; i++){
            queryResult[i] = sumXOR(query[i][0], query[i][1]);
        }
        String result = queryResult[0];
        for(int i = 1; i < Q; i++){
            result = calcXOR(result, queryResult[i]);
        }
        System.out.println(convertToOrigin(result));
    }

    // 문제의 핵심포인트 중 하나인 2진법의 변환부분
    // 이전 String 자료형에 값을 자유롭게 붙였던 case를 활용하여 구성
    private static String convertToBin(int num){
        String result = "";
        int currentNum = num;
        int nextNum, convertNum;

        while(true) {
            nextNum = currentNum / 2;
            convertNum = currentNum % 2;
            result = convertNum + result;

            if(nextNum == 0){
                break;
            }
            currentNum = nextNum;
        }
        return result;
    }

    // 의외의 복병 포인트;;;
    // 제곱연산을 일일이 구현하다가, 이건 아니라는 생각이 들음...
    // 검색을 통해 Math 패키지에 제곱을 구하는 함수를 확인하여, 이를 활용하여 구성
    private static int convertToOrigin(String num) {
        int result = 0;
        int len = num.length();

        for (int i = 0; i < len; i++) {
            if (num.charAt(i) == '1') {
                result += (int) Math.pow(2, len - 1 - i);
            }
        }
        return result;
    }

    // XOR 연산부분!
    // PPT의 문제 핵심 아이디어를 활용하여 구성
    private static String calcXOR(String a, String b){
        String result = "";
        int lenA = a.length();
        int lenB = b.length();
        int len = Math.max(lenA, lenB);

        if (lenA < lenB) {
            for(int i = 0; i < lenB - lenA; i++){
                a = 0 + a;
            }
        } else if(lenB < lenA) {
            for(int i = 0; i < lenA - lenB; i++){
                b = 0 + b;
            }
        }

        for(int i = 0; i < len; i++){
            if(a.charAt(i) == b.charAt(i)){
                result = 0 + result;
            } else {
                result = 1 + result;
            }
        }
        return result;
    }

    // 여기쯤 오니까, 정신이 멍해지고 이게 뭔가 싶어지기 시작
    // 구현한 XOR 연산함수를 활용하여, 구간내 XOR 연산결과를 저장
    private static String sumXOR(int start, int end) {
        String result = binArray[start];

        for(int i = start + 1; i <= end; i++){
            result = calcXOR(result, binArray[i]);
        }
        return result;
    }
}
