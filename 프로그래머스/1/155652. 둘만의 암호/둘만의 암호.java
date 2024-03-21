/*
@param s     : 암호화 전 문자열
@param skip  : 암호화 시 해당 알파벳들은 제외하고 건너뜀
@param index : s의 문자열을 index만큼 건너뜀
@return : 암호화한 문자열
*/
class Solution {
    public String solution(String s, String skip, int index) {
        // 1. 전체알파벳 선언, skip 제외
        String alphabets = "abcdefghijklmnopqrstuvwxyz";
        String[] skips = skip.split("");
        
        for(String str: skips){
            // 알파벳 문자열과 replace
            alphabets = alphabets.replace(str, "");
        }
        
        // 2. s.split 후 문자하나당 인덱스를 찾아 +index 해주고 문자치환
        String[] sarr = s.split("");
        StringBuilder sb = new StringBuilder();
        for(int i =0; i<sarr.length; i++){
            int charIndex = alphabets.indexOf(sarr[i]);
            if (charIndex != -1) {
                int newIndex = (charIndex + index) % alphabets.length();
                // 해당하는 문자를 StringBuilder에 추가
                sb.append(alphabets.charAt(newIndex));
            }
        }
        
        
        String answer = sb.toString();
        return answer;
    }
}