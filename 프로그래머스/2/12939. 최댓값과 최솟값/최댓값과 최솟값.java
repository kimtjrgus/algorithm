class Solution {
    public String solution(String s) {
        String answer = "";
        
        // 1. 배열 생성
        String[] numbers = s.split(" ");
        
        // 2. min max 탐색
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for (String num : numbers) {
            int n = Integer.parseInt(num);
            if (n < min) {
                min = n;
            }
            if (n > max) {
                max = n;
            }
        }
        // 3. 문자열 생성
        answer = min + " " + max;
        
        return answer;
    }
}