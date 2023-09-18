import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(String[] user_id, String[] banned_id) {
        Set<Set<String>> combinations = new HashSet<>();
        boolean[] visited = new boolean[user_id.length];
        generateCombinations(user_id, banned_id, combinations, new HashSet<>(), visited, 0);
        return combinations.size();
    }
    
    private void generateCombinations(String[] user_id, String[] banned_id, Set<Set<String>> combinations, Set<String> currentCombination, boolean[] visited, int index) {
        if (index == banned_id.length) {
            // 현재 조합이 불량 사용자 아이디 수와 일치할 때
            if (currentCombination.size() == banned_id.length) {
                combinations.add(new HashSet<>(currentCombination));
            }
            return;
        }
        
        for (int i = 0; i < user_id.length; i++) {
            if (!visited[i] && isMatch(user_id[i], banned_id[index])) {
                visited[i] = true;
                currentCombination.add(user_id[i]);
                generateCombinations(user_id, banned_id, combinations, currentCombination, visited, index + 1);
                visited[i] = false;
                currentCombination.remove(user_id[i]);
            }
        }
    }
    
    private boolean isMatch(String user, String banned) {
        if (user.length() != banned.length()) {
            return false;
        }
        for (int i = 0; i < user.length(); i++) {
            if (banned.charAt(i) != '*' && banned.charAt(i) != user.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}