class Solution {
    public int solution(String[] board) {
        int oCount = 0;
        int xCount = 0;
        
        // 1. O와 X의 개수가 동일하거나 O가 1개 더 많아야함.
        for(String str: board){
            for(char cell: str.toCharArray()){
                if (cell == 'O') oCount++;
                else if (cell == 'X') xCount++;
            }
        }
        if(!(oCount == xCount || oCount == xCount+1)) return 0;
        
        boolean oWins = isValid(board, 'O');
        boolean xWins = isValid(board, 'X');
            
        // 불가능한 게임의 조건
        /*
            1. x와 o 둘 다 이길 경우
            2. O가 이겼을 경우 O의 개수가 X보다 1개 많지 아니함.
            3. X가 이겼을 경우 X의 개수가 O와 같지 아니함.
        */
        if((oWins && xWins) 
           || (oWins && oCount != xCount+1)
           || (xWins && oCount != xCount)) return 0;
        
        // 게임이 가능한 경우
        return 1;
    }
    
    private boolean isValid(String[] board, char player){
        // 가로, 세로, 대각선 체크
        // 1. 가로
        for(String row : board){
            if (row.charAt(0) == player 
                && row.charAt(1) == player 
                && row.charAt(2) == player) {
                return true;
            }
        }
        
        // 2. 세로
        for(int col =0; col <3; col++){
            if (board[0].charAt(col) == player 
                && board[1].charAt(col) == player 
                && board[2].charAt(col) == player) {
                return true;
            }
        }
        
        // 3. 대각선
        if (board[0].charAt(0) == player 
            && board[1].charAt(1) == player 
            && board[2].charAt(2) == player) {
            return true;
        }
        if (board[0].charAt(2) == player 
            && board[1].charAt(1) == player 
            && board[2].charAt(0) == player) {
            return true;
        }
        
        return false;
    }
}
/*
머쓱이의 틱택토
틱택토의 규칙을 구현할 것.
1) O와 X의 개수가 동일하거나 O가 1개더 많아야함.
2) X가 선공으로 나왔을 경우 return 0; -> 이또한 1번조건
3) O나 X 둘중 한세트가 먼저 완성되었는데 1번의 경우
*/