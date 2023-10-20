class Solution {
    public int solution(int n) {
        // 10진수 n -> 3진수 : 앞뒤 뒤집고 -> 10진수 answer
        StringBuilder trit = new StringBuilder();

        while (n > 0) {
            int remainder = n % 3;
            trit.append(remainder);
            n /= 3;
        }

        int answer = Integer.parseInt(trit.toString(), 3);
        
        return answer;
    }
}
