/*
@param s : 0과 1로 이루어진 문자열
@return : [이진변환횟수, 제거된 0의 개수]
*/
class Solution {
    public int[] solution(String s) {
        int isBin = 0; // 이진변환 횟수
        int delZeroCnt = 0; // 제거된 0의 개수
        
        // 3. s가 1이 될 때까지 반복
        while(s.length() > 1){
            // 1. s에서 0을 제거
            int cntOne = 0;
            for(int i=0; i<s.length(); i++) {
                if(s.charAt(i) == '0') delZeroCnt++;
                else cntOne++;
            }
            // 2. 이때 s의 길이를 이진수로 치환
            s = Integer.toBinaryString(cntOne);
            isBin++;
        }
        
        int[] answer = new int[]{isBin, delZeroCnt};
        return answer;
    }
}