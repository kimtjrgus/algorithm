import java.util.Map;
import java.util.HashMap;

class Solution {
    public int solution(String[][] clothes) {
        // 의상이름 상관x, 의상종류만 1개씩이면 됨
        // 의상종류만 판별하여 해쉬맵에 추가
        int answer = 1;
        Map<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < clothes.length; i++) {
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1); 
        }
        
        for(String key : map.keySet()) {
            answer *= (map.get(key) + 1);   
            // 조합 -> 안입는 경우도 고려하기 위해 + 1
        }
        
        // 모두 안 입었을 경우는 없으므로 answer-1 
        answer -= 1; 
        
        return answer;
    }
}