import java.util.LinkedList;
import java.util.Queue;

class Solution {
    // 상, 하, 좌, 우로 이동할 수 있는 방향 벡터
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};
    
    public int solution(String[] maps) {
        // 레버를 당겨야 출구가 열림. visited
        // 출구칸을 지나갈 순 있지만, 레버를 당기지 않았다면 탈출x
        // 한칸당 1초 소요
        // maps >> S : 시작 지점 ,E : 출구 ,L : 레버 ,O : 통로, X : 벽
        
        // 1. visited 배열 선언 및 초기화
        int n = maps.length;        // 맵의 행 크기
        int m = maps[0].length();   // 맵의 열 크기

        // 시작점, 레버, 출구 좌표 찾기
        int[] start = findPosition(maps, 'S', n, m);
        int[] lever = findPosition(maps, 'L', n, m);
        int[] exit = findPosition(maps, 'E', n, m);

        // 1. S -> L로 가는 경로 찾기
        int stepsToLever = bfs(maps, start[0], start[1], lever[0], lever[1], n, m);
        if (stepsToLever == -1) {
            return -1; // 레버에 도달할 수 없으면 실패
        }

        // 2. L -> E로 가는 경로 찾기
        int stepsToExit = bfs(maps, lever[0], lever[1], exit[0], exit[1], n, m);
        if (stepsToExit == -1) {
            return -1; // 출구에 도달할 수 없으면 실패
        }

        // 총 경로 반환 (S -> L -> E)
        return stepsToLever + stepsToExit;
    }
    
    // 특정 문자가 있는 좌표를 찾는 메서드 (문자가 반드시 존재함)
    private int[] findPosition(String[] maps, char target, 
                               int n, int m) { 
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (maps[i].charAt(j) == target) {
                    return new int[]{i, j};  // target 좌표 반환
                }
            }
        }
        
        return null; // 이론적으로 실행되지 않음
    }
    
    // BFS를 사용한 최단 경로 탐색
    private int bfs(String[] maps, int startX, int startY, int targetX, int targetY, int n, int m) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];

        queue.add(new int[]{startX, startY, 0});
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int steps = current[2];

            // 목표 지점에 도달하면 경로 반환
            if (x == targetX && y == targetY) {
                return steps;
            }

            // 4방향 탐색
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 맵을 벗어나지 않고, 벽이 아니며, 방문하지 않은 곳으로 이동
                if (nx >= 0 && ny >= 0 && nx < n && ny < m && maps[nx].charAt(ny) != 'X' && !visited[nx][ny]) {
                    queue.add(new int[]{nx, ny, steps + 1});
                    visited[nx][ny] = true;
                }
            }
        }

        // 목표 지점에 도달할 수 없으면 -1 반환
        return -1;
    }
}
