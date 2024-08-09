package lesson4.sort;

import java.util.*;

// 풀이시간: 30분, 결과: 제한시간 초과...
public class sort_10814 {

    static int n;
    static int[] ages;
    static int[] orders;
    static String[] names;

    private static void input(){
        Scanner sc = new Scanner(System.in);

        n = Integer.parseInt(sc.nextLine());
        ages = new int[n];
        orders = new int[n];
        names = new String[n];

        for(int i = 0; i < n; i++){
            String[] temp = sc.nextLine().split(" ");
            ages[i] = Integer.parseInt(temp[0]);
            orders[i] = i;
            names[i] = temp[1];
        }
    }

    // ##### ----- ChallengePoint ----- #####
    // * 문제를 풀고 난 다음, 힌트를 보고 아 클래스로 묶어줘야 했나 싶음...
    // * 개별 배열로 연산을 하다보니, 각각 3개의 배열을 정렬하면서 시간 복잡도가 작살난것으로 보임
    // * 게다가 정렬방식이 선택정렬이라, 정렬방식의 시간복잡도고 굉장히 높은상황
    private static void calc() {

        for(int i = 0; i < n - 1; i++){
            int firstUser = i;
            for(int j = i + 1; j < n; j++){
                if (ages[j] < ages[firstUser]){
                    firstUser = j;
                } else if (ages[j] == ages[firstUser]) {
                    if(orders[j] < orders[firstUser]){
                        firstUser = j;
                    }
                }
            }
            int tempAge = ages[firstUser];
            int tempOrder = orders[firstUser];
            String tempName = names[firstUser];

            ages[firstUser] = ages[i];
            orders[firstUser] = orders[i];
            names[firstUser] = names[i];

            ages[i] = tempAge;
            orders[i] = tempOrder;
            names[i] = tempName;
        }

        for(int i = 0; i < n; i++){
            System.out.print(ages[i] + " " + names[i] + '\n');
        }
    }

    public static void main(String[] argss){
        input();
        calc();
    }
}
