import java.util.*;

class Solution {
    public int solution(String dirs) {
        // 현재 위치 (5,5)에서 시작 -> (좌표를 -5 -> 0 으로 봄)
        int x = 5, y = 5;
        
        // 각 방향 선언
        String directionChars = "UDLR";
        int[][] directions = {
            {0, 1},  // U
            {0, -1}, // D
            {-1, 0}, // L
            {1, 0}   // R
        };
        
        // 방문한 길을 추적할 Set
        Set<String> visitedPaths = new HashSet<>();
        
        // 순회하며 경로를 갱신
        for (char dir : dirs.toCharArray()) {
            int directionIndex = directionChars.indexOf(dir);
            int nx = x + directions[directionIndex][0];
            int ny = y + directions[directionIndex][1];
            
            // 경계를 벗어나면 무시
            if (nx < 0 || nx > 10 || ny < 0 || ny > 10) continue;
            
            // 현재 위치에서 다음 위치로의 경로를 추가
            String path1 = x + "" + y + "" + nx + "" + ny;
            String path2 = nx + "" + ny + "" + x + "" + y;
            visitedPaths.add(path1);
            visitedPaths.add(path2);
            
            // 현재 위치 업데이트
            x = nx;
            y = ny;
        }
        
        // 방문한 길의 개수를 반환
        return visitedPaths.size() / 2;
    }
}