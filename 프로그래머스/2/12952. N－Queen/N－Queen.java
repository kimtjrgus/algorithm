class Solution {
    private static int[] board;
    private static int answer;
    
    public int solution(int n) {
        // 배열의 값은 해당 행의 queen이 있는 '열(column)'을 의미함
        board = new int[n];
        
        backTracking(0, n);
        
        return answer;
    }
    
    // depth는 행을 의미함
    private static void backTracking(int depth, int n){
        if (depth == n) {
            answer++;
            return;
        }
        for (int i = 0; i < n; i++) {
            board[depth] = i; 
            // 해당 depth(행)과 i(열)에 퀸을 놓을 수 있는지 확인
            if (isValid(depth)) {
                backTracking(depth + 1, n);
            }
        }
    }
    
    private static boolean isValid(int i) {
        for (int j = 0; j < i; j++) {
            if (board[i] == board[j]) 
                return false; // 직선
            if (Math.abs(i - j) == Math.abs(board[i] - board[j])) 
                return false; // 대각선
        }
        return true;
    }
}

/*
가,세 길이 n의 정사각형 체스판, n개의 퀸을 배치
규칙은 알겠으나, 구현하기에 감이 잘 잡히지않음.
-백트래킹을 사용하라는 참고 자료

*/