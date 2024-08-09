package lesson4.sort;
import java.util.*;
public class sort_1931 {

    static class Time {
        int start;
        int end;

        public Time(int start, int end){
            this.start = start;
            this.end = end;
        }
    }

    static int n;
    static Time[] timeTable;


    private static void input(){
        Scanner sc = new Scanner(System.in);

        n = Integer.parseInt(sc.nextLine());
        timeTable = new Time[n];

        for(int i = 0; i < n; i++){
            String[] temp = sc.nextLine().split(" ");
            timeTable[i].start = Integer.parseInt(temp[0]);
            timeTable[i].end = Integer.parseInt(temp[1]);
        }
    }

    // ##### ----- ChallengePoint ----- #####
    // * 두가지 정렬에서 한계를 느낌...
    // * 회의 종료시간이 빠른순으로 정렬하다가
    // * 이전 빠른 값과 같다면, 시작 시간이 빠른 순으로
    // * 본래 선택 정렬로 주르륵 정렬한 다음, 시간이 같은 같들끼리 모아서 다시 정렬을 진행하려고 계획
    // * 비슷한 문제에서 그냥 바로 시간초과났던 기억이 나서, 이건 글렀다라는 생각이...
    private static void calc(){
        for(int i = 0; i < n - 1; i++){
            int minTime = 0;
            for(int j = i + 1; j < n; j++){
                if(timeTable[j].end < timeTable[minTime].end){
                    minTime = j;
                }
            }

        }

    }

}
