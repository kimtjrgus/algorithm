class Solution {
    public int solution(long num) {
        int answer = 0;
        
        for(int i=0; i< 500; i++){
            if(num == 1) return answer = i;
            
            // 입력된 수가 짝수라면 2로 나눕니다.
            // 입력된 수가 홀수라면 3을 곱하고 1을 더합니다. 
            if(num % 2 ==0) num = num / 2;
            else num = (num * 3) + 1;
        }
        return -1;
    }
}