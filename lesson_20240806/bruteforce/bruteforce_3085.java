package lesson3.bruteforce;

import java.util.*;

// 풀이시간: 40분, 미완성
public class bruteforce_3085 {

    static int mapSize;
    static int[][] map;
    static boolean[][] startPoint;
    static int startPointCount;
    static int[] ans;

    static private void input(){
        Scanner sc = new Scanner(System.in);

        mapSize = Integer.parseInt(sc.nextLine());
        map = new int[mapSize][mapSize];
        startPoint = new boolean[mapSize][mapSize];
        startPointCount = 0;

        for(int i = 0; i < mapSize; i++){
            String[] temp = sc.nextLine().split("");

            for(int j = 0; j < mapSize; j++){
                if (temp[j].equals("C")) {
                    map[i][j] = 0;      // Red
                } else if (temp[j].equals("P")) {
                    map[i][j] = 1;      // Blue
                } else if (temp[j].equals("Z")) {
                    map[i][j] = 2;      // Green
                } else if (temp[j].equals("Y")) {
                    map[i][j] = 3;      // Yellow
                }
            }
        }
    }

    // ##### ----- ChallengePoint ----- #####
    // * 비극의 시작이지 않을까 추측...
    // * 예상 시작지점을 찾고 기록
    // * 여기서 문제점은 시작 포인트가 어느방향으로 인접한지 기록하지 않음
    // * 이에 최대 사탕의 갯수 연산 시, 인접 방향을 다시 확인해야됨
    // * 또한 예상 시작점이 중첩되는 경우에 대한 처리도 미흡..
    static private void searchStartPoint(){

        for(int i = 0; i < mapSize; i++){
            for(int j = 0; j < mapSize; j++){
                // case: N행 N열 마지막 자리
                if(i == mapSize - 1 && j == mapSize - 1){
                    break;
                // case: N열 자리
                } else if (j == mapSize - 1) {
                    if(map[i][j] != map[i + 1][j]){
                        startPoint[i][j] = true;
                        startPointCount++;
                    }
                // case: N행 자리
                } else if (i == mapSize - 1) {
                    if(map[i][j] != map[i][j + 1]){
                        startPoint[i][j] = true;
                        startPointCount++;
                    }
                // case: 나머지
                } else {
                    if(map[i][j] != map[i][j + 1] || map[i][j] != map[i + 1][j]) {
                        startPoint[i][j] = true;
                        startPointCount++;
                    }
                }
            }
        }
    }

    // ##### ----- ChallengePoint ----- #####
    // * 예상 지점의 어느 지점과 사탕의 갯수를 변경해야할지?
    // * 이전에 이미 변경한 지점인지는 어떻게 아는지?
    static private void calc(){
        ans = new int[startPointCount];

        for(int i = 0; i < mapSize; i++){
            for(int j = 0; j < mapSize; j++){

            }
        }

    }

    public static void main(String[] args){
        input();
        searchStartPoint();
        calc();
    }
}
