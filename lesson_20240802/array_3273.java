package lesson2;

import java.util.*;
public class array_3273 {

    static int arraySize;
    static int[] array;
    static int targetNum;
    static int ans;

    static void input(){
        Scanner sc = new Scanner(System.in);
        arraySize = Integer.parseInt(sc.nextLine());
        String[] temp = sc.nextLine().split(" ");
        array = new int[arraySize];

        // ##### Challenge Point ######
        // * String[] 자료형을 int[] 바로 변환하는게 있을것 같은데..
        // * 기억나는 건 그저 반복문..ㅠ
        for(int i = 0; i < arraySize; i++){
            array[i] = Integer.parseInt(temp[i]);
        }
        targetNum = Integer.parseInt(sc.next());
    }

    static void sort(){
        int length = arraySize - 1;

        for(int i = 0; i < length; i++){
            for(int j = 0; j < length - i; j++){
                if(array[i] > array[i + 1]){
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }
            }
        }
    }

    // ##### Challenge Point ######
    // * 현재 로직은 굉장히 비효율적이라 생각
    // * 정렬하는데 n제곱, 값을 찾는데 n제곱...
    static void calc(){
        for(int i = 0; i < arraySize - 1; i++){
            for(int j = i + 1; j < arraySize; j++){
                if(array[i] + array[j] == targetNum){
                    ans++;
                }
            }
        }
    }

    public static void main(String[] args) {
        input();
        sort();
        calc();
        System.out.println(ans);
    }


}
