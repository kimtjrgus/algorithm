import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        int time = 0;
        int index = 0;
        
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]); 
        // 요청 시간을 기준으로 작업을 정렬
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]); // 소요 시간을 기준으로 작업을 관리하는 우선순위 큐
        
        while (index < jobs.length || !pq.isEmpty()) {
            while (index < jobs.length && jobs[index][0] <= time) {
                pq.offer(jobs[index]);
                index++;
            }
            
            if (!pq.isEmpty()) {
                int[] job = pq.poll();
                answer += (time - job[0] + job[1]);
                time += job[1];
            } else {
                time = jobs[index][0];
            }
        }
        
        return answer / jobs.length;
    }
}