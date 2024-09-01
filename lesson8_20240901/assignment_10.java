package lesson8.stack;

import java.util.*;
// 풀이시간: 30분, 결과: 미완성ㅠ
// Queue 를 어디서 써야되나 고민하다가...
public class assignment_10 {

    static int t, n;
    static String p;
    static int[] ary;
    static StringBuilder sb;

    private static void input(Scanner sc) {
        sb = new StringBuilder();
        p = sc.nextLine();
        n = Integer.parseInt(sc.nextLine());
        ary = new int[n];

        String first = sc.nextLine();
        String second = first.substring(1, first.length() - 1);
        String[] third = second.split(",");
        for(int i = 0; i < n; i++){
            ary[i] = Integer.parseInt(third[i]);
        }

    }

    private static void calc() {
        int rCount = 0;
        int dCount = 0;
        String[] temp = p.split("");

        for(String word : temp){
            if (word.equals("R")){
                rCount++;
            } else if (word.equals("D")){
                dCount++;
            }
        }

        if (rCount % 2 == 0) {
            if (ary.length != 0) {

            }
        }

    }

    private static void pushFront(int drop) {
        for(int i = drop; i < n; i++){
        }
    }
}
