import java.util.*;

/*
@param id_list : 모든 유저의 아이디 배열
@param report  : "신고자 신고당한자"의 배열
@param k       : k번이상 신고 누적시 이용정지
@return id_list 결과 메일을 받는 수 
(결과메일은 신고당한 이용자가 이용정지시 발송)
*/

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        // 신고한 사람 : 신고당한 사람들
        Map<String, Set<String>> reportMap = new HashMap<>(); 
        // 신고당한 횟수
        Map<String, Integer> countMap = new HashMap<>(); 
        
        // 초기화
        for (String id : id_list) {
            reportMap.put(id, new HashSet<>());
            countMap.put(id, 0);
        }
        
        // 신고 정보 처리
        for (String r : report) {
            String[] split = r.split(" ");
            String reporter = split[0]; // 신고자
            String reported = split[1]; // 신고당한 사람
            
            // 신고당한 사람을 신고자의 신고 목록에 추가
            if (reportMap.get(reporter).add(reported)) {
                // 신고당한 횟수 증가
                countMap.put(reported, countMap.get(reported) + 1);
            }
        }
        
        // 결과 배열 초기화
        int[] answer = new int[id_list.length];
        
        // 각 유저별로 신고로 인해 정지된 유저의 수 계산
        for (int i = 0; i < id_list.length; i++) {
            Set<String> reportedUsers = reportMap.get(id_list[i]);
            for (String user : reportedUsers) {
                if (countMap.get(user) >= k) {
                    answer[i] += 1;
                }
            }
        }
        
        return answer;
    }
}