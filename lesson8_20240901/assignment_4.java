package lesson8.stack;

import java.util.*;

// 풀이시간: 30분, (성공)
// Queue를 활용하는 것을 알고나니 접근이 간편했던 문제
// 해당 자료형의 활용을 몰랐을경우 매우 골치아팠을것으로 예상
public class assignment_4 {
    static Queue<Integer> buffer;
    static int N;

    private static void input() {
        Scanner sc = new Scanner(System.in);
        buffer = new LinkedList<>();
        N = sc.nextInt();
        int temp = 0;

        while(true) {
            temp = sc.nextInt();
            if(temp == 0){
                buffer.poll();
            } else if(temp == -1){
                break;
            } else if(buffer.size() < N) {
                buffer.add(temp);
            } else {
                continue;
            }
        }
    }

    private static void calc() {
        Integer res = 0;

        if(buffer.peek() == null) {
            System.out.print("empty");
            return;
        }

        while(true) {
            res = buffer.poll();
            if (res == null){
                break;
            }
            System.out.print(res + " ");
        }
    }

    public static void main(String[] args) {
        input();
        calc();
    }
}
