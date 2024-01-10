import java.util.Stack;

class Solution {            // 보드크기,  위치배열 
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        // 1. 인형을 뽑아서 넣어줄 스택구현
        // 2. moves대로 뽑아 스택에 넣고, 
        // 3. 스택에 넣은 최상단2개가 일치할 경우 pop하고 answer+2
        Stack<Integer> stack = new Stack<>();
        stack.push(0);  // 0은 두수를 비교하기 위해.

        for (int move : moves) {
            for (int j = 0; j < board.length; j++) {
                if (board[j][move - 1] != 0) {
                    if (stack.peek() == board[j][move - 1]) {
                        stack.pop();
                        answer += 2;
                    } 
                    else {
                        stack.push(board[j][move - 1]);
                    }
                     
                    board[j][move - 1] = 0;
                    break;
                }
            }
        }
        return answer;
    }
}