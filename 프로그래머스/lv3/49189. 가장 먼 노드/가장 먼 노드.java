import java.util.*;
class Solution {
    public int solution(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Integer>());
        }
        
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        int[] distance = new int[n + 1];
        
        queue.add(1);
        visited[1] = true;
        
        int maxDistance = 0;
        
        while (!queue.isEmpty()) {
            int node = queue.poll();
            
            for (int neighbor : graph.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    distance[neighbor] = distance[node] + 1;
                    maxDistance = distance[neighbor];
                    queue.add(neighbor);
                }
            }
        }
        
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (distance[i] == maxDistance) {
                count++;
            }
        }
        
        return count;
    }
}