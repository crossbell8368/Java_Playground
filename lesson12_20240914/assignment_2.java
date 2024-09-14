package lesson12.divide;

import java.util.*;

// 풀이시간: 40분, 결과: 시간초과....
// 단일 for문인데...
public class assignment_2 {

    static long a, b, c, result;

    private static void input() {
        Scanner sc = new Scanner(System.in);
        result = 1;
        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();
    }

    private static void calc() {
        for(int i = 0; i < b; i++){
            result = (result * a) % c;
        }
    }

    public static void main(String[] args){
        input();
        calc();
        System.out.println(result);
    }
}
