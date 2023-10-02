import java.util.*;

class Solution {
    public int solution(int n, int[][] costs) {
        // 1. 비용을 기준으로 costs 배열을 정렬
        Arrays.sort(costs, (a,b) -> Integer.compare(a[2], b[2]));
        
        // 2. 각 섬의 부모 노드를 저장할 배열 초기화
        int[] parent = new int[n];
        for(int i=0; i<n; i++){
            parent[i] = i;
        }
        
        int minCost = 0; // 최소 비용을 저장할 변수 초기화
        int bridges = 0; // 연결된 다리의 수 초기화
        
        for (int[] cost : costs) {
            int a = cost[0];
            int b = cost[1];
            int costValue = cost[2];
            
            if (find(parent, a) != find(parent, b)) {
                // 사이클을 형성하지 않으면 다리 연결
                union(parent, a, b);
                minCost += costValue;
                bridges++;
                if (bridges == n - 1) {
                    break;
                }
            }
        }

        return minCost;
    }
    
    public int find(int[] parent, int node) {
        if (parent[node] == node) {
            return node;
        }
        parent[node] = find(parent, parent[node]);
        return parent[node];
    }

    public void union(int[] parent, int a, int b) {
        int rootA = find(parent, a);
        int rootB = find(parent, b);
        if (rootA != rootB) {
            parent[rootA] = rootB;
        }
    }
}