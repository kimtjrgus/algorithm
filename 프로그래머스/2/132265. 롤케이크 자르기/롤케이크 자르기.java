import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int result = 0;
        Map<Integer, Integer> chulsu = new HashMap<>();
        Map<Integer, Integer> bro = new HashMap<>();
        
        // 동생의 해쉬맵에 먼저 가득 채워넣고, 철수의 Map은 비워놓음.
        for(int t : topping){
            bro.put(t, bro.getOrDefault(t, 0) + 1);
        }
        
        // 배열을 순회하며 철수의 Map을 채워주고
        for (int t : topping) {
            chulsu.put(t, chulsu.getOrDefault(t, 0) + 1);
            
            if (bro.get(t) - 1 == 0)
                bro.remove(t);
            else
                bro.put(t, bro.get(t) - 1);  
            
            // 가짓수를 세어 Map.size가 같다면 result++
            if (chulsu.size() == bro.size())
                result++;
        }
        
        return result;
    }
}

// 잘린 조각크기와 토핑개수는 상관x
// 각 조각에 동일한 가짓수의 토핑만 올라가면 됨
// 토핑종류 상관x, 가짓수만 같으면 됨