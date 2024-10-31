class Solution {
    public int solution(int [][]board) {
        int rows = board.length;
        int cols = board[0].length;
        
        int[][] dp = new int[rows][cols];
        int maxSide = 0;
        
        // DP 배열 채우기
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 1) {
                    // 테두리 처리
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } 
                    else {
                        dp[i][j] = Math.min(
                            dp[i-1][j], Math.min(
                                dp[i][j-1], dp[i-1][j-1])) + 1;
                    }
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }

        // return 최대 정사각형 넓이
        return maxSide * maxSide;
    }
}

/*
 0,1로 채워진 보드
 보드에서 1로 이루어진 가장 큰 정사각형을 찾고
 그것의 넓이를 return
*/
