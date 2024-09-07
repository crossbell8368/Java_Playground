package lesson10.graph;

import java.util.*;

// 풀이시간: 30분, 결과: 성공
// 이전 문제와 같이 연결요소를 찾아내는것이 핵심인 문제
public class assignment_6 {

    static int N, M, count;
    static boolean[] conn;
    static List<Integer>[] network;

    private static void input() {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        conn = new boolean[N+1];
        network = new ArrayList[N+1];
        count = 0;

        for(int i = 1; i <= N; i++) {
            network[i]= new ArrayList<>();
        }
        for(int i = 0; i < M; i++) {
            int nodeA = sc.nextInt();
            int nodeB = sc.nextInt();
            network[nodeA].add(nodeB);
            network[nodeB].add(nodeA);
        }
    }

    private static void calc(){
        Queue<Integer> que = new LinkedList<>();
        que.add(1);

        while(!que.isEmpty()){
            int currentNode = que.poll();
            conn[currentNode] = true;

            for(int nextNode : network[currentNode]) {
                if(conn[nextNode]) continue;
                conn[nextNode] = true;
                que.add(nextNode);
                count++;
            }
        }
    }

    public static void main(String[] args){
        input();
        calc();
        System.out.println(count);
    }
}
