class Solution {
    public int[] solution(String s) {
        // 첫글자는 -1, 이후 앞글자와의 index차이
        int[] answer = new int[s.length()]; //answer배열의 길이는 s의 글자수
        
        // 1. 나의 앞글자를 탐색하기 위한 방법
        // 첫글자는 -1 고정, for문 idx=1 시작하며 이중for문
        for (int i = 0; i < s.length(); i++) {
            answer[i] = -1; // 일단 모든 값들을 -1로 초기화
        }

        for(int i=1; i<s.length(); i++){
            for(int j=i-1; j>=0; j--){
                // i를 고정시키고 i앞쪽만 보면 됌
                if(s.charAt(i) == s.charAt(j)){
                    answer[i] = i - j; 
                    break;
                }
                
            }
        }
        
        return answer;
    }
    /*
    public int[] solution(String str) {
        int[] result = new int[str.length()];

        for(int i=0;i<str.length();i++){

            String subStr = str.substring(0,i);
            if(subStr.indexOf(str.charAt(i))==-1) {
                result[i] = -1;
            }else {
                result[i] = i-subStr.lastIndexOf(str.charAt(i));
            }
        }
        return result;
    }
    */
}