class Solution {
    public int solution(int a, int b, int n) {
        // 콜라문제
        // a를 주면 b만큼 새콜라, 빈병 n
        // n% a = 저장하고 / n/a * b 반복
        int answer = 0;
        int remain = n; // 처음에는 모든 병이 빈 병
        
        while(remain >= a){ // 빈병이 a보다 많거나 같을 때까지
            int newCola = remain / a *b; // 새 콜라 개수
            remain %= a; // 새 콜라를 사고 남은 빈 병
            remain += newCola; // 새 콜라를 마시고 남은 빈 병
            answer += newCola; // 총 콜라 개수
        }
        
        return answer;
    }
}