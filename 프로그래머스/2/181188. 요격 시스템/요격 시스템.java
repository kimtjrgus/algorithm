import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        int intercept = -1;
        
        // 1. 끝값을 기준으로 오름차순 정렬
        Arrays.sort(targets, (o1, o2) -> o1[1] - o2[1]);
        
        // 2. 하나의 타겟 내 가장 뒤쪽을 요격 intercept 갱신
        for(int[] target : targets){
            if(intercept == -1){ 
                answer++;
                intercept = target[1] -1;
                continue;
            }
            
            // 3. 다음 타겟에서 해당 요격이 유효하다면 continue
            if(intercept >= target[0] && intercept < target[1]){
                continue;
            }
            // 4. 유효하지 않다면 answer++, intercept 갱신
            else{
                answer++;
                intercept = target[1] -1;
            }
        }

        return answer;
    }
}

/*
A는 미사일을 최소로 사용해서 모든 폭격 미사일을 요격하려 합니다.
A의 미사일은 x축에 평행, 개구간 (s,e) s<  <e
B의 미사일은 y축에 수평, 특정 x좌표 출발

// 1. 규칙찾기
B나라는 실수좌표 가능
실수 a일때 최대로 많이 요격 가능한 구간을 구함.
1. 끝점 e를 기준으로 오름차순 정렬
2. 처음 요격기의 값을 0으로 초기화
끝점으로 오름차순 정렬된 미사일의 시작점을 요격기의 값과 비교
2-1. 미사일의 시작점 값이 요격기 값 이상일 때, 
요격기의 값을 해당 미사일의 끝점으로 업데이트, 요격기의 개수를 추가
3. 미사일 개수만큼 2의 과정을 반복
*/