package lesson11.backTracking;

import java.util.*;

// 풀이시간: 70분, 결과: 성공..!
// 최대한 비트연산을 안하기 위해 고민하다가, 지금까지 지나온 알파벳이 안나오면 된다는 것에 중점
// 이에 중복을 허락하지않는 자료형 Set이 생각나서, 지나간 알파벳을 Set 자료형에 저장하고, 이를 확인하는 방식을 채택
public class assignment_2 {

    static int row, col, maxCount;
    static int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}}; // 오른쪽, 왼쪽, 위, 아래
    static char[][] map;
    static Set<Character> visit;

    private static void input(){
        Scanner sc = new Scanner(System.in);

        row = sc.nextInt();
        col = sc.nextInt();
        map = new char[row][col];
        visit = new HashSet<>();

        for(int i = 0; i < row; i++){
            map[i] = sc.next().toCharArray();
        }
    }

    private static void searchPath(int x, int y, int count){
        visit.add(map[x][y]);

        for(int[] dir : dirs){
            int nextX = x + dir[0];
            int nextY = y + dir[1];

            if ((nextX < 0) || (nextX >= row) || (nextY < 0) || (nextY >= col)) continue;
            if (!visit.contains(map[nextX][nextY])){
                searchPath(nextX, nextY, count + 1);
            }
        }
        maxCount = Math.max(count, maxCount);
        visit.remove(map[x][y]);
    }

    public static void main(String[] args){
        input();
        searchPath(0, 0, 1);
        System.out.println(maxCount);
    }
}
