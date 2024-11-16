class Solution { // 하노이의 탑 재귀용법
    int index = 0; // 이동 인덱스
    
    public int[][] solution(int n) {
        // 이동 횟수 2^n -1
        int count = (int)Math.pow(2, n) - 1;
        int[][] answer = new int[count][2];
        
        hanoi(n, 1, 2, 3, answer);
        
        return answer;
    }
    
    // from은 시작, by는 거쳐가는 기둥, to는 도착지 기둥
    public void hanoi(int n, 
                         int from, int by, int to, 
                         int[][] answer) {
        if(n==1) {
            answer[index++] = new int[] { from, to };
            return;
        } 
        else {
            hanoi(n-1, from, to, by, answer); // 1->3->2
            answer[index++] = new int[] { from, to };
            hanoi(n-1, by, from, to, answer); // 2->1->3
        }
    }
}