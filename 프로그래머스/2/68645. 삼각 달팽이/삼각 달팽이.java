import java.util.*;

class Solution {
    public int[] solution(int n) {
        int[] answer = new int[(n*(n+1))/2]; // 1D 배열의 크기: 1~ n 합
        int[][] snail = new int[n][n]; // n x n 2D 배열
        
        int num = 1;  // 1부터 시작
        int x = -1, y = 0;  // 시작 위치는 왼쪽 상단의 바로 위
        int direction = 0;  // 0: 아래, 1: 오른쪽, 2: 대각선 위
        
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (direction == 0) {  // 아래로 이동
                    x++;
                } else if (direction == 1) {  // 오른쪽으로 이동
                    y++;
                } else if (direction == 2) {  // 대각선 위로 이동
                    x--;
                    y--;
                }
                snail[x][y] = num++;  // 현재 숫자를 할당하고 증가
            }
            direction = (direction + 1) % 3;  // 방향 전환
        }
        
        // 2D 달팽이 배열을 1D 배열로 변환
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                answer[index++] = snail[i][j];
            }
        }
        
        return answer;
    }
}