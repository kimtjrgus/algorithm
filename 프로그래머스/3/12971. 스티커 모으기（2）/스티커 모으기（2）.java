class Solution {
    public int solution(int[] sticker) {
        int n = sticker.length;

        // 예외 처리: 스티커가 1개일 경우
        if (n == 1) return sticker[0];

        // Case 1: 0번째 포함, n-1번째 미포함
        int[] dp1 = new int[n];
        dp1[0] = sticker[0];
        dp1[1] = sticker[0];
        for (int i = 2; i < n - 1; i++) {
            dp1[i] = Math.max(dp1[i - 1], dp1[i - 2] + sticker[i]);
        }

        // Case 2: 0번째 미포함, n-1번째 포함 가능
        int[] dp2 = new int[n];
        dp2[0] = 0;
        dp2[1] = sticker[1];
        for (int i = 2; i < n; i++) {
            dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + sticker[i]);
        }

        return Math.max(dp1[n - 2], dp2[n - 1]);
    }
}