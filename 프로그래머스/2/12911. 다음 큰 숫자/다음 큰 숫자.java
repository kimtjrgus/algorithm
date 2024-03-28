class Solution {
    public int solution(int n) {
        // n보다 큰 자연수, 2진수로 변환시 1의 개수 같음
        // 만족하는 수중 가장 작은 수
        int nCount = Integer.bitCount(n); // n의 2진수 1의 개수
        int answer = 0;
        
        for(int i = n+1; i<1000000; i++){
            if(Integer.bitCount(i) == nCount){
                answer = i;
                break;
            }
                
        }
        
        
        return answer;
    }
}