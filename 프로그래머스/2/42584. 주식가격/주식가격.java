class Solution {
    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n]; // 결과를 저장할 배열
        for (int i = 0; i < n; i++) {
            // 각 가격에 대해 떨어지지 않은 기간을 계산
            int count = 0;
            for (int j = i + 1; j < n; j++) {
                count++;
                if (prices[i] > prices[j]) {
                    break; // 가격이 떨어지면 반복 종료
                }
            }
            answer[i] = count; // 계산된 기간을 배열에 저장
        }
        return answer;
    }
}
/*
주식가격이 떨어지지 않은 시간은 몇초인가?
앞전 가격을 스택에 넣음. 가격이 일치할때 빼냄
각 주식가경의 카운트 배열이 필요할 것. 주식이 떨어질 때 break
*/