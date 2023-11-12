import java.util.*;
class Solution {
    public String[] solution(String[] strings, int n) {
        // 문자열 배열을 정렬하는데 Comparator를 사용합니다.
        Arrays.sort(strings, (s1, s2) -> {
            // 문자열의 n번째 문자를 비교합니다.
            char c1 = s1.charAt(n);
            char c2 = s2.charAt(n);
            
            // n번째 문자가 같으면 사전순으로 정렬합니다.
            if (c1 == c2) {
                return s1.compareTo(s2);
            } else {
                return c1 - c2;
            }
        });

        return strings;
    }
}