class Solution {
    public int solution(String t, String p) {
        // p.length() 길이파악
        // t의 부분문자열 tpart 추출 후, 
        // for (p >= tpart) count++
        int pLength = p.length();
        long pValue = Long.parseLong(p);
        int count = 0;
        
        for (int i = 0; i <= t.length() - pLength; i++) {
            long tValue = Long.parseLong(t.substring(i, i + pLength));
            
            if (tValue <= pValue)
                count++;
        }
        
        return count;
    }
}

// 숫자로만 이루어진 문자열 t p 
// t 에서 /p와 길이가 같은 부분문자열 중 p보다 작거나 같은 것의 가짓수