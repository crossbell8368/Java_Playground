package lesson4.sort;

import java.util.*;

// 풀이시간: 30분, 결과: 성공!
public class sort_7785 {

    static int n;
    static String[][] log;
    static Set<String> indoor;
    static String[] ans;

    private static void input(){
        Scanner sc = new Scanner(System.in);

        n = Integer.parseInt(sc.nextLine());
        indoor = new HashSet<>();
        log = new String[n][2];
        for(int i = 0; i < n; i++){
            String[] temp = sc.nextLine().split(" ");
            log[i][0] = temp[0];
            log[i][1] = temp[1];
        }
    }

    // ##### ----- ChallengePoint ----- #####
    // * 순서와 상관없이 단순 데이터를 넣고 빼는데 최적화된 자료형 Set!
    // * 여기서 난관은 남은 사람들을 사전이름 역순으로 정렬하여 출력하는 것...
    // * Set 자료형의 배열변환 및 사전역순 정렬방법은 검색으로...
    private static void calc(){
        for(int i = 0; i < n; i++){
            if(log[i][1].equals("enter")){
                indoor.add(log[i][0]);
            }
            if(log[i][1].equals("leave")){
                indoor.remove(log[i][0]);
            }
        }
        ans = indoor.toArray(new String[0]);
        Arrays.sort(ans, Collections.reverseOrder());

        for(String word : ans){
            System.out.println(word);
        }
    }
    public static void main(String[] args){
        input();
        calc();
    }
}
