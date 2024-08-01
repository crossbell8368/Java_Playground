package lesson2;

import java.util.*;
import java.io.*;

// 풀이시간: 40분... 실패!
public class array_10158 {

    static int wide, height;
    static int prevX, prevY, x, y, nextX, nextY;
    static int finTime;
    static int[][] dir = {{1, 1}, {-1, 1}, {-1, -1}, {-1, 1}};
    static void input(){
        Scanner sc = new Scanner(System.in);
        wide = Integer.parseInt(sc.next());
        height = Integer.parseInt(sc.next());
        x = Integer.parseInt(sc.next());
        y =  Integer.parseInt(sc.next());
        finTime = Integer.parseInt(sc.next());
    }

    static void calc(int x, int y) {
        for(int time = 0; time < finTime; time++) {
            if(x < wide && y < height) {
                nextX = x + dir[0][0];
                nextY = y + dir[0][1];
            }
        }

    }

    // ##### Challenge Point ######
    // * 이리저리 짱구를 굴려보았으나... 이전 진행방향에따라 벽에 부딪혔을때 다음 진행방향이 바뀌는 공식이 나오지 않음...
    // * 뭔가 나올것 같은데.. 같은데 하다가 실패...ㅠ
    static void dir(int x, int y) {
        // 초기 시작방향
        if(prevX == 0 && prevY == 0) {
            nextX = x + 1;
            nextY = y + 1;

        // 45도 방향
        } else if (prevX > x && prevY > y) {
            nextX = x + 1;
            nextY = y + 1;

        // 135도 방향
        } else if (prevX < x && prevY > y) {

        }

        int nextX = 0;
        int nextY = 0;

        if((x < wide) && (y < height)) {
            nextX = x + 1;
            nextY = y + 1;
        } else if((x == wide) && (y < height)) {
            nextX = x - 1;
            nextY = y + 1;
        } else if((x == wide) && (y == height)) {
            nextX = x - 1;
            nextY = y - 1;
        }
        // 방향전환: 왼쪽 벽
        if((nextX > wide) && (nextY < height)) {

            nextX = x - 1;
            nextY = y + 1;

        // 방향전환: 위쪽 벽 (오른쪽/왼쪽)
        } else if ((nextX < wide) && (nextY > height)) {

        // 방향전환: 위쪽 구석
        } else if ((nextX == wide) && (nextY == height)) {

        // 방향전환: 오른쪽 벽
        } else if ((nextX < 0) && (nextY > 0)) {

        // 방향전환: 아래쪽 벽
        } else if ((nextX > 0) && (nextY < 0)) {

        // 방향전환: 아래쪽 구석
        } else if ((nextX == 0) && (nextY == 0)) {

        }
    }

    public static void main(String[] args) {
        input();
    }
}
