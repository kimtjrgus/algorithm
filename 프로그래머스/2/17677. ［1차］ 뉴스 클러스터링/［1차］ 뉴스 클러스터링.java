import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        // 입력 문자열로부터 다중집합을 생성
        List<String> multiset1 = makeMultiset(str1);
        List<String> multiset2 = makeMultiset(str2);

        // 원소 발생 빈도를 저장하는 맵
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();

        // 첫 번째 다중집합의 원소 빈도 계산
        for (String s : multiset1) {
            map1.put(s, map1.getOrDefault(s, 0) + 1);
        }

        // 두 번째 다중집합의 원소 빈도 계산
        for (String s : multiset2) {
            map2.put(s, map2.getOrDefault(s, 0) + 1);
        }

        // 교집합과 합집합의 크기 계산
        int intersectionSize = 0;
        int unionSize = 0;

        // 합집합 계산
        Set<String> allElements = new HashSet<>();
        allElements.addAll(map1.keySet());
        allElements.addAll(map2.keySet());

        for (String key : allElements) {
            int count1 = map1.getOrDefault(key, 0);
            int count2 = map2.getOrDefault(key, 0);

            intersectionSize += Math.min(count1, count2);
            unionSize += Math.max(count1, count2);
        }

        // 자카드 유사도 계산
        double jakard;
        if (unionSize == 0) {
            jakard = 1.0; // 두 집합이 모두 공집합인 경우 유사도는 1
        } else {
            jakard = (double) intersectionSize / unionSize;
        }

        // 결과를 65536을 곱한 후 정수 부분만 반환
        return (int) (jakard * 65536);
    }

    // 두 글자씩 끊어서 다중집합을 생성하는 함수
    private List<String> makeMultiset(String str) {
        List<String> multiset = new ArrayList<>();
        str = str.toUpperCase(); // 대소문자 구분 없이 처리하기 위해 대문자로 변환
        for (int i = 0; i < str.length() - 1; i++) {
            char first = str.charAt(i);
            char second = str.charAt(i + 1);
            // 두 글자가 모두 알파벳인 경우에만 다중집합에 추가
            if (Character.isLetter(first) && Character.isLetter(second)) {
                multiset.add("" + first + second);
            }
        }
        return multiset;
    }
}