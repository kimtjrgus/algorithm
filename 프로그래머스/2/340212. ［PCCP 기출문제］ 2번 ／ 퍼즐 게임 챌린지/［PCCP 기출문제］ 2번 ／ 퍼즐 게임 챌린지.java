class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int left = 1; // level의 최소값
        int right = 100_000; // level의 최대값
        int answer = right;
        
        while(left <= right){
            int mid = (left + right) / 2;
            
            // 현재 mid level로 제한 시간 내에 해결 가능한지 검사
            if (canSolve(diffs, times, limit, mid)){
                answer = mid; // 가능한 level 저장
                right = mid - 1; // 더 낮은 level을 탐색
            } 
            else{
                left = mid + 1; // 더 높은 level을 탐색
            }
        }
        
        // 제한시간내 퍼즐을 모두 해결하기 위한 level의 최솟값
        return answer;
    }
    
    // limit내에서 해결 가능한지 검증하는 메서드
    private boolean canSolve(int[] diffs, int[] times, 
                             long limit, int level){
        long totalTime = 0; // 전체 소요시간
        int n = diffs.length;
        
        for (int i = 0; i < n; i++){
            // level 숙련도보다 난이도가 작다면 time_cur만 추가
            if (diffs[i] <= level){
                totalTime += times[i];
            } 
            else{
                int failCount = diffs[i] - level;
                long addTime = (long)failCount * (times[i] + (i > 0 ? times[i - 1] : 0));
                totalTime += addTime + times[i];
            }

            // 제한 시간 초과 여부
            if (totalTime > limit) return false;
        }
        return true;
    }
}

/*
n개 퍼즐게임, 난이도와 소요시간이 정해져있고,
난이도 diff, 소요시간 time_cur, 이전 퍼즐 소요시간 time_prev
숙련도 level

규칙:
1) diff <= level이면 퍼즐을 틀리지않고, time_cur만큼의 시간을 할애
2) diff > level 이면 diff-level번 틀리고 틀릴때마다 time_cur만큼의 시간을 사용, time_prev만큼의 시간을 사용해 이전 퍼즐을 다시 풀고 재도전 가능
-->> (diff-level) * (time_cur + time_prev) + time_cur 

전체 제한시간 limit가 정해져있음
제한시간내 퍼즐을 모두 해결하기 위한 level의 최솟값 -> answer

>> level이 높아지면 항상 조건을 만족합니다.
level이 낮아지면 항상 조건을 만족하지 않습니다. 
>> 이진 탐색
*/
