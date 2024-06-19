import java.util.*;

class Solution {
    public int[] solution(String msg) {
        // 1. 길이가 1인 모든 단어를 포함하도록 사전을 초기화한다.
        Map<String, Integer> dict = new HashMap<>();
        int dictSize = 26;
        for (int i = 0; i < dictSize; i++) {
            dict.put(String.valueOf((char) ('A' + i)), i + 1);
        }
        
        // 2. 사전에서 현재 입력과 일치하는 가장 긴 문자열 w를 찾는다.
        List<Integer> result = new ArrayList<>();
        int index = dictSize + 1;
        String w = "";
        // 3. w에 해당하는 사전의 색인 번호를 출력하고, 입력에서 w를 제거한다.
        for (int i = 0; i < msg.length(); i++) {
            String c = String.valueOf(msg.charAt(i));
            
            // 4. 입력에서 처리되지 않은 다음 글자가 남아있다면(c), w+c에 해당하는 단어를 사전에 등록한다.
            
            String wc = w + c;

            if (dict.containsKey(wc)) {
                w = wc;
            } else {
                result.add(dict.get(w));
                dict.put(wc, index++);
                w = c;
            }
        }

        if (!w.isEmpty()) {
            result.add(dict.get(w));
        }
        
        return result.stream().mapToInt(i -> i).toArray();
    }
}