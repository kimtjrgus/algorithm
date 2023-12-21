class Solution {
    public int solution(String s) {
        int answer = 0;
        int xCount = 0;
        int nCount = 0; //x가 아닌 글자 count
            
        // x와 n의 count를 늘려가며 동일할 때 컷하고 x갱신
        while(s.length() > 0){
            char x = s.charAt(0);
            for(int i=0; i<s.length(); i++){
                if(x == s.charAt(i)) xCount++;
                else nCount++;
                
                // x와 x아닌 글자의 수가 같을 때 부분문자열로 잘라줌
                if (xCount == nCount) {
                    s = s.substring(i + 1);
                    answer++;
                    break;
                }
                
                // 마지막글자만 남을 경우
                if(i == s.length() -1){
                    s = "";
                    answer++;
                }
            }
        }
        return answer;
    }
}