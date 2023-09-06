class Solution {
    public int solution(int n) {
        int answer = 0; // 약수의 합
        
        // 1. 약수를 구하기 위해 제곱근을 구해줌
        int sqrt = (int)Math.sqrt(n);
        
        // 2. 제곱근만큼 비교반복
        for(int i=1; i<=sqrt; i++){
            if(n%i==0){
                answer = answer + i;
                if(n/i != i) answer = answer + n/i;
            }
        }
        
        return answer;
    }
}