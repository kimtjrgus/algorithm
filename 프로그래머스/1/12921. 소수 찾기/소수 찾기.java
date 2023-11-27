class Solution {
    public int solution(int n) {
        if (n <= 1) return 0; // 1은 소수가 아니므로 예외 처리

        boolean[] isPrime = new boolean[n + 1];
        int answer = 0;

        // 초기화: 2부터 n까지 모든 숫자를 소수로 가정
        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }

        // 에라토스테네스의 체
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        // 소수의 개수 세기
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                answer++;
            }
        }

        return answer;
    }
    
    // 소수 체크 메서드
    public boolean isPrime(int num){
        boolean check = true;
        for(int i = 2; i <= Math.sqrt(num); i++){
            if(num % i == 0) check = false;
        }
        
        return check;
    }
}