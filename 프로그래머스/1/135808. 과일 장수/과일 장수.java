import java.util.Arrays;

class Solution {
    public int solution(int k, int m, int[] score) {
        // 사과의 점수 1~k/ m은 1개 상자에 담을 사과개수
        // 가장낮은점수가 p일 때 사과상자가격 p*m 
        // 얻을 수 있는 최대이익. 
        // 1. 상자당 m개씩 나누기. 나머지 버려야함
        int boxNum = score.length / m;
        int answer = 0;
        
        // 2. 내림차순 정렬
        Arrays.sort(score);
        
        // 3. 갯수가 나누어 떨어질 때
        if(score.length % m == 0) {
            for(int i = 0; i < boxNum; i++) {
                answer += (score[i * m]) * m * 1;
            }
        } 
        else { // 4. 나누어 떨어지지 않을 때 
            int rest = score.length % m;
            for(int i = 0; i < boxNum; i++) {
                answer += (score[rest + (i * m)]) * m * 1;
            }
        }
        
        return answer;
    }
}