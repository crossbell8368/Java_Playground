package lesson4.sort;

import java.util.*;
// ##### ----- ChallengePoint ----- #####
// * 좌표압축의 개념을 이해하는데 너무 오랜시간이 걸렸음;;;
// * 요약하면 현재 배열의 데이터값을 정렬한 다음
// * 정렬된 순서의 값으로 현재 배열을 표시하라는 것으로 이해

// 풀이시간: 40분, 결과: 실패!
public class sort_18870 {

    static int n;
    static int[] array;
    static List<int[]> lab;

    private static void input(){
        Scanner sc = new Scanner(System.in);

        n = Integer.parseInt(sc.nextLine());
        array = new int[n];
        lab = new ArrayList<>();

        // ##### ----- ChallengePoint ----- #####
        // * 원본배열 array & 정렬을 위한 자료형 lab
        // * lab 자료형은 {기존배열의 index, value} 값으로 구성
        for(int i = 0; i < n; i++){
            int num = Integer.parseInt(sc.next());
            array[i] = num;
            lab.add(new int[]{i, num});
        }
    }

    // ##### ----- ChallengePoint ----- #####
    // * lab 자료형에 저장된 value 값을 기반으로 정렬수행
    // * 원본배열의 값이 정렬된 값으로는 몇번째 값인지 출력
    // * 중복값에 대한 처리가 미비한 것으로 보임...
    private static void calc(){
        lab.sort((a, b) -> a[1] - b[1]);
        for(int i = 0; i < n; i++){
            System.out.print(lab.get(array[i])[1] + " ");
        }
    }

    public static void main(String[] args){
        input();
        calc();
    }
}
