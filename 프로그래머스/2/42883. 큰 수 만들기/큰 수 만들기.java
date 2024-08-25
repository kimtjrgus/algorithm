import java.util.Stack;

class Solution {
    public String solution(String number, int k) {
        // 숫자를 저장할 스택 초기화
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < number.length(); i++) {
            char current = number.charAt(i);
            
            // 스택이 비어있지 않고, 제거할 숫자가 남아있으며,
            // 스택의 top에 있는 숫자가 현재 숫자보다 작으면 pop
            while (!stack.isEmpty() && k > 0 && stack.peek() < current) {
                stack.pop();
                k--;
            }
            
            stack.push(current);
        }
        
        // if(k>0) 뒤에서부터 남은 숫자를 제거
        while (k > 0) {
            stack.pop();
            k--;
        }
        
        StringBuilder result = new StringBuilder();
        for (char num : stack) {
            result.append(num);
        }
        
        return result.toString();
    }
}