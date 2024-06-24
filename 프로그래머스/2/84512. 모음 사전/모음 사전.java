import java.util.*;
class Solution {
    List<String> dict;
    String[] alphabet = {"A", "E", "I", "O", "U"};
    
    public int solution(String word) {
        dict = new ArrayList<>();
        
        dfs("");
        
        // 순번을 나타내야하므로 +1
        return dict.indexOf(word) + 1;
    }
    
    private void dfs(String str){
        // 빈 문자열이 아닌 경우에만 리스트에 추가
        if (!str.isEmpty()) {
            dict.add(str);
        }

        if(str.length() >= alphabet.length) {
            return;
        }

        for (String a : alphabet) {
            dfs(str + a);
        }
    }
}