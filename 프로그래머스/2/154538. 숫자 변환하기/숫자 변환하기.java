import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int x, int y, int n) {
        int answer = 0; // x->y 로 만들기 위한 최소연산횟수
        
        // BFS를 위한 큐 준비
        Queue<int[]> queue = new LinkedList<>();
        // 방문 여부를 확인하기 위한 배열
        boolean[] visited = new boolean[1000001];
        
        // 시작점 설정, 현재 값 x와 연산 횟수 0
        queue.add(new int[]{x, 0});
        visited[x] = true;  // 시작점 방문 처리
        
        // BFS 탐색 시작
        while (!queue.isEmpty()) {
            // 큐에서 현재 값을 꺼냄
            int[] current = queue.poll();
            int currentValue = current[0];
            int currentSteps = current[1];
            
            // 목표값 y에 도달했는지 확인
            if (currentValue == y) {
                return currentSteps;  // 현재까지의 연산 횟수 반환
            }
            
            // 가능한 다음 값 계산
            int[] nextValues = {
                currentValue + n, currentValue * 2, currentValue * 3};
            
            // 각 다음 값에 대해
            for (int nextValue : nextValues) {
                // 유효 범위 내에 있고 아직 방문하지 않았다면
                if (nextValue <= 1000000 && !visited[nextValue]) {
                    // 큐에 추가하고 방문 처리
                    queue.add(new int[]{nextValue, currentSteps + 1});
                    visited[nextValue] = true;
                }
            }
        }
        
        // y에 도달할 수 없는 경우
        return -1;
    }
}