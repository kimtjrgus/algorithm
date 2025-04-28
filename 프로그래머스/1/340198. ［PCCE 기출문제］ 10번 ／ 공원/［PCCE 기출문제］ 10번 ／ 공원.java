import java.util.*;

class Solution {
    public int solution(int[] mats, String[][] park) {
        int answer = -1; // 지민의 가장 큰 돗자리 한 변 길이
        int n = park.length;
        int m = park[0].length;
        
        // 1. mats[] 오름차순 정렬, 길이만큼 반복
        Arrays.sort(mats);
        for(int i=mats.length -1; i>= 0; i--){
            int size = mats[i];
            
            // 2. park배열 순회하며 size만큼의 자리가 가능한지 체크
            if (checkPlace(size, park, n, m)) {
                // 3. 적합 할 경우 answer= size; break;
                answer = size;
                break;
            }
        }
        
        return answer;
    }
    
    private boolean checkPlace(int size, String[][] park, int n, int m) {
        // (i,j)를 왼쪽 위 꼭짓점으로 하는 size x size 정사각형이 가능한지 확인
        for (int i = 0; i <= n - size; i++) {
            for (int j = 0; j <= m - size; j++) {
                if (isEmpty(i, j, size, park)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isEmpty(int x, int y, int size, String[][] park) {
        // (x,y) 부터 size x size 구간이 모두 "-1"인지 확인
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (!park[i][j].equals("-1")) {
                    return false;
                }
            }
        }
        return true;
    }
}