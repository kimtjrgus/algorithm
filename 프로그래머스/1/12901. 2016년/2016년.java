class Solution {
    public String solution(int a, int b) {
        // 윤년 2월 29일 
        // (1,3,5,7,8,10,12 31일)(4,6,9,11 30일)
        // a월 b일까지의 총 일수 구하고 그 요일.
        String[] days = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
        Integer[] months = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        String answer = "";
        int total = 0;
        
        // a월 b일까지의 총 일수
        for(int i=0; i<a-1; i++){
            total += months[i];
        }
        total += b-1;
        
        // 1월1일이 금요일이니 days[5]부터 시작.
        answer = days[(total + 5) % 7];
        
        return answer;
    }
}