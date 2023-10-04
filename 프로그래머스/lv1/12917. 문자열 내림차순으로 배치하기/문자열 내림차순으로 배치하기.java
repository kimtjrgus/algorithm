import java.util.*;

class Solution {
    public String solution(String s) {
        char[] charArray = s.toCharArray();
        
        Arrays.sort(charArray);
        
        StringBuilder result = new StringBuilder(new String(charArray));
        result.reverse();

        return result.toString();
    }
}