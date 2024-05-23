import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int[] elements) {
        int n = elements.length;
        Set<Integer> uniqueSums = new HashSet<>();
        
        // 원형 수열을 위해 배열을 두 번 이어붙임
        int[] extendedElements = new int[2 * n];
        for (int i = 0; i < n; i++) {
            extendedElements[i] = elements[i];
            extendedElements[i + n] = elements[i];
        }
        
        // 부분 수열의 합 계산
        for (int length = 1; length <= n; length++) {
            for (int start = 0; start < n; start++) {
                int sum = 0;
                for (int i = start; i < start + length; i++) {
                    sum += extendedElements[i];
                }
                uniqueSums.add(sum);
            }
        }
        
        return uniqueSums.size();
    }
}