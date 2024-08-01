package lesson2;

import java.util.*;

// 풀이시간: 30분
public class array_1236 {

    static int row, col;
    static boolean[] rowGuard;
    static boolean[] colGuard;
    static void input() {
        Scanner sc = new Scanner(System.in);
        String[] temp = sc.nextLine().split(" ");

        row = Integer.parseInt(temp[0]);
        col = Integer.parseInt(temp[1]);

        // ##### Challenge Point ######
        // * row 나 col 에 하나라도 경비원이 들어가있으면 보호를 받음
        // * 연산시간을 줄이기위해, 입력을 받음과 동시에 경비원이 존재하면 해당 row 나 col 이 보호받는다고 기록
        rowGuard = new boolean[row];
        colGuard = new boolean[col];

        for (int i = 0; i < row; i++) {
            temp = sc.nextLine().split("");

            for (int j = 0; j < col; j++) {
                if (temp[j].equals(".")) {
                    continue;
                } else if (temp[j].equals("X")) {
                    rowGuard[i] = true;
                    colGuard[j] = true;
                }
            }
        }
    }

    // ##### Challenge Point ######
    // * 보호받지 못하는 row 나 col이 관건
    // * 해당 map은 직사각형으로 이뤄져있기에, row 와 col 이 무조건 겹치게 되어있음
    // * 이에 비어있는 row 와 col 갯수를 확인하고, 겹치는 수? 까지는 모두 교차하는 지점에 배치한다고 가정
    // * 이후 추가적으로 필요한 경비원만 count
    static void calc() {
        int emptyRow = 0;
        int emptyCol = 0;

        for(int x = 0; x < row; x++){
            if(!rowGuard[x]){
                emptyRow++;
            }
        }
        for(int y = 0; y < col; y++){
            if(!colGuard[y]){
                emptyCol++;
            }
        }

        if(emptyRow > emptyCol){
            System.out.println(emptyRow);
        } else if(emptyRow < emptyCol){
            System.out.println(emptyCol);
        } else {
            System.out.println(emptyCol);
        }
    }

    public static void main(String[] args) {
        input();
        calc();
    }
}
