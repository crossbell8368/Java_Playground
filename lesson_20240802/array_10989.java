package lesson2;

import java.util.*;

// 풀이시간: 15분
public class array_10989 {
    static int testCase;
    static int[] nums;

    static void input(){
        Scanner sc = new Scanner(System.in);
        testCase = Integer.parseInt(sc.next());
        nums = new int[testCase];

        for(int i = 0; i < testCase; i++){
            nums[i] = Integer.parseInt(sc.next());
        }
    }

    // ##### Challenge Point ######
    // * 많은 정렬들을 배웠으나... 기억에 남는건 버블 하나뿐..ㅠ
    static void calc(){
        int length = testCase - 1;

        for(int i = 0; i < length; i++){
            for(int j = 0 ; j < length - i; j++){
                if(nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args){
        input();
        calc();
        for(int i = 0; i < testCase; i++){
            System.out.println(nums[i]);
        }
    }
}
