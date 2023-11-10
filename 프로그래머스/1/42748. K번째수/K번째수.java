import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        // commands[]{i,j, k}  i~j 까지 자르고 정렬 후 k번째수 
        // 정답배열 선언 길이 commands.length
        int[] answer = new int[commands.length];
        
        // 1. for(commands)
        // 2. array의 {i,j,k} 구하기 
        for(int x=0; x<commands.length; x++){
            // array 의 부분 배열
            int[] parts = Arrays.copyOfRange(
                array, commands[x][0]-1, commands[x][1]);
            
            Arrays.sort(parts);
            
            answer[x] = parts[commands[x][2]-1];
        }
        
        return answer;
    }
}