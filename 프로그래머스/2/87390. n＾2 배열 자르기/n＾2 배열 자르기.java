import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int n, long left, long right) {
        int length = (int) (right - left + 1);
        int[] answer = new int[length];
        
        for (long k = left; k <= right; k++) {
            int i = (int) (k / n);
            int j = (int) (k % n);
            answer[(int) (k - left)] = Math.max(i, j) + 1;
        }
        
        return answer;
    }
}