class Solution {
    public long solution(int[] sequence) {
        int n = sequence.length;
        long max1 = 0;
        long max2 = 0;
        long sum1 = 0;
        long sum2 = 0;

        for (int i = 0; i < n; i++) {
            int sign1 = (i % 2 == 0) ? 1 : -1;
            int sign2 = (i % 2 == 0) ? -1 : 1;

            long value1 = sequence[i] * sign1;
            long value2 = sequence[i] * sign2;

            sum1 = Math.max(value1, sum1 + value1);
            sum2 = Math.max(value2, sum2 + value2);

            max1 = Math.max(max1, sum1);
            max2 = Math.max(max2, sum2);
        }

        return Math.max(max1, max2);
    }
}
