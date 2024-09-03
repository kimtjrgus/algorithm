class Solution {
    public String solution(int n) {
        // 3의 배수 -> 4로 끝남
        // n을 3으로 나눈 몫에 -1 한 후 4이상일시 다시 124진법
        // 12-> 44 / 15-> 114
        String[] num = {"4", "1", "2"};
        String answer = "";
        
        while (n > 0) {
            answer = num[n % 3] + answer;
            n = (n - 1) / 3;
        }
        
        return answer;
    }
}