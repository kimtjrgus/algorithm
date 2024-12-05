class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        // 1. 조건분기
        // 1사분면의 정점 구하기
        // 원의 특징 : 축을 제외한 1사분면의 정점 개수 *4
        // 정점 (r1, 1)부터 (r1, (r2^2)-r1^2의 제곱근값 이하)
        // x에 대해 가능한 y 좌표 범위 계산
        for (int x = 1; x <= r2; x++) {
            // 최대 반지름 r2에서 가능한 y 최대값
            long maxY = (long) Math.floor(
                Math.sqrt((long) r2 * r2 - (long) x * x));
            
            // 최소 반지름 r1에서 가능한 y 최소값
            long minY = (long) Math.ceil(
                Math.sqrt((long) r1 * r1 - (long) x * x));
            answer += (maxY - minY + 1);
        }
        
        answer *=4;
        
        return answer;
    }
}

/*
-반지름의 r1, r2 / 두원 사이의 공간, x,y좌표가 모두 정수인 점의 개수를 구할 것
> 
1. 조건분기 : 1)축 기준/ 2)원의 특징을 살려 제1사분면의 정점 개수 * 4
2. 2)조건 : r1, r2의 기준으로 정수인 좌표구하고, 거리구하기
            정점으로부터의 거리가 r1이상 r2이하
*/