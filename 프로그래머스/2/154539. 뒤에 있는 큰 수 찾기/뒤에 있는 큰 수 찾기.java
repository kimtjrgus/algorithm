import java.util.Stack;

class Solution {
    public int[] solution(int[] numbers) {
        // 뒷큰수 : 나보다 큰데, 더 큰수는 없어야함.
        int[] result = new int[numbers.length];
        Stack<Integer> stack = new Stack<>();
        
        // 결과 배열을 -1로 초기화 (기본적으로 뒷큰수가 없는 경우를 가정)
        for (int i = 0; i < numbers.length; i++) {
            result[i] = -1;
        }
        
        for (int i = 0; i < numbers.length; i++) {
            // 스택이 비어있지 않고, 현재 숫자가 스택의 인덱스에 해당하는 숫자보다 큰 경우
            while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                // 스택에서 인덱스를 꺼내서 결과 배열을 갱신
                int index = stack.pop();
                result[index] = numbers[i];
            }
            // 현재 인덱스를 스택에 추가
            stack.push(i);
        }
        
        return result;
    }
}