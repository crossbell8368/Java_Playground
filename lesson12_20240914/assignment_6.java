package lesson12.divide;

import java.util.*;

// 풀이시간: 40분, 결과: 실패
// 예제도 이상하게 나오지만... 어디섭부터 손을 대야할지 알기 어렵...
public class assignment_6 {

    static int n;
    static int[][] map;
    static StringBuilder sb;

    private static void input(){
        Scanner sc = new Scanner(System.in);
        sb = new StringBuilder();
        n = sc.nextInt();
        map = new int[n][n];

        for(int i = 0; i < n; i++){
            char[] temp = sc.next().toCharArray();
            for(int j = 0; j < n; j++){
                map[i][j] = temp[j] - '0';
            }
        }
    }

    private static void calc(int x, int y, int length) {

        int half = length / 2;
        sb.append("(");

        // 1사분면
        int count_1 = 0;
        int count_0 = 0;
        for(int i = 0; i < half; i++){
            for(int j = 0; j < half; j++){
                if (map[i][j] == 1) count_1++;
                if (map[i][j] == 0) count_0++;
            }
        }
        if (count_1 != 0 && count_0 != 0){
            calc(x, y, half);
        } else {
            if (count_1 == half * half) sb.append("1");
            if (count_0 == half * half) sb.append("0");
        }

        // 2사분면
        count_1 = 0;
        count_0 = 0;
        for(int i = half; i < length; i++){
            for(int j = 0; j < half; j++){
                if (map[i][j] == 1) count_1++;
                if (map[i][j] == 0) count_0++;
            }
        }
        if (count_1 != 0 && count_0 != 0){
            calc(x + half, y, half);
        } else {
            if (count_1 == half * half) sb.append("1");
            if (count_0 == half * half) sb.append("0");
        }

        // 3사분면
        count_1 = 0;
        count_0 = 0;
        for(int i = 0; i < half; i++){
            for(int j = half; j < length; j++){
                if (map[i][j] == 1) count_1++;
                if (map[i][j] == 0) count_0++;
            }
        }
        if (count_1 != 0 && count_0 != 0){
            calc(x, y +half, half);
        } else {
            if (count_1 == half * half) sb.append("1");
            if (count_0 == half * half) sb.append("0");
        }

        // 4사분면
        count_1 = 0;
        count_0 = 0;
        for(int i = half; i < length; i++){
            for(int j = half; j < length; j++){
                if (map[i][j] == 1) count_1++;
                if (map[i][j] == 0) count_0++;
            }
        }
        if (count_1 != 0 && count_0 != 0){
            calc(x + half, y + half, half);
        } else {
            if (count_1 == half * half) sb.append("1");
            if (count_0 == half * half) sb.append("0");
        }
        sb.append(")");
    }

    public static void main(String[] args){
        input();
        calc(0,0,n);
        System.out.println(sb.toString());
    }
}
