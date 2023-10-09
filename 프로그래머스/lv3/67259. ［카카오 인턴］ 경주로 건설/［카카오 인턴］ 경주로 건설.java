import java.util.*;

class Solution {
    public int solution(int[][] board) {
        int[] dy = {-1, 0, 1, 0}, dx = {0, 1, 0, -1};
        int N = board.length;

        int[][][] cost = new int[N][N][2];
        
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                Arrays.fill(cost[i][j], (int)1e9);

        Queue<int[]> queue = new LinkedList<>();
        cost[0][0][0] = 0;
        cost[0][0][1] = 0;
        queue.add(new int[]{0, 0, 0});
        queue.add(new int[]{0, 0, 1});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int d = 0; d < 4; d++) {
                int ny = cur[0] + dy[d];
                int nx = cur[1] + dx[d];
                int nc = cost[cur[0]][cur[1]][cur[2]] + ((cur[2] + d) % 2 == 0 ? 100 : 600);
                
                if (ny < 0 || nx < 0 || ny >= N || nx >= N || board[ny][nx] == 1 || cost[ny][nx][d % 2] <= nc) continue;
                
                cost[ny][nx][d % 2] = nc;
                queue.add(new int[]{ny, nx, d % 2});
            }
        }

        int[] ans = cost[N - 1][N - 1];
        return Math.min(ans[0], ans[1]);
    }
}