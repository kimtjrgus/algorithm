class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 1; // 페인트칠 최소 횟수
        int paint = section[0]; // 페인트칠 시작점
        
        // 1. 섹션을 순회
        for (int i : section) {
            // 2. 다음 섹션이 현재 페인트 범위 내에 있는지 확인
            if (i <= paint + m -1) {
                // 3. 다음 섹션으로 건너뛰기
                continue;
            } else {
                // 4. 롤러를 다음 섹션으로 이동
                paint = i;
                answer++; // 페인트 횟수 증가
            }
        }
        return answer;
    }
}