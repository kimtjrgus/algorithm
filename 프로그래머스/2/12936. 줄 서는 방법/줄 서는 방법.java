import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        // n명의 경우의 수 
        // 사전순 k번째 경우 리턴 
        int[] answer = new int[n];
        List<Integer> numbers = new ArrayList<>();
        long factorial = 1;
        
        // 1. n명의 숫자 리스트 생성
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
            factorial *= i; // n! 계산
        }
        
        k--; // 인덱스는 0부터 시작하므로 k를 1 감소

        // 2. 경우의 수 계산
        for (int i = 0; i < n; i++) {
            factorial /= (n - i); 
            int index = (int)(k / factorial); 
            answer[i] = numbers.remove(index); 
            k %= factorial; 
        }

        return answer;
    }
}