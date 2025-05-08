class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        // greedy : 트럭 하나로 모든 배달과 수거를 마치고 
        // 물류창고까지 돌아올 수 있는 최소 이동 거리를 return 
        // 처음 갈때 가장 멀리 가서 배달, 수거하는 것이 가장 효과적
        int d = 0; // 배달한 양
        int p = 0; // 수거한 양
        for(int i=n-1; i>=0; i--){
            d -= deliveries[i];
            p -= pickups[i];
            
            while(d < 0 || p < 0){
                d += cap;
                p += cap;
                answer += (i+1)*2; // 가고 오는 거리기 때문에 *2
            }
        }
        
        return answer;
    }
}