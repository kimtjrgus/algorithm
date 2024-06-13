import java.util.*;
// 현재 실행 대기 큐(Queue)에 있는 프로세스의 중요도가 순서대로 담긴 배열 priorities
// 몇 번째로 실행되는지 알고싶은 프로세스의 위치를 알려주는 location
class Solution {
    public int solution(int[] priorities, int location) {
        // 프로세스를 큐에 넣을 때 우선순위와 위치를 함께 저장합니다.
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            queue.add(new int[]{priorities[i], i});
        }
        
        int answer = 0;
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            boolean hasHigherPriority = false;
            
            for (int[] process : queue) {
                if (process[0] > current[0]) {
                    hasHigherPriority = true;
                    break;
                }
            }
            
            if (hasHigherPriority) {
                // 더 높은 우선순위가 있다면 현재 프로세스를 다시 큐에 넣습니다.
                queue.add(current);
            } else {
                // 현재 프로세스를 실행합니다.
                answer++;
                if (current[1] == location) {
                    return answer;
                }
            }
        }
        
        return answer;
    }
}