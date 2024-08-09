package lesson4.sort;

import java.util.*;

// 풀이시간: 40분, 미완성...
public class sort_2910 {

    static class FreqClass {
        int num;
        int freq;

        public FreqClass(int num, int freq) {
            this.num = num;
            this.freq = freq;
        }
    }

    static int len, max;
    static int[] freq;
    static FreqClass[] labFreq;
    static int[] ary;

    private static void input(){
        Scanner sc = new Scanner(System.in);

        len = Integer.parseInt(sc.next());
        max = Integer.parseInt(sc.next());
        ary = new int[len];
        freq = new int[max];
        labFreq = new FreqClass[max];
        String[] array = sc.nextLine().split(" ");

        for(int i = 0; i < len; i++){
            int num = Integer.parseInt(array[i]);
            ary[i] = num;
            freq[num]++;
        }
    }

    private static void calc() {
        // 빈도수가 높은 대로 정렬
        for(int i = 0; i < max; i++){
            labFreq[i] = new FreqClass(i, freq[i]);
        }
        Arrays.sort(labFreq, (a, b) -> Integer.compare(a.freq, b.freq));

        for(int i = 0; i < max; i++){
            // 같은 빈도수인 경우: 먼저 나온 값을 우선출력 => 이 부분을 구성하는데 실패...ㅠ
            if(labFreq[i].freq == labFreq[i + 1].freq){
                for(int j = 0; j < len; j++){
                    if(labFreq[i].num == ary[j]){
                        System.out.print(labFreq[i].num);
                    } else if (labFreq[i + 1].num == ary[j]){

                    }
                }
            // 빈도수가 다른 경우
            } else {
                for(int j = 0; j < labFreq[i].freq; j++){
                    System.out.print(labFreq[i].num + " ");
                }
            }
        }
    }
}
