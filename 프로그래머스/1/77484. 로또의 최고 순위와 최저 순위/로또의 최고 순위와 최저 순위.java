import java.util.*; 
/*
@param lottos   : 내가 구매한 로또번호
@param win_nums : 당첨번호
@return : 민우가 당첨 가능한 [최고순위, 최저순위] 

알아볼수 없는 번호는 -> 0 표기 (당첨번호거나, 아니거나)
같은 숫자는 없고, 정렬안되어있음
*/
class Solution {       
    public int[] solution(int[] lottos, int[] win_nums) {
        int winCount = 0; // 당첨된 수
        int zeroCount = 0; // 0의 갯수 

        // 1. lottos 에서 0을 제외한 나머지가 당첨되는지 -> 몇개매칭
        for(int lotto : lottos){
            // 2. 0의 갯수 카운트
            if(lotto == 0){
                zeroCount++; 
                continue;
            }
            else{
                for(int i= 0; i<win_nums.length; i++){
                    if(lotto == win_nums[i]){
                        winCount++;
                    }
                }
            }
        }
        
        int[] answer = new int[2];
        // 최고 순위
        answer[0] = getGrade(winCount + zeroCount);
        // 최저 순위
        answer[1] = getGrade(winCount);
        
        return answer;
    }
    
    private int getGrade(int winCount){
        int grade = -1; // -1 로 초기화
        switch(winCount){
            case 6:
                grade = 1;
                break;
            case 5:
                grade = 2;
                break;
            case 4:
                grade = 3;
                break;
            case 3:
                grade = 4;
                break;
            case 2:
                grade = 5;
                break;
            default:
                grade = 6;
                break;
        }
        
        return grade;
    }
}