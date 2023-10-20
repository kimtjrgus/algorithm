import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        // 1. 배열은 고정크기, 리스트는 가변크기
        // 리스트로 선언, 차후 배열로 변환
        ArrayList<Integer> answerList = new ArrayList<>();
        answerList.add(arr[0]);
        
        // 2. arr 배열을 반복하며 answerList 추가
        for(int i=1; i<arr.length; i++){
            if(arr[i] != arr[i-1]){ // 숫자가 반복되지 않을 경우
                answerList.add(arr[i]);
            } 
        }
               
        // answerList를 answer배열로 변환
        int[] answer = new int[answerList.size()];
        
        for(int i=0; i<answerList.size(); i++){
            answer[i] = answerList.get(i);    
        }

        return answer;
    }
}