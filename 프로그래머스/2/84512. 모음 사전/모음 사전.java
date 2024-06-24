import java.util.*;

class Solution {
    List<String> dict;
    String[] alphabet = {"A", "E", "I", "O", "U"};
    int targetIndex;
    boolean found;
    
    public int solution(String word) {
        dict = new ArrayList<>(3125); // 5^5 = 3125, 최대 크기 설정
        found = false;

        dfs("", word);

        return targetIndex+1;
    }
    
    private void dfs(String str, String target) {
        if (str.length() > 0) {
            dict.add(str);
            if (str.equals(target)) {
                targetIndex = dict.size() - 1;
                found = true;
                return;
            }
        }

        if (str.length() >= 5 || found) {
            return;
        }

        for (String alpha : alphabet) {
            dfs(str + alpha, target);
            if (found) {
                return;
            }
        }
    }
}