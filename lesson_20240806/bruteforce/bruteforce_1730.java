package lesson3.bruteforce;

import java.util.*;

// 풀이시간: 45분, 실패...
public class bruteforce_1730 {

    static int mapSize;
    static String[][] map;
    static String[] move;

    static private void input(){
        Scanner sc = new Scanner(System.in);

        mapSize = Integer.parseInt(sc.nextLine());
        map = new String[mapSize][mapSize];
        move = sc.nextLine().split("");

        for(int i = 0; i < mapSize; i++){
            for(int j = 0; j < mapSize; j++) {
                map[i][j] = ".";
            }
        }
    }

    // ##### ----- ChallengePoint ----- #####
    // * 현재 위치와 다음 예상위치를 변경하는 방식으로 진행
    // * 한번만 그리고 돌아가는 방법은 성공하나
    // * 특정 지점을 반복해서 지나가되, 방향을 다르게 지나가는 경우 몇몇 +가 제대로 표시되지 않는 문제확인ㅠ
    static private void drawMap(int x, int y, String dir) {
        if (dir.equals("U")) {
            // 현재위치
            if(map[x][y].equals("-")){
                map[x][y] = "+";
            } else {
                map[x][y] = "|";
            }
            // 다음위치
            if(x - 1 <= 0) {
                if(map[x - 1][y].equals("-")){
                    map[x - 1][y] = "+";
                } else {
                    map[x - 1][y] = "|";
                }
            }

        } else if (dir.equals("D")) {
            // 현재위치
            if(map[x][y].equals("-")){
                map[x][y] = "+";
            } else {
                map[x][y] = "|";
            }
            // 다음위치
            if(x + 1 < mapSize) {
                if(map[x + 1][y].equals("-")){
                    map[x + 1][y] = "+";
                } else {
                    map[x + 1][y] = "|";
                }
            }

        } else if (dir.equals("L")) {
            // 현재위치
            if(map[x][y].equals("|")){
                map[x][y] = "+";
            } else {
                map[x][y] = "-";
            }
            // 다음위치
            if(y - 1 >= 0) {
                if(map[x][y - 1].equals("|")){
                    map[x][y - 1] = "+";
                } else {
                    map[x][y - 1] = "-";
                }
            }

        } else if (dir.equals("R")) {
            // 현재위치
            if(map[x][y].equals("|")){
                map[x][y] = "+";
            } else {
                map[x][y] = "-";
            }
            // 다음위치
            if(y + 1 < mapSize) {
                if(map[x][y + 1].equals("|")){
                    map[x][y + 1] = "+";
                } else {
                    map[x][y + 1] = "-";
                }
            }
        }
    }

    static private void control(){
        int x = 0;
        int y = 0;

        for(int i = 0; i < move.length; i++){
            // 지도구성
            drawMap(x, y, move[i]);

            // 다음좌표 연산
            if (move[i].equals("U")) {
                if(x - 1 >= 0){
                    x--;
                }
            } else if (move[i].equals("D")) {
                if(x + 1 < mapSize){
                    x++;
                }
            } else if (move[i].equals("L")) {
                if(y - 1 >= 0){
                    y--;
                }
            } else if (move[i].equals("R")) {
                if(y + 1 < mapSize){
                    y++;
                }
            }
        }
    }

    static private void printMap(){
        for(int i = 0; i < mapSize; i++){
            for(int j = 0; j < mapSize; j++){
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        input();
        control();
        printMap();
    }
}
