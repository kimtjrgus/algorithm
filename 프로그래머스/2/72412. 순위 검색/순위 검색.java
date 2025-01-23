import java.util.*;

class Solution {
    static Map<String, List<Integer>> map;

    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        map = new HashMap<String, List<Integer>>(); 
        
        // 1. info정보를 토대로 가능한 조합 구성
        for (int i = 0; i < info.length; i++) {
            String[] p = info[i].split(" ");
            makeSentence(p, "", 0);
        }
        
        // 2. map을 키순 정렬
        for (String key : map.keySet())
            Collections.sort(map.get(key));
 
        // 3. 이진 탐색으로 키값 검색
        for (int i = 0; i < query.length; i++) {
            query[i] = query[i].replaceAll(" and ", "");
            String[] q = query[i].split(" ");
            answer[i] = map.containsKey(q[0]) ? binSearch(q[0], Integer.parseInt(q[1])) : 0;
        }
 
        return answer;
    }

    // 이진 탐색
    public int binSearch(String key, int score) {
        List<Integer> list = map.get(key);
        int start = 0, end = list.size() - 1;
 
        while (start <= end) {
            int mid = (start + end) / 2;
            if (list.get(mid) < score)
                start = mid + 1;
            else
                end = mid - 1;
        }
 
        return list.size() - start;
    }  
    
    // info가 포함될 수 있는 문장 조합을 구함.
    private void makeSentence(String[] p, String str, int cnt) {
        if (cnt == 4) {
            if (!map.containsKey(str)) {
                List<Integer> list = new ArrayList<Integer>();
                map.put(str, list);
            }
            map.get(str).add(Integer.parseInt(p[4]));
            return;
        }
        makeSentence(p, str + "-", cnt + 1);
        makeSentence(p, str + p[cnt], cnt + 1);
    }
}



/* 문제 풀이
지원자가 입력한 4가지 정보와 테스트 점수를 하나의 문자열로 구성한 1차원 배열 info
개발팀의 문의조건 1차원 배열 query
-> 각 문의 조건에 해당하는 사람 수를 순서대로 배열에 담아 return.

이진탐색, map
*/