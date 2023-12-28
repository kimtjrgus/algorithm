import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        // 최소 횟수, 작성 못할 시 -1
        int[] result = new int[targets.length];
        
        // 문자를 키와 눌러야 하는 횟수로 매핑
        Map<Character, Integer> charToKeyPresses = new HashMap<>();

        for (int i = 0; i < keymap.length; i++) {
            for (int j = 0; j < keymap[i].length(); j++) {
                char c = keymap[i].charAt(j);
                // 키맵에 동일한 문자가 여러 번 나타날 수 있으므로, 최소 횟수로 저장
                int keyPresses = j + 1; // 키를 눌러야 하는 횟수
                charToKeyPresses.merge(c, keyPresses, Math::min);
            }
        }

        for (int i = 0; i < targets.length; i++) {
            int keyPressCount = 0;
            boolean canType = true;
            for (char c : targets[i].toCharArray()) {
                Integer keyPresses = charToKeyPresses.get(c);
                if (keyPresses == null) { // 매핑되지 않은 문자를 찾은 경우
                    canType = false;
                    break;
                }
                keyPressCount += keyPresses;
            }
            result[i] = canType ? keyPressCount : -1;
        }
        
        return result;
    }
}