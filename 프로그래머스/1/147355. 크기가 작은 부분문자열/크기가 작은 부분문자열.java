class Solution {
    public int solution(String t, String p) {
        // p.length() 길이파악
        // t의 부분문자열 tpart 추출 후, 
        // for (p >= tpart) count++
        int count = 0;
        int lenP = p.length();
        int lenT = t.length();

        for (int i = 0; i <= lenT - lenP; i++) {
            if (isSmallerOrEqual(t, i, p)) {
                count++;
            }
        }

        return count;
    }

// 두 숫자로만 이루어진 문자열을 비교하는 메서드
    private boolean isSmallerOrEqual(String t, int startIndex, String p) {
        for (int i = 0; i < p.length(); i++) {
            if (t.charAt(startIndex + i) < p.charAt(i)) {
                return true;  // p가 더 큰 경우가 아니면
            } else if (t.charAt(startIndex + i) > p.charAt(i)) {
                return false;  // p가 더 작은 경우
            }
        }
        return true;  // p와 t 부분 문자열이 같은 경우
    }
}



// 숫자로만 이루어진 문자열 t p 
// t 에서 /p와 길이가 같은 부분문자열 중 p보다 작거나 같은 것의 가짓수