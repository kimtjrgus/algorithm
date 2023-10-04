class Solution {
    public String solution(String s) {
        String answer = "";
        
        // 글자수가 홀, 짝의 경우를 나눠 생각
        // 홀수일 경우
        if(s.length() % 2 != 0) answer += s.charAt(s.length()/2);
        
        // 짝수일 경우
        else{
            answer += s.charAt(s.length()/2-1);
            answer += s.charAt(s.length()/2);
        }
        
        return answer;
    }
}