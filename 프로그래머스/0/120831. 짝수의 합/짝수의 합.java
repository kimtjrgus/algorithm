class Solution {
    public int solution(int n) {
        int answer = 0;
        
        if(n % 2 !=0) n--;
        
        // 등차수열 합 공식 사용
        int m = n / 2;
        return m * (m + 1);
    }
}