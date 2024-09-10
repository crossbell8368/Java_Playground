package lesson11.backTracking;

import java.util.*;

// 풀이시간: 30분, 결과: 미완성
// 이리저리 머리를 굴려봐도 탐지된 부분이 정사각형인지, 어느정도의 크기의 정사각형인지 판단하는 부분이 그려지지 않음..
public class assignment_4 {

    static int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}}; // 오른쪽, 왼쪽, 위, 아래
    static int[][] map;
    static boolean[][] check;

    private static void input() {
        Scanner sc = new Scanner(System.in);

        for(int i = 0; i < 10; i++){
            String[] temp = sc.nextLine().split(" ");
            for(int j = 0; j < 10; j++){
                map[i][j] = Integer.parseInt(temp[j]);
            }
        }
    }

    // * 예상 풀이과정
    // * DFS 나 BFS 로 1인 부분을 탐색
    // * 탐색된 부분이 색종이로 가려지는 확인
    //   * 탐색부분이 정사각형인지 확인필요
    //   * 정사각형인데 몇 by 몇 크기인지도 확인이 필요
    // * 탐색한 부분이 정사각형인지 판별하는 부분의 로직이 전혀 감이 안오는...ㅠ
    private static void mapCheck() {

    }

}
