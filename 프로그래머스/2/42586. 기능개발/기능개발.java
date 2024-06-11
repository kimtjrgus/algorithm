import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        // 작업순서에 따라 배포가능, 후순위가 먼저 완성되어도 배포불가
        // 작업 완료 일수에 대한 큐를 구현, 
        // 첫 작업이 완료될 때 같이 완료되어 배포되는 작업들을 선별,
        // 정답배열에 반영
        
        // 1. 작업 완료 일수에 대한 큐 구현
        Queue<Integer> daysQueue = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            int days = 
                (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);
            daysQueue.add(days);
        }
        
        // 3. 배포 결과를 저장할 리스트 생성
        List<Integer> result = new ArrayList<>();
        
        // 4. 큐를 순회하며 배포 그룹화
        while (!daysQueue.isEmpty()) {
            // 4.1. 첫 번째 작업의 완료 일수를 기준으로 설정
            int currentDay = daysQueue.poll();
            int count = 1;
            
            // 4.2. 큐에 있는 작업들을 검사, 배포 기준일 내에 완료되는 작업들 그룹화
            while (!daysQueue.isEmpty() && daysQueue.peek() <= currentDay) {
                daysQueue.poll();
                count++;
            }
            
            // 4.3. 배포된 작업의 수를 결과 리스트에 추가
            result.add(count);
        }
        
        // 5. 결과 리스트를 배열로 변환하여 반환
        return result.stream().mapToInt(i -> i).toArray();
    }
}