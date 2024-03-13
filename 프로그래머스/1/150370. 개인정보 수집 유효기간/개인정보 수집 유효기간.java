import java.util.*;
import java.time.LocalDate;

/*
* @param today 오늘 날짜
* @param terms 약관별 유효기간
* @param privacies 정보배열 ["가입기간 약관명", ...] 
* @return 파기해야할 개인정보번호 배열 [파기할 privacies 인덱스+1, ...]
*/
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies){   
        Map<String, Integer> termMap = new HashMap<>();
        for (String term : terms) {
            String[] termArr = term.split(" ");
            termMap.put(termArr[0], Integer.parseInt(termArr[1]));
        }

        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < privacies.length; i++) {
            String[] privacyArr = privacies[i].split(" ");
            String type = privacyArr[1];
            if (termMap.containsKey(type) && calculateTerms(today, termMap.get(type), privacyArr[0])) {
                answer.add(i + 1);
            }
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
    
    // @return 파기가 가능한지
    private boolean calculateTerms(String today, int term, String pDate) {
        LocalDate endDate = 
            LocalDate.parse(pDate.replace(".", "-")).plusMonths(term);
        LocalDate todayDate = 
            LocalDate.parse(today.replace(".", "-"));

        return todayDate.isEqual(endDate) || todayDate.isAfter(endDate);
    }
}