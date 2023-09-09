class Solution {
    public int solution(int n) {
        int x=1;
        // 나머지가 1되는 수 중 가장 작은 수
        
        for(int i=2; i<n; i++){
            if(n % i==1){
                x = i;
                break;
            } 
        }
        return x;
    }
}