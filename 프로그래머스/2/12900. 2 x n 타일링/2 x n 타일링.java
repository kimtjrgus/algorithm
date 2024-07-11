class Solution {
    public int solution(int n) {
        if (n == 0) return 1;
        if (n == 1) return 1;
        
        int MOD = 1_000_000_007;
        
        // DP 배열 초기화
        long[] dp = new long[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        
        // DP 점화식 계산
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
        }
        
        return (int) dp[n];
    }
}