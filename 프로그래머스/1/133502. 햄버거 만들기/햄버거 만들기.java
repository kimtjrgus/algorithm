import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        // 빵-야채-고기-빵 , 1231 순서대로만 적용
        // 스택에 순서대로 넣고 순서에 알맞으면 pop
        int burgerCount = 0;
        
        Stack<Integer> stack = new Stack<Integer>();
        
        // 1. 스택에 재료 담기
        for(int in : ingredient){
            stack.push(in);
            
            // 2. 스택 사이즈가 4 이상부터 순서대로라면 버거카운트+1 
            if(stack.size() >= 4){
                if(stack.get(stack.size()-4) == 1 &&
                  stack.get(stack.size()-3) == 2 &&
                  stack.get(stack.size()-2) == 3 &&
                  stack.get(stack.size()-1) == 1){
                    burgerCount++;
                    
                    // 완성된 버거재료 pop
                    for(int i=0; i<4; i++) 
                        stack.pop();
                }
            }
        }
        
        return burgerCount;
    }
}