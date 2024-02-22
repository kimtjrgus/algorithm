import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        // 빵-야채-고기-빵 , 1231 순서대로만 적용
        // 스택에 순서대로 넣고 순서에 알맞으면 pop
        int burgerCount = 0;
        
        Stack<Integer> stack = new Stack<Integer>();
        for(int in : ingredient){
            stack.push(in);
            
            if(stack.size() >= 4){
                if(stack.get(stack.size()-4) == 1 &&
                  stack.get(stack.size()-3) == 2 &&
                  stack.get(stack.size()-2) == 3 &&
                  stack.get(stack.size()-1) == 1){
                    burgerCount++;
                    
                    for(int i=0; i<4; i++){
                        stack.pop();
                    }
                }
            }
        }
        
        return burgerCount;
    }
}