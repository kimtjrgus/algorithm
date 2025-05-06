class Solution {
    public String solution(String video_len, String pos, 
                           String op_start, String op_end, String[] commands) {
        // 변수 형식 "mm:ss" 5글자 String -> mm분 ss초
        // String변수를 분초로 변환해 줄 메서드 필요
        // 현위치가 op 중간지점이라면 자동으로 스킵, commands 명령어 수행 후 위치 출력
        int[] secTable = new int[4]; //{video_len, pos, (op_start, op_end}
        secTable[0] = timeToSec(video_len);
        secTable[1] = timeToSec(pos); 
        secTable[2] = timeToSec(op_start);
        secTable[3] = timeToSec(op_end);
        
        int curSec = secTable[1]; // current 현위치
        // if pos가 op중간이라면 op_end까지 자동스킵
        if(secTable[1] >= secTable[2] & secTable[1] <= secTable[3]){
            curSec = secTable[3];
        }
        
        for(String com : commands){
            if(com.equals("next")){
                curSec = curSec + 10;
                
                // if curSec가 op중간이라면 op_end까지 자동스킵
                if(curSec >= secTable[2] & curSec <= secTable[3]){
                    curSec = secTable[3];
                }
                
                // 예외처리 : 10초 뒤로 돌렸으나, 영상 끝에 다랐을 경우
                if(curSec > secTable[0]) curSec = secTable[0];
            } 
            
            else if(com.equals("prev")){
                curSec = curSec - 10;
                
                // if 10초 뒤로 돌렸는데 0초보다 적을 경우 
                if(curSec < 0) curSec = 0;
                
                // if curSec가 op중간이라면 op_end까지 자동스킵
                if(curSec >= secTable[2] & curSec <= secTable[3]){
                    curSec = secTable[3];
                }
            } 
        }
        
        return secToTime(curSec);
    }
    
    // String변수 mm:ss -> 시간 변환 메서드
    private int timeToSec(String time){
        String[] arr = time.split(":");
    
        return Integer.parseInt(arr[0]) * 60 + Integer.parseInt(arr[1]);
    }
    
    private String secToTime(int seconds){
        int min = seconds / 60;
        int sec = seconds % 60;
        
        return String.format("%02d:%02d", min, sec);
    }
}