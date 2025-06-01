import java.util.*;

class Solution {
    public int[] solution(int n, int[][] roads, 
                          int[] sources, int destination) {
        // 1. 그래프 초기화
        List<List<Integer>> graph = new ArrayList<>(n+1);
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        // 2. 도로 정보 양방향 추가
        for (int[] road : roads) {
            graph.get(road[0]).add(road[1]);
            graph.get(road[1]).add(road[0]);
        }
        
        // 3. 각 노드까지의 최단 거리 저장(초기값 -1)
        int[] distance = new int[n + 1];
        Arrays.fill(distance, -1);
        
        // 4. BFS 시작
        Queue<Integer> que = new LinkedList<>();
        que.offer(destination);
        distance[destination] = 0;
        
        while (!que.isEmpty()) {
            int current = que.poll();
            
            for (int next : graph.get(current)) {
                if (distance[next] == -1) {
                    distance[next] = distance[current] + 1;
                    que.offer(next);
                }
            }
        }
        
        // 5. 결과 생성
        int[] answer = new int[sources.length];
        for (int i = 0; i < sources.length; i++) {
            answer[i] = distance[sources[i]];
        }
        
        return answer;
    }
}
