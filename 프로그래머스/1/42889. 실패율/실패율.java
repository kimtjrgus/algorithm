import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        // answer은 실패율이 높은 스테이지, 실패율 높은 순, 길이는 N
        // 1. 길이 N의 정답배열 선언, 초기화
        int[] answer = new int[N]; 
        Arrays.fill(answer, 0);
        
        // 2.실패율 저장할 맵 선언
        // 3. 도달한 플레이어 수/ 실패한 플레이어 수 구함
        Map<Integer, Double> failureMap = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            double total = 0;
            double fail = 0;
            for (int j = 0; j < stages.length; j++) {
                if(i <= stages[j]) total++;
                if(i == stages[j]) fail++;
            }
            if(total == 0 && fail == 0) total = 1;
            
            // 4. 실패율 매핑
            failureMap.put(i, fail/total);
        }
        
        
        // 5. 실패율이 높은 순 정리
        for (int i = 0; i < N; i++) {
            double maxFailure = -1;
            int maxStage = 0;

            for (int stage : failureMap.keySet()) {
                if (failureMap.get(stage) > maxFailure) {
                    maxFailure = failureMap.get(stage);
                    maxStage = stage;
                }
            }

            answer[i] = maxStage;
            failureMap.remove(maxStage);
        }
        
        // 6. return 
        return answer;
    }
}