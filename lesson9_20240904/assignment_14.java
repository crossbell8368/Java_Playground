package lesson9.recursive;

import java.util.*;

// 풀이시간: 50분, 결과: 실패...
// 음 아직도 문제를 잘 이해하고 코드를 짠건지 확실히 잘 모르겠음...
public class assignment_14 {

    static int N, M;
    static List<Integer>[] map;
    static int[] complimentPlan, complimentResult;

    private static void input() {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        map = new ArrayList[N + 1];
        complimentPlan = new int[N+1];
        complimentResult = new int[N+1];

        for(int i = 0; i <= N; i++) {
            map[i] = new ArrayList<>();
        }

        for(int i = 1; i <= N; i++){
            int boss = sc.nextInt();
            if(boss != -1){
                map[boss].add(i);
            }
        }

        for(int i = 0; i < M; i++){
            int start = sc.nextInt();
            int compliment = sc.nextInt();
            complimentPlan[start] += compliment;
        }
    }

    private static void calc(int boss, int compliment){
        for(int servant : map[boss]) {
            complimentResult[servant] += compliment;
            calc(servant, compliment);
        }
    }

    public static void main(String[] args){
        input();
        for(int i = 0; i < N; i++) {
            if(complimentPlan[i] != 0) {
                calc(i, complimentPlan[i]);
            }
        }
        for(int i = 1; i <= N; i++) {
            System.out.print(complimentResult[i] + ' ');
        }
    }
}
