class Solution {
    int index = 0;
    
    public int[][] solution(int n) {
        int count = (int)Math.pow(2, n) - 1;
        int[][] answer = new int[count][2];
        
        hanoi(n, 1, 2, 3, answer);
        
        return answer;
    }
    
    public int[][] hanoi(int n, int from, int by, int to, 
                         int[][] answer) {
        
        if(n==1) {
            answer[index++] = new int[] { from, to };
        } else {
            hanoi(n-1, from, to, by, answer); // 1->3->2
            answer[index++] = new int[] { from, to };
            hanoi(n-1, by, from, to, answer); // 2->1->3
        }
        
        return answer;
    }
    
}