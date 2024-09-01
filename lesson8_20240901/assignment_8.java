package lesson8.stack;

import java.util.*;

// 풀이시간: 40분, 결과: 시간초과!
// input 에서 많은 시간낭비..
// nextLine 과 nextInt 함수의 사용차이로, 마지막 명령어가 수행되지 않아 이부분에서 너무나 오랜시간 소요...ㅠ
public class assignment_8 {

    static int N;
    static List<Integer> deque;
    static String[][] orderList;

    private static void input() {
        Scanner sc = new Scanner(System.in);
        N = Integer.parseInt(sc.nextLine());
        deque = new LinkedList<>();
        orderList = new String[N][2];

        for(int i = 0; i < N; i++){
            String[] temp = sc.nextLine().split(" ");
            if (temp.length == 1){
                orderList[i][0] = temp[0];
            } else {
                orderList[i][0] = temp[0];
                orderList[i][1] = temp[1];
            }
        }
    }

    private static void processor() {
        for(String[] order : orderList) {
            switch (order[0]) {
                case "push_front":
                    deque.add(0, Integer.parseInt(order[1]));
                    continue;
                case "push_back":
                    deque.add(Integer.parseInt(order[1]));
                    continue;
                case "pop_front":
                    if (deque.isEmpty()) {
                        System.out.println(-1);
                        continue;
                    } else {
                        int num = deque.remove(0);
                        System.out.println(num);
                        continue;
                    }
                case "pop_back":
                    if (deque.isEmpty()) {
                        System.out.println(-1);
                        continue;
                    } else {
                        int num = deque.remove(deque.size() - 1);
                        System.out.println(num);
                        continue;
                    }
                case "size":
                    System.out.println(deque.size());
                    continue;
                case "empty":
                    if (deque.isEmpty()) {
                        System.out.println(1);
                        continue;
                    } else {
                        System.out.println(0);
                        continue;
                    }
                case "front":
                    if (deque.isEmpty()) {
                        System.out.println(-1);
                        continue;
                    } else {
                        System.out.println(deque.get(0));
                        continue;
                    }
                case "back":
                    if (deque.isEmpty()) {
                        System.out.println(-1);
                        continue;
                    } else {
                        System.out.println(deque.get(deque.size() - 1));
                        continue;
                    }
            }
        }
    }

    public static void main(String[] args){
        input();
        processor();
    }
}
