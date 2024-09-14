package lesson12.divide;

import java.util.*;

// 풀이시간: 50분, 결과: 실패..
// 인자값을 조정해야될 것 같은데... 무엇이 문제인지...
public class assignment_8 {

    static int n, ans1, ans0, ans01;
    static int[][] map;

    private static void input(){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        map = new int [n][n];
        ans1 = 0;
        ans0 = 0;
        ans01 = 0;

        sc.nextLine();
        for(int i = 0; i < n; i++){
            String[] temp = sc.nextLine().split(" ");
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(temp[j]);
            }
        }
    }

    private static void calc(int x, int y, int length){

       if (isSameNum(x, y, length)) {
           int currentNum = map[x][y];
           if (currentNum == 1) ans1++;
           if (currentNum == 0) ans0++;
           if (currentNum == -1) ans01++;
       } else {
           int nextLength = length / 3;

           calc(x, y, nextLength);
           calc(x + 3, y, nextLength);
           calc(x + 6, y, nextLength);

           calc(x, y + 3, nextLength);
           calc(x + 3, y + 3, nextLength);
           calc(x + 6, y + 3, nextLength);

           calc(x, y + 6, nextLength);
           calc(x + 3, y + 6, nextLength);
           calc(x + 6, y + 6, nextLength);
       }
    }

    private static boolean isSameNum(int x, int y, int len){
        int currentNum = map[x][y];
        int maxX = x + len - 1;
        int maxY = y + len - 1;
        for(int i = x; i < maxX; i++){
            for(int j = y; j < maxY; j++){
                if (map[i][j] != currentNum) return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        input();
        calc(0, 0, n);
        System.out.println(ans01);
        System.out.println(ans0);
        System.out.println(ans1);
    }
}
