package lesson11.backTracking;

import java.util.*;

// 풀이핵심: 순열이란?
// * 서로다른 N개의 원소를 순서대로 나열한 것
// * 여기서 포인트는 '서로다른' 원소를 나열한 것
// * 즉, 숫자는 중복되어서는 안된다.

public class assignment_6 {

    static int length, maxNum;
    static String origin;
    static Set<Integer> used;
    static List<Integer> ans;

    private static void input(){
        Scanner sc = new Scanner(System.in);

        origin = sc.next();
        length = origin.length();
        used = new HashSet<>();
        ans = new ArrayList<>();
    }

    private static void calc(int idx) {
        if(idx >= length) return;

        int candidateNum = origin.charAt(idx) - '0';
        System.out.println(candidateNum);

        // 두자리 가능성이 존재하는 숫자 : 최소 1에서 최대 50으로 구성
        if ((1 <= candidateNum) && (candidateNum <= 5)) {
            if(idx + 1 < length){
                int candidateTwoNum = Integer.parseInt(origin.substring(idx, idx+2));
                System.out.println(candidateTwoNum);
                if (!used.contains(candidateTwoNum)){
                    maxNum = Math.max(maxNum, candidateTwoNum);
                    used.add(candidateTwoNum);
                    ans.add(candidateTwoNum);
                    calc(idx + 2);
                    return;
                }
            }
        }
        // 단일 숫자 처리
        if (candidateNum > 0){
            if(!used.contains(candidateNum)){
                maxNum = Math.max(maxNum, candidateNum);
                used.add(candidateNum);
                ans.add(candidateNum);
                calc(idx + 1);
            }
        }
    }

    private static boolean validCheck(){
        int max = used.size();
        for(int i = 1; i <= maxNum; i++){
            if(!used.contains(i)) return false;
        }
        return true;
    }

    public static void main(String[] args){
        input();
        calc(0);
        if (validCheck()){
            for(int num : ans){
                System.out.print(num + " ");
            }
        }
    }
}
