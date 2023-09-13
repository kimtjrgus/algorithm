class Solution {
    public long solution(long n) {
        long answer = 0;
        double sqrt = Math.sqrt(n);
        
        // 제곱근이 정수인지 판별
        if(sqrt == (int)sqrt){
            // 정수라면 sqrt +1 후 제곱하여 answer 구하기
            return answer = (long)(Math.pow(sqrt + 1, 2));
        }
        else return answer = -1;
    }
}