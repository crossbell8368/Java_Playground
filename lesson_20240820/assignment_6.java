package lesson5.sum;

import java.util.*;

// 풀이시간: 40분
// 결과: 시간초과, 예제통과
public class assignment_6 {

    static int N, M;
    static int[] H;
    static int[][] inst;

    private static void input(){
        Scanner sc = new Scanner(System.in);
        String[] temp = sc.nextLine().split(" ");
        N = Integer.parseInt(temp[0]);
        M = Integer.parseInt(temp[1]);
        H = new int[N + 1];
        inst = new int[M][3];

        temp = sc.nextLine().split(" ");
        for(int i = 0; i < N; i++){
            H[i + 1] = Integer.parseInt(temp[i]);
        }

        for(int i = 0; i < M; i++){
            temp = sc.nextLine().split(" ");
            for(int j = 0; j < 3; j++){
                inst[i][j] = Integer.parseInt(temp[j]);
            }
        }
    }

    // 기존 풀이내용 (시간초과)
    private static void calc(int start, int end, int val) {
        for(int i = start; i <= end; i++){
            H[i] += val;
        }
    }

    // ##### 차이배열
    // * 해당 문제의 시간복잡도 감소를 위해서는 '차이배열' 활용이 필요
    // * 차이배열은 값의 변화가 시작하고 끝나는 지점을 기록
    //   - 시작과 끝 사이는 동일한 값 변화가 일어나기에 기록할 필요X
    //   - 단, 끝나는 값의 경우 값의 변화가 끝났기에 시작값을 빼주는 값을 대입
    // * 끝나는 부분에 시작값을 빼주는 부분이 이해되지 않았으나, 이를 기반으로 누적합을 구하는 과정을 보고 그 필요성을 확인
    //   - 즉, 차이 배열에 모든 지시사항을 기록하고, 이를 누적합 배열로 만들어 기존의 H배열과 더하는 연산을 하면 시간복잡도 축소가 가능
    //   - 코드를 구성하고나니, 이전 5번 과제를 코드로 바꾼 것이였음..!
    // 그러나 차이배열을 써도 시간초과ㅋㅋㅋㅋㅋㅋㅋ... 이게 맞나.... 너무한게 아닌가...

    private static void calcDiff() {
        // + 1: 1부터 시작하는 index 구성을 적용
        // + 1: 마지막 배열까지 값의 변화가 존재하는 경우, 마지막 배열 + 1 위치에 더한값을 빼줘야 하기에
        int[] diff = new int[N + 2];

        // 차이배열 구성
        for(int i = 0; i < M; i++){
            diff[inst[i][0]] += inst[i][2];
            diff[inst[i][1] + 1] -= inst[i][2];
        }

        // 차이배열의 누적합 배열
        for(int i = 1; i < diff.length; i++){
            diff[i] += diff[i - 1];
        }

        for(int i = 1; i <= N; i++){
            H[i] += diff[i];
        }
    }


    public static void main(String[] args){
        input();
        calcDiff();
        //for(int i = 0; i < M; i++){
        //    calc(inst[i][0], inst[i][1], inst[i][2]);
        //}

        for(int i = 1; i <= N; i++){
            System.out.print(H[i] + " ");
        }
    }
}
