package lesson8.stack;

import java.util.*;

//풀이시간: 50분, 결과: 성공!
//문서순서를 어떻게 관리해야되나 꽤 고민했던 문제
public class assignment_6 {

    static int testCase, N, M, priority;
    static Queue<Integer> que;
    static Queue<Integer> wait;

    private static void input(Scanner sc){
        N = sc.nextInt();
        M = sc.nextInt();
        que = new LinkedList<>();
        wait = new LinkedList<>();
        priority = 0;
        int temp = 0;

        for(int i = 0; i < N; i++){
            temp = sc.nextInt();
            if(temp > priority){
                priority = temp;
            }
            que.add(temp);
            wait.add(i);
        }
    }

    private static void calc() {
        int num = 0;
        int idx = 0;
        int print = 0;

        while(true){
            num = que.poll();
            idx = wait.poll();

            // 중요도가 낮다면 다시 Queue 에 밀어넣기
            if (num < priority){
                que.add(num);
                wait.add(idx);

            // 높은 중요도라면 바로 출력
            } else {
                print++;
                priority = searchMax();
                // 심지어 찾는 문서라면 정답 확인 뒤 return
                if(idx == M){
                    System.out.println(print);
                    break;
                }
            }
        }
    }

    private static int searchMax() {
        int max = 0;
        for(int docs : que){
            if(docs > max){
                max = docs;
            }
        }
        return max;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        testCase = sc.nextInt();
        for(int i = 0; i < testCase; i++){
            input(sc);
            calc();
        }
    }
}
