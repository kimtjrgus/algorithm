import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        // n은 송전탑 총 개수, wires배열은 간선배열
        int answer = n;
        List<Integer>[] graph = new ArrayList[n + 1];
        
        // 그래프 초기화 및 간선 정보 추가
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] wire : wires) {
            graph[wire[0]].add(wire[1]);
            graph[wire[1]].add(wire[0]);
        }
        
        // 각 전선을 하나씩 끊어보면서 두 서브트리의 노드 개수를 계산
        for (int[] wire : wires) {
            boolean[] visited = new boolean[n + 1];
            int count1 = dfs(wire[0], wire[1], graph, visited);
            int count2 = n - count1;
            answer = Math.min(answer, Math.abs(count1 - count2));
        }
        
        return answer;
    }
    
    private int dfs(int node, int cut, List<Integer>[] graph, boolean[] visited) {
        visited[node] = true;
        int count = 1;
        
        for (int neighbor : graph[node]) {
            if (neighbor != cut && !visited[neighbor]) {
                count += dfs(neighbor, cut, graph, visited);
            }
        }
        
        return count;
    }
}