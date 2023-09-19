import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        List<Integer> resultList = new ArrayList<>();

        for (int num : arr) {
            if (num % divisor == 0) {
                resultList.add(num);
            }
        }

        // 나누어 떨어지는 원소가 없을 경우 -1을 반환
        if (resultList.isEmpty()) {
            int[] answer = {-1};
            return answer;
        }

        // 리스트를 정렬하여 배열로 변환
        int[] answer = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            answer[i] = resultList.get(i);
        }

        Arrays.sort(answer); // 정렬

        return answer;
    }
}