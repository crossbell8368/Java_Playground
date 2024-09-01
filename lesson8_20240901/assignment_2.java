package lesson8.stack;

import java.util.*;

public class assignment_2 {

    static int N, K;
    static int[] ans;
    static List<Integer> ary;

    private static void input(){
        Scanner sc = new Scanner(System.in);

        N =sc.nextInt();
        K = sc.nextInt();
        ans = new int[N];
        //ary = new ArrayList<>();
        // ArrayList 자료형 = 인덱스 기반의 동적배열
        // * 자유료운 데이터의 접근과 추가, 삭제가 가능
        // * 단, index 기반으로 동작하기에, 추가 및 삭제시 데이터 블록의 이동이 발생
        // * 그렇기에 해당 자료형은 빠른 Read에 적합하며, 잦은 Write에는 부적합

        // LinkedList<>();
        // * 링크드 리스트 방식으로 구현된 배열 = 노드 기반의 동적배열
        // * 자유료운 데이터의 접근과 추가, 삭제가 가능
        // * 단, Node 기반으로 동작하기에, 데이터 조회 시 각 노드를 모두 확인하며 이동을 진행
        // * 그렇기에 해당 자료형은 잦은 Write에 적합하며, 잦은 Read에는 부적합
        ary = new LinkedList<>();

        for(int i = 1; i < N; i++){
            ary.add(i);
        }
    }

    private static void calc() {
        int index = 0;
        for(int i = 0; i < N; i++){
            index = (index + K - 1) % ary.size();
            ans[i] = ary.remove(index);
        }
    }

    public static void main(String[] args) {
        input();
        calc();
        for(int num : ans){
            System.out.println(num);
        }
    }
}
