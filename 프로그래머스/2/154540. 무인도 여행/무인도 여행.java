import java.util.*;

class Solution {
    public int[] solution(String[] maps) {
        int[] dx = {-1, 1, 0, 0}; // 상하 좌우 이동을 위한 배열
        int[] dy = {0, 0, -1, 1};
        int n = maps.length; // 지도의 행 길이
        int m = maps[0].length(); // 지도의 열 길이
        boolean[][] visited = new boolean[n][m]; // 방문 여부 체크 배열
        List<Integer> islands = new ArrayList<>(); // 섬에서 머무를 수 있는 일수를 저장할 리스트
        
        // 지도에서 각 칸을 탐색
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 바다('X')가 아니고, 아직 방문하지 않은 칸이면 DFS 탐색 시작
                if (maps[i].charAt(j) != 'X' && !visited[i][j]) {
                    islands.add(dfs(maps, visited, i, j, dx, dy));
                }
            }
        }
        
        // 섬이 없으면 -1 반환
        if (islands.isEmpty()) {
            return new int[]{-1};
        }
        
        // 섬에서 머무를 수 있는 일수를 오름차순으로 정렬
        Collections.sort(islands);
        
        // 리스트를 배열로 변환하여 반환
        return islands.stream().mapToInt(i -> i).toArray();
    }
    
    // DFS 탐색 함수: 한 섬에서 머무를 수 있는 최대 일수를 계산
    private int dfs(String[] maps, boolean[][] visited, int x, int y, int[] dx, int[] dy) {
        int n = maps.length;
        int m = maps[0].length();
        visited[x][y] = true; // 현재 위치 방문 처리
        int days = maps[x].charAt(y) - '0'; // 현재 위치의 식량을 일수로 변환
        
        // 상하좌우로 이동하면서 섬 탐색
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            // 범위를 벗어나지 않고, 바다가 아니며, 아직 방문하지 않은 경우에만 탐색
            if (nx >= 0 && nx < n && ny >= 0 && ny < m && maps[nx].charAt(ny) != 'X' && !visited[nx][ny]) {
                days += dfs(maps, visited, nx, ny, dx, dy); // 인접한 섬의 식량을 더해줌
            }
        }
        
        return days;
    }
}
