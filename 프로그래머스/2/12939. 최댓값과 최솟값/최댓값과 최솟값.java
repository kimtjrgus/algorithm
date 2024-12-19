import java.util.*;

class Solution {
    public String solution(String s) {
        // 1. 공백문자로 split
        String[] str = s.split(" ");
        
        // 2. 초기 최소값과 최대값 설정
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        // 3. 숫자들을 순회하며 최소값, 최대값 갱신
        for (String numStr : str) {
            int num = Integer.parseInt(numStr);
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        
        return min + " " + max;
    }
}

/*
1. string값을 split하고 int배열에 오름차순 정렬
2. 최소값과 최대값 형태로 StringBuilder 사용
*/