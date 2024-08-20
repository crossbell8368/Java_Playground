package lesson5.sum;

import java.util.*;

// 풀이시간: 30분
// 결과: 시간초과, 예시통과

// #===== Key Solution =====#
// 일단은 풀어보기위해 BruteForce 방식으로 값을 추출
// 그렇게 하니 역시나 바아로 시간초과
// 힌트를 반영해서 조합을 바꿔보려고 했으나... 음 sum 값을 구하려면 일단 3개의 값을 다 구해야 하는게 아닌가..?

public class assignment_12 {

    static int N, ans;
    static int[] ary;
    static HashSet<Integer> set;

    private static void input(){
        Scanner sc = new Scanner(System.in);
        N = Integer.parseInt(sc.nextLine());
        ans = 0;
        ary = new int[N];
        set = new HashSet<>();

        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(sc.nextLine());
            set.add(num);
            ary[i] = num;
        }
    }

    private static void calc() {
        for(int i = 0; i < N; i++){
            for(int j = i + 1; j < N; j++){
                for(int k = j + 1; k < N; k++){
                    int sum = ary[i] + ary[j] + ary[k];
                    if(set.contains(sum)){
                        ans = Math.max(ans, sum);
                    }
                }
            }
        }
    }

    public static void main(String[] args){
        input();
        calc();
        System.out.println(ans);
    }
}
