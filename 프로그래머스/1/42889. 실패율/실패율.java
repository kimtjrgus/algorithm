import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        // answer은 실패율이 높은 스테이지, 내림차순, 길이는 N
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
        
        
        // 5. answer에 넣고 내림차순정렬
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
// 실패율 : 도달o 클리어x 유저수/ 도달한 유저수
// N : 전체 스테이지수  
// stages : 사용자가 멈춰있는 스테이지 번호가 담긴 배열 = 배열의 길이는 사용자수
// stages의 번호는 현재 도전중인 스테이지 번호