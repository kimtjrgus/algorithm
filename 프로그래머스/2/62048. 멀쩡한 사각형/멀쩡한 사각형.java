// 최대공약수 문제
class Solution {
    public long solution(int w, int h) {
        if(w==1 || h==1) return 0;
        long gcd = gcd(w, h);              // 최대공약수 계산
        long totalSquares = (long) w * h; // 전체 격자 개수
        long cutSquares = w + h - gcd;    // 대각선이 지나가는 격자 개수
        return totalSquares - cutSquares; // 사용 가능한 격자 개수 반환
    }
    
    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}

/*
직사각형 W * H
대각선 꼭짓점을 자르고, 이후 1*1정사각형의 개수 구하기
//
생각하기
8* 12 -> 2*3 
(0,0), (2,3), (4,6), (6,9), (8,12) 
접견 지역을 제외하고 8*12 - (2* ((2*3) -2)*(전체/비))

예외) 1*n사각형은 0개
*/
