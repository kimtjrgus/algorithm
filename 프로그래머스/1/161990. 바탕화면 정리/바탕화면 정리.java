/*
1차원 배열 wallpaper 원소길이 == 바탕화면길이
#은 파일위치

위치좌표를 찍고, min max를 구함 end점은 +1 씩 해주면 될듯?
*/
class Solution {
    public int[] solution(String[] wallpaper) {
        // 1. 드래그를 시작하기 위한 최소,최대값 점 초기화
        int lux = Integer.MAX_VALUE; 
        int luy = Integer.MAX_VALUE;
        int rdx = Integer.MIN_VALUE; 
        int rdy = Integer.MIN_VALUE;
        
        // 2. 각점의 인덱스값을 구함
        // wallpaper 배열에서 파일위치 추출
        for(int i = 0; i < wallpaper.length; i++){
            for(int j = 0; j < wallpaper[i].length(); j++) {
                if(wallpaper[i].charAt(j) == '#') {
                    // lux, minY, maxX, maxY 업데이트
                    lux = Math.min(lux, j);
                    luy = Math.min(luy, i);
                    rdx = Math.max(rdx, j);
                    rdy = Math.max(rdy, i);
                }
            }
        }
        
        // 3. max는 +1 씩(제일 외부를 포함시켜야하므로)
        int[] answer = {luy, lux, rdy + 1, rdx + 1};
        
        return answer;
    }
}