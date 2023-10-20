import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        // 예산은 정해져있고, 최대한 많은 부서
        // 신청한 금액 모두 지원을 해줘야함 -> 오름차순 
        // 신청금액 배열 d, 예산 budget
        int answer = 0; // 지원해준 부서의 수
        int sum = 0; // 구매한 비용
        
        Arrays.sort(d); // 오름차순 정렬
        for(int i=0; i<d.length; i++){
            budget -= d[i];
            
            if(budget < 0) break;
            
            answer++; // 예산이 남는다면 count++
        }
        
        return answer;
    }
} 