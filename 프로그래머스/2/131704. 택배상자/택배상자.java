import java.util.Stack;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        int index = 0;
        Stack<Integer> subContainer = new Stack<>();
        
        for (int box = 1; box <= order.length; box++) {
            subContainer.push(box);  // 주컨테이너에서 보조컨테이너로.
            
            // 보조 컨테이너 벨트에서 상자를 꺼낼 수 있는지 확인 
            while (!subContainer.isEmpty() 
                   && subContainer.peek() == order[index]) {
                subContainer.pop();
                index++;
                answer++;
            }
        }
        
        return answer;
    }
}