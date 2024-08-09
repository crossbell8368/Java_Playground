package lesson4.sort;

import java.util.*;

// 풀이시간: 50분, 문제번호를 잘못 봄...
public class bruteforce_2187 {

    static int N, A, B, ans;
    static Target[] targetList;

    public static class Target {
        int r, c, s;

        public Target(int r, int c, int s){
            this.r = r;
            this.c = c;
            this.s = s;
        }
    }

    static private void input(){
        Scanner sc = new Scanner(System.in);

        N = Integer.parseInt(sc.next());
        A = Integer.parseInt(sc.next());
        B = Integer.parseInt(sc.next());
        targetList = new Target[N];
        ans = 0;

        for(int i = 0; i < N; i ++){
            String[] temp = sc.nextLine().split(" ");
            int r = Integer.parseInt(temp[0]);
            int c = Integer.parseInt(temp[1]);
            int s = Integer.parseInt(temp[2]);

            targetList[i] = new Target(r, c ,s);
        }
    }

    static private void calc(Target std) {
        Target[] tempList = new Target[A*B];
        int maxRightR = 0;
        int maxLeftR = 0;
        int maxC = 0;

        // case: std right
        if(std.c + A <= 2000000 &&
                std.r + B <= 2000000
        ) {
            maxRightR = std.r + A;
        }
        if(std.r - B <= 1) {
            maxLeftR = std.r - A;
        }

        if(std.c + A <= 2000000){
            maxC = std.c + A;
        } else {
            return;
        }


    }

    static private int calcMax(int startC, int endC, int startR, int endR, int s){
        int minNum = Integer.MAX_VALUE;
        int maxNum = Integer.MIN_VALUE;

        int cnt = 1;
        int[] inBoxList = new int[A * B];
        inBoxList[0] = s;

        for(int i = 0; i < N; i++){
            if((targetList[i].c >= startC) &&
                    (targetList[i].c <= endC) &&
                    (targetList[i].r >= startR) &&
                    (targetList[i].r <= endR)
            ){
                inBoxList[cnt] = targetList[i].s;
                cnt++;
            }
        }

        for(int i = 0; i < cnt; i++){
            if(inBoxList[i] > maxNum){
                maxNum = inBoxList[i];
            }
            if(inBoxList[i] < minNum){
                minNum = inBoxList[i];
            }
        }
        return maxNum - minNum;
    }

}


