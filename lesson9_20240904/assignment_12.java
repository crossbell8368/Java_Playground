package lesson9.recursive;

import java.util.*;

// 풀이시간: 50분, 결과: 실패..
// 쿼리별 서브트리의 루트 정점의 부모정점 처리가 제대로 수행되지 않아, 전체 트리를 순환하는 문제가 발생...
public class assignment_12 {

    static int N, R, Q, count;
    static int[] query;
    static List<Integer>[] map;

    private static void input() {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        R = sc.nextInt();
        Q = sc.nextInt();
        map = new ArrayList[N + 1];
        query = new int[Q];

        for(int i = 1; i <= N; i++){
            map[i] = new ArrayList<>();
        }

        for(int i = 1; i < N; i++){
            int nodeA = sc.nextInt();
            int nodeB = sc.nextInt();
            map[nodeA].add(nodeB);
            map[nodeB].add(nodeA);
        }

        for(int i = 0; i < Q; i++){
            query[i] = sc.nextInt();
        }
    }

    private static void calc(int loc, int parent){
        for(int node : map[loc]){
            if(node != parent){
                count++;
                calc(node, loc);
            }
        }
    }

    public static void main(String[] args){
        input();
        for(int i = 0; i < Q; i++){
            count = 0;
            calc(query[i], 0);
            System.out.println(count);
        }
    }
}
