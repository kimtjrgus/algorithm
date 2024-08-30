class Solution {
    public int solution(int storey) {
        int answer = 0;

        while (storey > 0) {
            int digit = storey % 10; 
            storey /= 10; 

            if (digit > 5) {
                answer += (10 - digit);
                storey += 1; 
            } 
            else if (digit == 5 && storey % 10 >= 5) {
                answer += digit;
                storey += 1;
            } 
            else {
                answer += digit;
            }
        }

        return answer;
    }
}