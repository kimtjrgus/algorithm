class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 1; // 페인트칠 최소 횟수
        int paint = section[0]; // 페인트칠 시작점
        
        // 1. paint + m 이 벽 길이와 같거나 넘어갈 경우
        if(paint + m-1 >= n) return 1; 
        
        // 섹션을 순회
        for (int i = 1; i < section.length; i++) {
            // 다음 섹션이 현재 페인트 범위 내에 있는지 확인
            if (section[i] <= paint + m -1) {
                // 다음 섹션으로 건너뛰기
                continue;
            } else {
                // 롤러를 다음 섹션으로 이동
                paint = section[i];
                answer++; // 페인트 횟수 증가
            }
        }
        
//         // 마지막으로 칠한 섹션 + m이 벽 길이를 달성하거나 초과하지 않는지
//         if (paint + m < n) {
//             answer++; // 마지막 섹션에 대한 페인트 횟수 증가
//         }
        
        return answer;
    }
}
// n미터의 벽/ 롤러의 길이 m미터/ section은 칠해야할 구역
// 덧칠 해도 되는데, 벽의 좌우측 끝부분은 맞춰야함.
// answer = 페인트칠 최소 횟수.
// section의 최솟값(paint)에서 시작해서 m만큼 1번 칠하고 
// 다음원소를 확인 if(다음원소 <= paint + m) 스킵하고 다음원소
// if (다음원소 > paint + m ) paint = 다음원소
// 예외) 최솟값+m 이 n을 넘어갈 때 answer =1;