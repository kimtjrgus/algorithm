/*
1차원 배열 wallpaper 원소길이 == 바탕화면길이
#은 파일위치

위치좌표를 찍고, min max를 구함 end점은 +1 씩 해주면 될듯?
*/
class Solution {
    public int[] solution(String[] wallpaper) {
        // 1. 드래그를 시작하기 위한 최소,최대값 점 초기화
        int minX = Integer.MAX_VALUE; 
        int minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE; 
        int maxY = Integer.MIN_VALUE;
        
        // 2. 각점의 인덱스값을 구함
        // wallpaper 배열에서 파일위치 추출 ...#..
        for(int i = 0; i < wallpaper.length; i++){
            String curFileLine = wallpaper[i];
            
            for(int j = 0; j < curFileLine.length(); j++) {
                if(curFileLine.charAt(j) == '#') {
                    // minX, minY, maxX, maxY 업데이트
                    minX = Math.min(minX, j);
                    minY = Math.min(minY, i);
                    maxX = Math.max(maxX, j);
                    maxY = Math.max(maxY, i);
                }
            }
        }
        
        // 3. max는 +1 씩(제일 외부를 포함시켜야하므로)
        int[] answer = {minY, minX, maxY + 1, maxX + 1};
        
        return answer;
    }
}