package lesson2;

import java.util.*;
public class array_10431 {
    static int length = 20;
    static int testCase;
    static int[][] students;
    static int moveCount;

    static void input(){
        Scanner sc = new Scanner(System.in);
        testCase = Integer.parseInt(sc.nextLine());
        students = new int[testCase][length];
        for(int i = 0; i < testCase; i++){
            String[] temp = sc.nextLine().split(" ");
            for(int j = 1; j <= length; j++){
                students[i][j - 1] = Inㅂteger.parseInt(temp[j]);
            }
        }
    }
    /*
    static void sort(int index){
        int[] tempArray = new int[index];
        for(int i = 0; i < index; i++){
            tempArray[i] = students[0][i];
        }
        for(int i = 0; i < index - 1; i++){
            for(int j = 0; j < index - 1 - i; j++){
                if(tempArray[j] > tempArray[j + 1]){
                    int temp = tempArray[j];
                    tempArray[j] = tempArray[j + 1];
                    tempArray[j + 1] = temp;
                }
            }
        }
    }
    */

    // ##### Challenge Point ######
    // * 앞에있는 학생들 중에서, 바로 본인 다음으로 큰 친구 찾기 로직을 구성하는데 실패...
    // * 따로 배열을 뜯어서 정렬한다음에 바로 내 다음 값을 찾을까 싶기도 했는데, 이러헥 되면 배열이 조금만 길어져도 시간복잡도 박살이라고 생각하여 포기...ㅠ
    static void calc(int[] array) {
        for(int i = 1; i < length; i++){
            int nextStd = array[i];
            for(int j = 0; j < i; j++){
                if(array[j] > array[i]){
                }
            }
        }

    }

    public static void main(String[] args) {
        input();
    }
}
