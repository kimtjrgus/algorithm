import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        // 인덱스 두개를 비교해서 반복될 경우 제거할건데 어떤식으로 제거할까
        // 새 배열에 추가하는 식이 좋을거같네
        // arr 배열을 비교하고 answer배열에 추가하는 식. let's go
        // 1. 해답이 될 answer 배열 선언
        ArrayList<Integer> answerList = new ArrayList<>();
        answerList.add(arr[0]);
        
        // 2. arr 배열을 반복하며 answer배열에 추가
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