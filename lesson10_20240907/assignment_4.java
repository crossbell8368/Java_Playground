package lesson10.graph;

import java.util.*;

// 풀이시간: 40분, 결과: 성공
// DFS 가 더 나은 방식일지, BFS 더 나은 방식일지 조금 고민...
// 연결정보 파악이 우선시 되기에 BFS 방식을 활용
public class assignment_4 {

    static int N, M, ans;
    static boolean[] visit;
    static List<Integer>[] graph;

    private static void input(){
        Scanner sc = new Scanner(System.in);
        String[] stringInput = sc.nextLine().split(" ");

        N = Integer.parseInt(stringInput[0]);
        M = Integer.parseInt(stringInput[1]);
        visit = new boolean[N+1];
        graph = new ArrayList[N+1];
        ans = 0;

        for(int i = 1; i <= N; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i = 0; i < M; i++){
            stringInput = sc.nextLine().split(" ");
            int nodeA = Integer.parseInt(stringInput[0]);
            int nodeB = Integer.parseInt(stringInput[1]);
            graph[nodeA].add(nodeB);
            graph[nodeB].add(nodeA);
        }
    }

    private static void bfs(int startNode){
        Queue<Integer> que = new LinkedList<>();
        que.add(startNode);

        while(!que.isEmpty()){
            int currentNode = que.poll();
            visit[startNode] = true;
            for(int nextNode : graph[currentNode]){
                if(visit[nextNode]) continue;
                visit[nextNode] = true;
                que.add(nextNode);
            }
        }
    }

    public static void main(String[] args) {
        input();
        for (int i = 1; i <= N; i++) {
            if (visit[i]) continue;
            bfs(i);
            ans++;
        }
        System.out.println(ans);
    }
}
