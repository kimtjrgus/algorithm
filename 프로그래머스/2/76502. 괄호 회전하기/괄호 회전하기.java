import java.util.Stack;

class Solution {
    public int solution(String s) {
        int count = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            String rotatedS = s.substring(i) + s.substring(0, i);
            if (isValidBracketString(rotatedS)) {
                count += 1;
            }
        }

        return count;
    }
    
    // 괄호 문자열이 올바른지 확인하는 함수
    public boolean isValidBracketString(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            switch (c) {
                case '(':
                case '[':
                case '{':
                    stack.push(c);
                    break;
                case ')':
                    if (stack.isEmpty() || stack.pop() != '(') return false;
                    break;
                case ']':
                    if (stack.isEmpty() || stack.pop() != '[') return false;
                    break;
                case '}':
                    if (stack.isEmpty() || stack.pop() != '{') return false;
                    break;
            }
        }
        return stack.isEmpty();
    }
}