class Solution {
    public int solution(int[] number) {
        // 배열 내 원소 3개를 더해 0이 되는 경우 삼총사
        // 순서상관x sum이 0이 되는 5개중 3개 조합
        // 삼총사가 되는 경우의 수 answer 
        int answer = 0;
        
        for(int i = 0; i < number.length; i++) {
            for(int j = i + 1; j < number.length; j++) {
                for(int k = j + 1; k < number.length; k++) {
                    if(number[i] + number[j] + number[k] == 0) {
                        answer++;
                    }
                }
            }
        }
        
        return answer;
    }
}
