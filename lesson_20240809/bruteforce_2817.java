package lesson4.sort;

import java.util.*;

// 풀이시간: 1시간 20분.... 실패!
public class bruteforce_2817 {

    static int x, n, nCount;
    static String[] nName;
    static int[] nScore;
    static int[] nChip;
    static List<int[]> finalScore;

    private static void input() {
        Scanner sc = new Scanner(System.in);

        x = Integer.parseInt(sc.nextLine());
        n = Integer.parseInt(sc.nextLine());

        String[] inputName = new String[n];
        int[] inputScore = new int[n];

        for(int i = 0; i < n; i++){
            String[] temp = sc.nextLine().split(" ");
            inputName[i] = temp[0];
            inputScore[i] = Integer.parseInt(temp[1]);
        }
        nCount = 0;
        boolean[] nFinal = new boolean[n];
        int standard = (int)(x * 0.05);
        for(int i = 0; i < n; i++){
            if(inputScore[i] > standard){
                nFinal[i] = true;
                nCount++;
            }
        }

        nName = new String[nCount];
        nScore = new int[nCount];
        nChip = new int[nCount];
        nCount = 0;
        for(int i = 0; i < n; i++){
            if(nFinal[i]){
                nName[nCount] = inputName[i];
                nScore[nCount] = inputScore[i];
                nCount++;
            }
        }

        // ##### ----- ChallengePoint ----- #####
        // * 1차 난관... 입력받은 n 하나당 14개의 점수를 가지고 있음
        // * 모든 숫자를 정렬한 다음 상위 14개를 추출해야하는데
        // * 상위 14개의 숫자의 소유주를 모두 개별적으로 기억해야된다는 점에서, 단순 배열로는 안된다고 느낌..
        // * 그리하여 검색의 힘으로 Java에서 Dictionary 역활을 수행하는 List 자료형을 활용하기로
        // finalScore = new int[nCount * 14];
        finalScore = new ArrayList<>();
        for(int i = 0; i < nCount; i++){
            int interval = i * 14;
            for(int j = 0; j < 14; j++){
                //finalScore[j + interval] = nScore[i] / (j + 1);
                finalScore.add(new int[]{i, nScore[i] / (j + 1)});
            }
        }
        finalScore.sort((a, b) -> b[1] - a[1]);
    }

    private static void calc(){
        for(int i = 0; i < 14; i++){
            int nNum = finalScore.get(i)[0];
            nChip[nNum]++;
        }

        // ##### ----- ChallengePoint ----- #####
        // * 2차 난관, List를 활용하여 칩을 부여했으나, 이를 알파벳 순으로 또 정렬해서 보여줘야함...
        // * 이 역시 소유주와 칩의 갯수를 모두 기억해야하기에 다시 List 자료형을 사용
        // * 사용자 이름을 char으로 바꿔서 저장한 다음 다시 정렬하는 똥꼬쇼 장렬...
        int nFinalCount = 0;
        List<int[]> winner = new ArrayList<>();
        for(int i = 0; i < nCount; i++){
            if (nChip[i] > 0) {
                int word = nName[i].charAt(0);
                winner.add(new int[]{word, nChip[i]});
                nFinalCount++;
            }
        }
        winner.sort((a, b) -> a[0] - b[0]);
        for(int i = 0; i < nFinalCount; i++){
            System.out.print((char) winner.get(i)[0] + " " + winner.get(i)[1] + '\n');
        }
    }

    public static void main(String[] args) {
        input();
        calc();
    }
}
