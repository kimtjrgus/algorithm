import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        // length가 1 일때와 아닐 때
        if(arr.length -1 == 0) return new int[]{-1};
        
        // 선언
        int[] answer = new int[arr.length-1];
        int idx = 0;
        
        // 배열내 가장 작은 수 찾기
        int min = Arrays.stream(arr).min().getAsInt();
        
        // min 제외하고 answer에 추가
        for(int i=0; i<arr.length; i++){
            if(arr[i] != min){
                answer[idx++] = arr[i];
            }
        }
        return answer;
    }
}