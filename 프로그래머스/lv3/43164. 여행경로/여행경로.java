import java.util.*;

class Solution {
    boolean[] visited;
    ArrayList<String> allRoute; 
    
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        int cnt = 0;
        visited = new boolean[tickets.length];
        allRoute = new ArrayList<>();
        
        dfs("ICN", "ICN", tickets, cnt);
        
        Collections.sort(allRoute);
        answer = allRoute.get(0).split(" ");
        
        return answer;
    }
    
    public void dfs(String start, String route, String[][] tickets, int cnt){
        if(cnt == tickets.length){
            allRoute.add(route);
            return;
        }
        
        for(int i=0; i<tickets.length; i++){
            if(start.equals(tickets[i][0]) && !visited[i]){
                visited[i] = true;
                dfs(tickets[i][1], route+" "+tickets[i][1], tickets, cnt+1);
                visited[i] = false;
            }
        }
    }
    
}



// return 방문하는 공항 경로 배열
// tickets[출발, 도착] // 주어진 항공권은 모두 사용해야함 필수
// 경로가 두개 이상일 경우 알파벳 순서로 먼저감
// 모든 도시를 방문 할 수 없는 경우는 없음