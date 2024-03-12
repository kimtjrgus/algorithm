/**
 [01 02 03]
 [04 05 06]
 [07 08 09]
L[10 11 12]R
*/
class Solution {
    public String solution(int[] numbers, String hand) {
        // 거리가 같다면, hand의 right, left 기준
        // 시작은 *(=10), #(=12) 
        
        StringBuilder answer = new StringBuilder();
        // 1. 초기 left, right값을 10, 12로 초기화
        int left = 10; // *
        int right = 12; // #
        
        // 2. num ==0 이라면 num = 11
        for(int num : numbers){
           if(num==0) num = 11;
            
            switch(num % 3){
                case 0: // R
                    answer.append("R");
                    right = num;
                    break;
                case 1: // L
                    answer.append("L");
                    left = num;
                    break;
                case 2: // 거리계산 후 hand 여부에 따라 조건문
                    // 3. 번호간 거리계산
                    int distanceLeft = calculateDistance(left, num);
                    int distanceRight = calculateDistance(right, num);
                    
                    if(distanceLeft < distanceRight){
                        answer.append("L");
                        left = num;
                    } else if(distanceLeft > distanceRight){
                        answer.append("R");
                        right = num;
                    } else {
                        if(hand.equals("left")){
                            answer.append("L");
                            left = num;
                        } else {
                            answer.append("R");
                            right = num;
                        }
                    }
                    break;
            }
        }
        
        return answer.toString();
    }
    
    private int calculateDistance(int start, int target){
        // 절대값을 이용하여 거리 계산
        start -= 1; // 배열 인덱스 맞추기 위해 1 감소
        target -= 1; // 배열 인덱스 맞추기 위해 1 감소
        int startX = start % 3;
        int startY = start / 3;
        int targetX = target % 3;
        int targetY = target / 3;
        
        return Math.abs(startX - targetX) + Math.abs(startY - targetY);
    }
}
