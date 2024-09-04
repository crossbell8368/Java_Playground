package lesson9.recursive;

import java.util.*;

// 풀이시간: 70분, 결과: 성공..!
// 탈출조건을 설정하는데 큰 고민...
public class assignment_10 {

    static int N;
    static int[] ans;
    static List<Integer>[] tree;

    private static void input(){
        Scanner sc = new Scanner(System.in);

        N = Integer.parseInt(sc.nextLine());
        ans = new int[N + 1];
        tree = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        for(int i = 1; i < N; i++){
            int nodeA = sc.nextInt();
            int nodeB = sc.nextInt();
            tree[nodeA].add(nodeB);
            tree[nodeB].add(nodeA);
        }
    }

    private static void calc(int loc, int parent) {
        for(int node : tree[loc]) {
            if(node != parent) {
                ans[node] = loc;
                calc(node, loc);
            }
        }
    }

    public static void main(String[] args){
        input();
        calc(1, 0);
        for(int i = 2; i <= N; i++){
            System.out.println(ans[i]);
        }
    }
}
