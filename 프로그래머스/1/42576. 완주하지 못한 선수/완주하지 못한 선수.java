import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        // comp는 part보다 길이 1 짧음
        // 동명이인이 있을 수 있음. 1명만 체크하라는 뜻인듯
        String answer = ""; // answer = 완주 못한 선수
        
        // 1. 해시맵에 part 추가 key는 선수, value는 선수카운트
        HashMap<String, Integer> map = new HashMap<>();
        for(String p : participant){
            map.put(p, map.getOrDefault(p, 0) + 1);
        }
        // 2. comp를 반복, 완주했으면 카운트 마이너스
        for(String p : completion){
            map.put(p, map.get(p) - 1);
        }
        
        // 3. value가 0이 아닌 선수 1명만 남으니 return
        for(String key : map.keySet()){
            if(map.get(key) != 0){
                answer = key;
            }
        }
        return answer;
    }
}
    