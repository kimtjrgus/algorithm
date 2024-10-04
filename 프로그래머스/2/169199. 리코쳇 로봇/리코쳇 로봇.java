import java.util.*;

class Solution {
    static class Point {
        int x, y, distance;
        Point(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }
    
    public int solution(String[] board) {
        int n = board.length;
        int m = board[0].length();
        
        // 상, 하, 좌, 우 네 방향을 위한 좌표 변화
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        Point start = null;
        Point goal = null;

        // board를 2차원 배열로 변환
        char[][] grid = new char[n][m];
        for (int i = 0; i < n; i++) {
            grid[i] = board[i].toCharArray();
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 'R') {
                    start = new Point(i, j, 0);
                } else if (grid[i][j] == 'G') {
                    goal = new Point(i, j, 0);
                }
            }
        }

        // BFS에 사용할 방문 배열
        boolean[][] visited = new boolean[n][m];
        Queue<Point> queue = new LinkedList<>();
        
        // 시작점 큐에 삽입하고 방문 표시
        queue.add(start);
        visited[start.x][start.y] = true;

        while (!queue.isEmpty()) {
            Point current = queue.poll();
            
            // 목표 지점에 도착한 경우
            if (current.x == goal.x && current.y == goal.y) {
                return current.distance;
            }

            // 네 방향으로 탐색
            for (int i = 0; i < 4; i++) {
                int nx = current.x;
                int ny = current.y;

                // 상하좌우로 끝까지 이동
                while (isValidMove(nx + dx[i], ny + dy[i], n, m, grid)) {
                    nx += dx[i];
                    ny += dy[i];
                }

                // 새로운 위치에 대해 방문하지 않았으면 큐에 삽입
                if (!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.add(new Point(nx, ny, current.distance + 1));
                }
            }
        }

        
        return -1; // G에 도달하지 못한 경우
    }

    private boolean isValidMove(int x, int y, int n, int m, char[][] grid) {
        return x >= 0 && x < n && y >= 0 && y < m && grid[x][y] != 'D';
    }
}

/* 격자판-> dfs, bfs?
상하좌우로 움직이나, 
가장자리나 장애물에 부딪힐때까지를 한번의 이동으로 정의
도달할 수 없다면 return -1

*/