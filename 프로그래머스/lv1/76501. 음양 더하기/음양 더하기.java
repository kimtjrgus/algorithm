class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        
        for (int i = 0; i < absolutes.length; i++) {
            if (signs[i]) {
                // signs[i]가 참(양수)이면 absolutes[i]를 더합니다.
                answer += absolutes[i];
            } else {
                // signs[i]가 거짓(음수)이면 absolutes[i]를 뺍니다.
                answer -= absolutes[i];
            }
        }
        
        return answer;
    }
}