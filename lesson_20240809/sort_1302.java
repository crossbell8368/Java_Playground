package lesson4.sort;

import java.util.*;

public class sort_1302 {

    static int n;
    static HashMap<String, Integer> sales;


    // ##### ----- ChallengePoint ----- #####
    // * 종류를 알 수 없이 들어오는 책들의 갯수를 저장하고 정렬해야하는 문제.
    // * 순서와 상관없이 다양한 책의 이름들이 들어온다고 가정하여, Dictionary 자료형인 HashMap 사용을 결정
    // * 그런데... 이렇게 쌓인 데이터를 Value값을 기준으로 정렬하여 보여줘야 하는데
    // * 그 방법을 보니, 영 실전에서 써먹기는 글러먹은 것 같음ㅠ 다른 방식이 있는지 궁금...ㅠ
    private static void input(){
        Scanner sc = new Scanner(System.in);
        sales = new HashMap<>();

        for(int i = 0; i < n; i++){
            String temp = sc.nextLine();
            if(!sales.containsKey(temp)){
                sales.put(temp, 1);
            } else {
                sales.put(temp, sales.get(temp) + 1);
            }
        }
    }


}
