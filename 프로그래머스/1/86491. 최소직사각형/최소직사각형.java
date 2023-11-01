class Solution {
    public int solution(int[][] sizes) {
        // 최적해 찾기 
        // 지갑의 크기 가로x세로 = answer 
        int max_w = 0; // 가로
        int max_h = 0; // 세로
        
        // sizes[][] =  {[긴,짧] , ...}통일
        for(int i=0; i<sizes.length; i++){
            int width = Math.max(sizes[i][0], sizes[i][1]);
            int height = Math.min(sizes[i][0], sizes[i][1]);
            max_w = Math.max(width, max_w);
            max_h = Math.max(height, max_h);
        }
        
        int answer = max_w * max_h;
        
        return answer;
    }
}