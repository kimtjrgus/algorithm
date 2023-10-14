class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];

        // 두 수 중 큰 수와 작은 수를 찾기
        int a = Math.max(n, m);
        int b = Math.min(n, m);

        // 유클리드 호제법을 이용하여 최대공약수 구하기
        int gcd = getGCD(a, b);

        // 최소공배수 구하기
        int lcm = (n * m) / gcd;

        answer[0] = gcd;
        answer[1] = lcm;

        return answer;
    }

// 유클리드 호제법을 사용하여 최대공약수 구하는 함수
    public int getGCD(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
            }
        return a;
    }
}
// 