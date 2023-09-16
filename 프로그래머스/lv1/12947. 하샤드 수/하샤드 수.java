class Solution {
    public boolean solution(int x) {       
        int digitSum = 0;
        
        int n = x; // 자릿수의 합을 구해주자
        while (n > 0) {
            int digit = n % 10; 
            digitSum += digit; 
            n /= 10;
        }
        
        return x % digitSum == 0;
    }
}