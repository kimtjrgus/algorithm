class Solution {
    public String solution(String s) {
        String answer = "";
        
        // 1. 배열 생성
        String[] numbers = s.split(" ");
        
        // 2. min max 탐색
        int min = Integer.parseInt(numbers[0]);
        int max = min;
        
        for (int i = 1; i < numbers.length; i++) {
            int n = Integer.parseInt(numbers[i]);
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