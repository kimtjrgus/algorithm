class Solution {
    int answer = 0;
    
    public int solution(int[] numbers, int target) {
        dfs(numbers, 0, target, 0);
        
        return answer;
    }
    
    public void dfs(int[] numbers, int depth, int target, int sum){
	// numbers : 알고리즘을 실행할 대상 배열
	// depth : 노드의 깊이
	// target : 타겟 넘버
	// sum : 이전 노드 까지의 결과 값
        if(depth == numbers.length){ // 마지막 노드까지 탐색한 경우
            if(target == sum) answer++;    
        }
        else{
            // 해당 노드의 값을 더하고 다음 깊이 탐색
            dfs(numbers, depth +1, target, sum +numbers[depth]);
            
            // 해당 노드의 값을 빼고 다음 깊이 탐색
            dfs(numbers, depth +1, target, sum -numbers[depth]);
        }
    }
}

// 깊이 우선 탐색 알고리즘을 이용
// 마지막 노드까지 탐색했을 때 타겟 넘버와 결과값이 같으면 정답 카운트 증가