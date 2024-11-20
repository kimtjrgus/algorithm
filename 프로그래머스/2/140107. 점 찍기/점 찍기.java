class Solution {
    public long solution(int k, int d) {
        long answer = 0;

        // 1.x는 k의 배수로 증가
        for (int x = 0; x <= d; x += k) {
            // 가능한 y의 최대값 계산
            int maxY = (int) Math.sqrt((long) d * d - (long) x * x);
            
            // 가능한 점의 개수는 maxY / k + 1
            answer += maxY / k + 1;
        }

        return answer;
    }
}

/*
(0,0) 부터 점을 찍고, 원점과의 거리 d를 넘기지 않는다
x^2 * 2 < d^2
*/