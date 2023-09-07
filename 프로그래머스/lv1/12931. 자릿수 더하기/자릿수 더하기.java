import java.util.*;

public class Solution {
    public int solution(int n) {
        int sum = 0; // 각 자릿수의 합
        
        while (n > 0) {
            int digit = n % 10; // 가장 낮은 자릿수 추출
            sum += digit; // 자릿수를 더함
            n /= 10; // 다음 자릿수로 이동
        }

        return sum;
    }
}