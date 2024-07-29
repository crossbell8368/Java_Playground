package lesson;

import java.io.*;
import java.util.*;

// 풀이시간: 30분
public class string_13223 {

    static StringBuilder sb;
    static String inputCurrentTime;
    static int inputCurrentHour;
    static int inputCurrentMin;
    static int inputCurrentSec;

    static String inputTargetTime;
    static int inputTargetHour;
    static int inputTargetMin;
    static int inputTargetSec;

    static String needTime;
    static int needHour;
    static int needMin;
    static int needSec;
    static void input() {
        FastReader fr = new FastReader();
        sb = new StringBuilder();
        inputCurrentTime = fr.next();
        inputCurrentHour = 0;
        inputCurrentMin = 0;
        inputCurrentSec = 0;
        inputTargetTime = fr.next();
        inputTargetHour = 0;
        inputTargetMin = 0;
        inputTargetSec= 0;
        needTime = "";
        needHour = 0;
        needMin = 0;
        needSec = 0;
    }

    static void preprocessing() {
        String[] currentTime = inputCurrentTime.split(":");
        inputCurrentHour = Integer.parseInt(currentTime[0]);
        inputCurrentMin = Integer.parseInt(currentTime[1]);
        inputCurrentSec = Integer.parseInt(currentTime[2]);

        String[] targetTime = inputTargetTime.split(":");
        inputTargetHour = Integer.parseInt(targetTime[0]);
        inputTargetMin = Integer.parseInt(targetTime[1]);
        inputTargetSec = Integer.parseInt(targetTime[2]);
    }

    // ##### challengePoint ######
    // 풀이핵심: 시/분/초 단위로 숫자를 추출한 다음, 시간연산 수행
    // 풀이과정:
    // * 실제 시계가 동작하는 과정을 참조하여, 초 단위부터 연산을 수행
    // * 기준 숫자가 넘어갔을떄, 다음 단위에 더해주는 연산이 중요
    static void calc() {

        // sol: 초 연산
        if(inputCurrentSec > inputTargetSec) {
            needSec = 60 - inputCurrentSec;
            needSec += inputTargetSec;
            inputCurrentMin++;
        } else {
            needSec = inputTargetSec - inputCurrentSec;
        }

        // sol: 분 연산
        if(inputCurrentMin > inputTargetMin) {
            needMin = 60 - inputCurrentMin;
            needMin += inputTargetMin;
            inputCurrentHour++;
        } else {
            needMin = inputTargetMin - inputCurrentMin;
        }

        // sol: 시각 연산
        if(inputCurrentHour > inputTargetHour) {
            needHour = 24 - inputCurrentHour;
            needHour += inputTargetHour;
        } else {
            needHour = inputTargetHour - inputCurrentHour;
        }
    }

    // ##### challengePoint ######
    // 개선점:
    // * 숫자가 1의 자리일때 앞에 0을 붙이는 과정이 너무나 지져분...
    // * 다른 방법이 있을 것 같지만, 생각난 방법은 이것밖에...ㅠ
    public static void prepareOutcome() {
        if(needHour < 10){
            sb.append("0").append(needHour);
        } else {
            sb.append(needHour);
        }
        sb.append(":");

        if(needMin < 10){
            sb.append("0").append(needMin);
        } else {
            sb.append(needMin);
        }
        sb.append(":");

        if(needSec < 10){
            sb.append("0").append(needSec);
        } else {
            sb.append(needSec);
        }
        needTime = sb.toString();
    }

    public static void main(String[] args) throws IOException {
        input();
        preprocessing();
        calc();
        prepareOutcome();
        System.out.println(needTime);
    }

    static class FastReader {

        BufferedReader br;
        StringTokenizer st;

        public FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException error) {
                    error.printStackTrace();
                }
            }
            return st.nextToken();
        }
    }
}