import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        Map<String, String> idMap = new HashMap<>(); // (아이디 - 닉네임) Map
        List<String> messages = new ArrayList<>();  // 최종 메시지를 저장할 리스트

        // 첫 번째 루프: 최신 닉네임으로 맵 업데이트
        for (String rec : record) {
            String[] info = rec.split(" ");
            String action = info[0];
            String userId = info[1];
            
            if (action.equals("Enter") || action.equals("Change")) {
                String nickname = info[2];
                idMap.put(userId, nickname);
            }
        }

        // 두 번째 루프: 최종 메시지 생성
        for (String rec : record) {
            String[] info = rec.split(" ");
            String action = info[0];
            String userId = info[1];
            String nickname = idMap.get(userId);
            
            if (action.equals("Enter")) {
                messages.add(nickname + "님이 들어왔습니다.");
            } else if (action.equals("Leave")) {
                messages.add(nickname + "님이 나갔습니다.");
            }
        }

        return messages.toArray(new String[0]);
    }
}