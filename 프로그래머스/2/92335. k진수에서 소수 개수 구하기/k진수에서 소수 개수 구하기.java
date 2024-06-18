class Solution {
    public int solution(int n, int k) {
        // 1. 숫자 n을 k 진수로 변환, 문자열로 저장
        String kNumber = Long.toString(n, k);
        
        // 2. k 진수 숫자 문자열을 0을 기준으로 분할하여 소수 후보 배열 생성
        String[] pArr = kNumber.split("0");
        
        // 3. 소수의 개수 pCount 선언
        int pCount = 0;
        
        for (String p : pArr) {
            // 빈 문자열 continue;
            if (p.isEmpty() || p.isBlank()) continue;
            // 4. 부분 문자열을 long 타입으로 변환하고 소수인지 판별
            if (isPrime(Long.parseLong(p))) pCount++;   
        }
        return pCount;
    }
    
    public boolean isPrime(long n) {
        if (n == 1) return false;
        if (n == 2) return true;
        
        int count = 0;
        
        for (long i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        
        return true;
    }
}