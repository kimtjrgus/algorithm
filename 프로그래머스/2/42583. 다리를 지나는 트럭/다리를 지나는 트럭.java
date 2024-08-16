import java.util.*;

class Solution { // 다리에 올라갈 수 있는 트럭수, 다리가 견디는 무게, 트럭별 무게
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0; // 1. 모든 트럭이 건너는 최소 시간 초기화
        
        // 2. 다리 위 트럭 상태를 저장할 큐 생성 (다리의 길이만큼 0으로 초기화)
        Queue<Integer> que = new LinkedList<>();
        for (int i = 0; i < bridge_length; i++) {
            que.add(0);
        }
        
        // 3. 현재 다리 위 트럭들의 총 무게를 저장할 변수 초기화
        int current_weight = 0;
        
        // 4. 대기 중인 트럭이 있는 동안 반복
        for (int truck : truck_weights) {
            while (true) {
                // 5. 큐에서 트럭을 꺼내서 다리에서 내리게 함
                current_weight -= que.poll();
                
                // 6. 새로운 트럭을 다리에 올릴 수 있는지 확인
                if (current_weight + truck <= weight) {
                    que.add(truck);
                    current_weight += truck;
                    answer++;
                    break;
                } else {
                    // 7. 다리에 트럭을 올릴 수 없으면 0을 추가하여 대기
                    que.add(0);
                    answer++;
                }
            }
        }
        
        // 8. 모든 트럭이 다리를 건너기까지 남은 시간 추가
        answer += bridge_length;
        
        
        return answer;
    }
}

