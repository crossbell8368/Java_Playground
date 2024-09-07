package lesson10.graph;

// 풀이시간: 50분, 결과: 미완성
// 
import java.util.*;

public class assignment_8 {

    private static class Node {
        int x;
        int y;
        int height;

        public Node(int x, int y, int height){
            this.x = x;
            this.y = y;
            this.height = height;
        }
    }

    static int N, M;
    static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int[][] map;
    static boolean[] conn;
    static List<Node>[] graph;

    private static void input() {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][M];

        int height = 0;
        int nodeCount = 0;
        for(int i = 0; i < N; i++) {
            String[] stringInput = sc.nextLine().split(" ");
            for (int j = 0; j < M; j++) {
                height = Integer.parseInt(stringInput[j]);
                if (height != 0) nodeCount++;
                map[i][j] = height;
            }
        }

        graph = new ArrayList[nodeCount + 1];
        conn = new boolean[nodeCount + 1];
        for(int i = 1; i < nodeCount; i++){
            graph[i] = new ArrayList<>();
        }

        nodeCount = 0;
        for(int i  = 1; i < N-1; i++){
            for(int j = 1; j <M-1; j++){

                if(map[i][j] == 0) continue;

                nodeCount++;
                graph[nodeCount].add(new Node(i, j, map[i][j]));
                conn[nodeCount] = true;

                for(int k = 0; k < 4; k++){
                    int nearX = i + dir[i][0];
                    int nearY = j + dir[j][0];
                    if(map[nearX][nearY] != 0){

                    }

                }
            }
        }

    }

}
