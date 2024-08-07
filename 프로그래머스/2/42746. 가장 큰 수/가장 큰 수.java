import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        /* 원소를 이어붙여 만들 수 있는 가장 큰 수
          원소 내 첫째 자리수가 가장 큰 수 찾기, 같을 경우 그다음 자릿수
          if 9, 91 일 경우 자리수가 작은 수 먼저 나열
          순서대로 이어붙이기 -> 가장 큰 수 */
        
        // 1. 숫자를 문자열로 변환
        String[] strNumbers = Arrays.stream(numbers)
                                     .mapToObj(String::valueOf)
                                     .toArray(String[]::new);

        // 2. 비교 기준 정의
        Comparator<String> comparator = (a, b) -> (b + a).compareTo(a + b);

        // 3. 문자열 배열 정렬
        Arrays.sort(strNumbers, comparator);

        // 4. 결과 생성
        StringBuilder largestNum = new StringBuilder();
        for (String num : strNumbers) {
            largestNum.append(num);
        }

        // 결과가 '0'으로만 이루어져 있을 경우
        if (largestNum.length() > 0 && largestNum.charAt(0) == '0') {
            return "0";
        }

        return largestNum.toString();
    }
}