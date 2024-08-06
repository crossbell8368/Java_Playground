package lesson3.bruteforce;

import java.util.*;

// 풀이시간: 30분, 성공
public class bruteforce_10250 {

    static int testCase;
    static int[][] infos;
    static String[][] hotels;

    static private void input() {
        Scanner sc = new Scanner(System.in);

        testCase = Integer.parseInt(sc.nextLine());
        infos = new int[testCase][3];

        for(int i = 0; i < testCase; i++){
            String[] temp = sc.nextLine().split(" ");
            for(int j = 0; j < 3; j++){
                infos[i][j] = Integer.parseInt(temp[j]);
            }
        }
    }

    static private void structHotel(int testCase) {
        int height = infos[testCase][0];
        int width = infos[testCase][1];
        hotels = new String[height][width];

        for(int i = 1; i <= height; i++){
            for(int j = 1; j <= width; j++){
                String room = String.valueOf(i);
                if(j < 10) {
                    room = room + 0 + j;
                } else {
                    room = room + j;
                }
                hotels[i - 1][j - 1] = room;
            }
        }
    }

    // ##### ----- ChallengePoint ----- #####
    // * 엘리베이터에 가까운 순서(width 값이 0에 가까운 순서)부터 방을 배정
    // * 입력받은 손님일때 방 번호를 return
    static private void searchRoom(int testCase){
        int height = infos[testCase][0];
        int width = infos[testCase][1];
        int num = infos[testCase][2];

        for(int j = 0; j < width; j++){
            for(int i = 0; i < height; i++){
                if(num == 1){
                    System.out.println(hotels[i][j]);
                    return;
                }
                num--;
            }
        }
    }

    public static void main(String[] args){
        input();
        for(int i = 0; i < testCase; i++){
            structHotel(i);
            searchRoom(i);
        }
    }
}
