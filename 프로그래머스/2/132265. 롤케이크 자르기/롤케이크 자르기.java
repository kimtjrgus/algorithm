import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int result = 0;
        Set<Integer> chulsuSet = new HashSet<>();
        Map<Integer, Integer> broMap = new HashMap<>();
        
        // 동생의 해쉬맵에 먼저 가득 채워넣고, 철수의 Map은 비워놓음.
        for (int t : topping) {
            broMap.put(t, broMap.getOrDefault(t, 0) + 1);
        }
        
        // 배열을 순회하며 철수의 Set을 채워주고
        for (int t : topping) {
            chulsuSet.add(t);
            
            // 동생의 해쉬맵에서 토핑 하나를 줄임
            if (broMap.get(t) - 1 == 0) {
                broMap.remove(t);
            } else {
                broMap.put(t, broMap.get(t) - 1);
            }
            
            // 가짓수를 세어 chulsuSet.size()가 broMap.size()와 같다면 result++
            if (chulsuSet.size() == broMap.size()) {
                result++;
            }
        }
        
        return result;
    }
}

// 잘린 조각크기와 토핑개수는 상관x
// 각 조각에 동일한 가짓수의 토핑만 올라가면 됨
// 토핑종류 상관x, 가짓수만 같으면 됨 -> HashSet 활용