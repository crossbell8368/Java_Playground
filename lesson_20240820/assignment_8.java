package lesson5.sum;

import java.util.*;

// 풀이시간: 70분
// 결과: 시간초과, 예시통과

// #===== Key Solution =====#
// 분명 구분합 문제이지만, 우선 시뮬레이션 구현에 초점...
// map의 모든 지점의 범위를 연산하여 확인하고 있기에, 시간 복잡도는 박살난 상황
// 시간초과가 났으나, 시뮬레이션 구현결과 예시데이터는 정상적으로 나와 그나마 희망적..?
// 물론 시뮬레이션 문제풀이의 시간복잡도도 박살난 것이 함정...

public class assignment_8 {

    static int N, M, T, K, a, b;
    static String[][] map;

    private static void input(){
        Scanner sc = new Scanner(System.in);
        String[] temp = sc.nextLine().split(" ");
        N = Integer.parseInt(temp[0]);
        M = Integer.parseInt(temp[1]);
        T = Integer.parseInt(temp[2]);

        temp = sc.nextLine().split(" ");
        K = Integer.parseInt(temp[0]);
        a = Integer.parseInt(temp[1]);
        b = Integer.parseInt(temp[2]);

        map = new String[N][M];
        for(int i = 0; i < N; i++){
            temp = sc.nextLine().split("");
            for(int j = 0; j < M; j++){
                map[i][j] = temp[j];
            }
        }
    }

    private static boolean predict(int x, int y){

        // 탐사범위 정의
        // 현재 위치를 기반으로 'K' 만큼의 길이를 가진 정사각형이 탐사범위
        // 단, 해당 범위는 map을 벗어나면 안됨
        int startX = Math.max(0, x - K);
        int endX = Math.min(N - 1, x + K);
        int startY = Math.max(0, y - K);
        int endY = Math.min(M - 1, y + K);

        // 탐사범위내 존재하는 생명('*')의 갯수를 파악
        int cnt = 0;
        for(int i = startX; i <= endX; i++){
            for(int j = startY; j <= endY; j++){
                if(i == x && j == y){
                    continue;
                }
                if(map[i][j].equals("*")){
                    cnt++;
                }
            }
        }

        // 현재 위치에 생명이 존재하는지 안하는지 확인
        // 이를 기반으로 현재 위치가 앞으로 어떻게 변화할지 파악
        // true: 생명체 생존
        // false: 생명체 사망
        if (map[x][y].equals("*")) {
            if(cnt < a){
                return false;
            } else if(cnt > b){
                return false;
            } else {
                return true;
            }
        } else {
            if(cnt > a && cnt <= b){
                return true;
            } else {
                return false;
            }
        }
    }

    private static void cycle(int cnt) {
        String[][] nextMap = new String[N][M];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(predict(i, j)){
                    nextMap[i][j] = "*";
                } else {
                    nextMap[i][j] = ".";
                }
            }
        }
        map = nextMap;
    }

    private static void printMap(){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        input();
        for(int i = 0; i < T; i++){
            cycle(i);
        }
        printMap();
    }
}
