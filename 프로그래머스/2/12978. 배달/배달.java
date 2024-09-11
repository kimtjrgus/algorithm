import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        // 1. 그래프를 인접 리스트로 생성
        List<int[]>[] graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 2. 도로 정보를 그래프에 추가
        for (int[] r : road) {
            int u = r[0];
            int v = r[1];
            int w = r[2];
            graph[u].add(new int[]{v, w});
            graph[v].add(new int[]{u, w});
        }

        // 3. 우선순위 큐, 다익스트라 알고리즘 초기화
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE); // 거리 초기값을 무한대로 설정
        dist[1] = 0; // 시작 마을(1번)의 거리를 0으로 설정
        pq.add(new int[]{1, 0}); // 마을 1에서 시작

        // 노드 처리
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int u = current[0];
            int currentDist = current[1];

            // 이미 더 짧은 경로가 있으면 무시
            if (currentDist > dist[u]) continue;

            // 인접한 마을들 처리
            for (int[] neighbor : graph[u]) {
                int v = neighbor[0];
                int weight = neighbor[1];
                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    pq.add(new int[]{v, dist[v]});
                }
            }
        }

        // 4. 시간 K 이내에 도달 가능한 마을의 수 계산
        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (dist[i] <= K) {
                count++;
            }
        }
        
        // 5. return count
        return count;
    }
}
// 각 마을을 연결하는 도로의 정보 road [마을1, 마을2, 시간] 
// 가중치그래프, N개의 마을 중 K시간이하로 배달
// return 음식점은 1번, 음식점이 배달 가능한 마을의 개수