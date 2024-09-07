package lesson10.graph;

import java.util.*;

// 풀이시간: 70분, 결과: 성공..!
// * 사전정렬이 필요하다는 것을 파악하는데 오랜시간이 소요
// * BFS 방식 구현과정에 상당한 시간 소요
public class assignment_2 {

    static int N, M, V;
    static boolean[] visit;
    static List<Integer>[] conn;
    static StringBuilder sb;

    private static void input() {
        Scanner sc = new Scanner(System.in);
        sb = new StringBuilder();

        String[] strinInput = sc.nextLine().split(" ");
        N = Integer.parseInt(strinInput[0]);
        M = Integer.parseInt(strinInput[1]);
        V = Integer.parseInt(strinInput[2]);
        conn = new ArrayList[N + 1];
        visit = new boolean[N + 1];

        for(int i = 1; i <= N; i++){
            conn[i] = new ArrayList<>();
        }
        for(int i = 0; i < M; i++){
            strinInput = sc.nextLine().split(" ");
            int nodeA = Integer.parseInt(strinInput[0]);
            int nodeB = Integer.parseInt(strinInput[1]);
            conn[nodeA].add(nodeB);
            conn[nodeB].add(nodeA);
        }
        // 방문할 수 있는 정점이 여러개인 경우, 정점 번호가 작은 것을 먼저 방문하기위해 사전정렬 수행
        for(int i = 1; i <= N; i++){
            Collections.sort(conn[i]);
        }
    }

    // DFS: 깊이우선 탐색방식
    // * conn 연결정보를 확인하며, 시작 Node 에서 마지막 연결 Node 까지 함수를 재귀적으로 호출하며 수행
    // * 재귀호출과 다른 부분 => 명시적인 종료조건이 없음 & 함수종료 후 초기화 부분이 없음
    //   * conn 과 visit 데이터를 활용하면, 마지막 Node 에서 for문이 자연스럽게 종료되기에 별도의 명시가 필요없음
    //   * 초기화 부분역시, 다른 경로를 탐색하기 위해서는 이전에 방문기록이 남아있어야 정상적인 경로탐색이 가능
    // * 위와같은 이유로 재귀호출과 비슷하면서도 다른 DFS 방식의 경로탐색이 진행
    private static void dfs(int startNode) {
        visit[startNode] = true;
        sb.append(startNode).append(" ");

        for(int nextNode : conn[startNode]) {
            if(visit[nextNode]) continue;
            dfs(nextNode);
        }
    }

    // BFS: 너비우선 탐색방식
    // * 선입선출 방식을 활용하기에 Queue 자료형 선언이 필수적
    // * 해당 Queue에 출발지점을 넣고, 실제 연산파트인 While 반복문 내부에서, 해당 Node 와 연결된 Node들을 que 에 추가
    // * 이후 Queue에서 연결 Node 들을 추출하며, 방문 Node를 기록
    // * 이는 하위 연결 Node로 동작하는 DFS와 달리, 연결된 모든 Node를 Queue에 넣는 동작으로 방문 순서가 달라진다.
    private static void bfs(int startNode) {
        Queue<Integer> que = new LinkedList<>();

        que.add(startNode);
        visit[startNode] = true;

        while(!que.isEmpty()){
            int currentNode = que.poll();
            sb.append(currentNode).append(" ");

            for(int nextNode : conn[currentNode]) {
                if (visit[nextNode]) continue;
                visit[nextNode] = true;
                que.add(nextNode);
            }
        }
    }

    public static void main(String[] args){
        input();
        dfs(V);
        sb.append('\n');
        visit = new boolean[N + 1];
        bfs(V);
        System.out.println(sb.toString());
    }
}
