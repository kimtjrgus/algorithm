class Solution {
    public int[] solution(long n) {
        // 입력된 숫자 n의 자릿수 계산
        int numberOfDigits = Long.toString(n).length();

        // 자릿수만큼의 배열 초기화
        int[] answer = new int[numberOfDigits];
        
        for(int i=0; i<numberOfDigits; i++){
            if(n > 0){
                answer[i] = (int)(n % 10);
                n /= 10;
            }
        }
        
        return answer;
    }
}