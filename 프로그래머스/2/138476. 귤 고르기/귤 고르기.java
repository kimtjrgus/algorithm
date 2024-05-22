import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        // 1. 귤 크기별로 개수 세기
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for(int size : tangerine){
            countMap.put(size, countMap.getOrDefault(size, 0) + 1);
        }
        
        // 귤의 개수를 기준으로 내림차순 정렬
        List<Integer> counts = new ArrayList<>(countMap.values());
        counts.sort(Collections.reverseOrder());
        
        // 귤의 종류 수를 최소화하면서 k개 선택
        int types = 0;
        int currentSum = 0;
        for (int count : counts) {
            currentSum += count;
            types++;
            if (currentSum >= k) {
                break;
            }
        }
        
        return types;
    }
}