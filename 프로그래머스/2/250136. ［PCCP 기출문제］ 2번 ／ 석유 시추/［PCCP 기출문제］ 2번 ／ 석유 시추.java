import java.util.*;

class Solution {
    public int solution(int[][] land) {
        int n = land.length;
        int m = land[0].length;

        boolean[][] visited = new boolean[n][m]; // 방문 체크 배열
        int[] oilChunk = new int[m]; // 각 열의 석유량 배열

        // BFS로 석유 덩어리 탐색
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (land[i][j] == 1 && !visited[i][j]) {
                    List<Integer> columns = new ArrayList<>();
                    int oilSize = bfs(land, visited, n, m, i, j, columns);
                    for (int col : columns) {
                        oilChunk[col] += oilSize; // 해당 열에 석유 덩어리 크기만 추가
                    }
                }
            }
        }

        // 최대 석유량 반환
        int maxOil = 0;
        for (int oil : oilChunk) {
            maxOil = Math.max(maxOil, oil);
        }

        return maxOil;
    }

    // BFS로 석유 덩어리 크기를 계산하고, 영향을 받은 열 정보를 수집
    private int bfs(int[][] land, boolean[][] visited, int n, int m, int startX, int startY, List<Integer> columns) {
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {startX, startY});
        visited[startX][startY] = true;

        int size = 0;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            size++;
            int x = current[0];
            int y = current[1];

            // 열 정보 추가 (중복 방지)
            if (!columns.contains(y)) {
                columns.add(y);
            }

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && land[nx][ny] == 1 && !visited[nx][ny]) {
                    queue.add(new int[] {nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
        return size;
    }
}
