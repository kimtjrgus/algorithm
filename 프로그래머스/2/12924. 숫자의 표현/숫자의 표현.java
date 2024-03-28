/*
n을 표현하는 연속된 자연수들의 합 -> 방법의 개수
@return 방법의 개수
*/
class Solution {
    public int solution(int n) {
        int answer = 0;

        for(int i = 1; i <= n; i++){
            int sum = 0;
            for(int j = i; j <= n; j++){
                sum += j;
                
                if(sum >= n){
                    if(sum == n) answer++;
                    break;
                }
            }
        }   

        return answer;
    }
}