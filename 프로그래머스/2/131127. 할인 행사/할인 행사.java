import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        // 일정금액이상 지불시 10일간 회원자격
        // 정현이가 원하는제품 want, 원하는 수량 number, 제품할인품목 discount
        // 10일연속일치할 경우에 맞춰 회원가입을 하려함.(슬라이딩윈도우 알고리즘)
        // 1. 필요한 제품목록 HashMap 생성
        Map<String, Integer> need = new HashMap<>();
        for(int i=0; i<want.length; i++){
            need.put(want[i], number[i]);
        }
        
        int totalDays = discount.length;
        int count = 0;
        
        // 2. 윈도우를 생성, 각 10일 기간을 확인
        for (int i = 0; i <= totalDays - 10; i++) {
            Map<String, Integer> currentWindow = new HashMap<>();

            // 현재 윈도우에 제품 개수를 채움
            for (int j = 0; j < 10; j++) {
                currentWindow.put(discount[i + j], currentWindow.getOrDefault(discount[i + j], 0) + 1);
            }

            // 현재 윈도우가 요구사항과 일치하는지 확인
            boolean isMatch = true;
            for (String product : need.keySet()) {
                if (!currentWindow.getOrDefault(product, 0).equals(need.get(product))) {
                    isMatch = false;
                    break;
                }
            }

            if (isMatch) {
                count++;
            }
        }

        return count;
    }
}