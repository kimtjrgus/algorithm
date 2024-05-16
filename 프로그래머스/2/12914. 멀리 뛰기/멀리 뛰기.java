class Solution {
    public long solution(int n) {
        if (n <= 0) {
            return 0;
        }

        // n까지의 경우의 수를 저장할 배열
        long[] dp = new long[n + 1];

        // 초기값 설정
        dp[0] = 1;
        dp[1] = 1;

        // 동적 계획법을 사용하여 경우의 수 계산
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1234567;
        }

        return dp[n] ;
    }
}