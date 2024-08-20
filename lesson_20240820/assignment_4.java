package lesson5.sum;

import java.util.*;

// 풀이시간: 40분
// 결과: 시간초과, 예제통과
public class assignment_4 {

    static int N, M;
    static int[] ans;
    static int[][] map;
    static int[][] coordinate;

    private static void input() {
        Scanner sc = new Scanner(System.in);
        String[] temp = sc.nextLine().split(" ");
        N = Integer.parseInt(temp[0]);
        M = Integer.parseInt(temp[1]);

        ans = new int[M];
        map = new int[N][N];
        coordinate = new int[M][4];

        for(int i = 0; i < N; i++) {
            temp = sc.nextLine().split(" ");
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(temp[j]);
            }
        }

        for(int i = 0; i < M; i++) {
            temp = sc.nextLine().split(" ");
            for(int j = 0; j < 4; j++){
                coordinate[i][j] = Integer.parseInt(temp[j]);
            }
        }
    }

    // Key Solution
    // 2차원 누적배열 구성시, 격자형태로 누적합 연산이 진행
    // 즉 1행 1열에서 행과 열과 방향으로 누적합 연산이 진행됨
    // 누접합이라면 순차적으로 합 계산이 들어가야할 것으로 처음 생각하였으나, 핵심 아이디어는 격자 형태로 풀어가는 중
    // 순차적으로 진행되어야 (r, l) 구간합을 구할때 (0,l) 구간합에서 (0, r) 구간합을 제거하는 연산이 성립되지 않나 생각됨
    // 그런데 이는 문제에서 시작 좌표에서 목표 좌표까지 순차적으로 진행하는 것이 아닌, 시작좌표 기준으로 종료좌표까지 직사각형을 그려서 연산을 하기에 그런게 아닌가 싶은..?

    private static void calc() {
        int ans = 0;
        int startCol, endCol;
        int startRow, endRow;

        for(int i = 0; i < M; i++){
            startRow = Math.min(coordinate[i][0], coordinate[i][2]);
            endRow = Math.max(coordinate[i][0], coordinate[i][2]);
            startCol = Math.min(coordinate[i][1], coordinate[i][3]);
            endCol = Math.max(coordinate[i][1], coordinate[i][3]);

            for(int j = startRow - 1; j < endRow; j++){
                for(int k = startCol - 1; k < endCol; k++){
                    ans += map[j][k];
                }
            }
            System.out.println(ans);
            ans = 0;
        }
    }

    public static void main(String[] args){
        input();
        calc();
    }
}
