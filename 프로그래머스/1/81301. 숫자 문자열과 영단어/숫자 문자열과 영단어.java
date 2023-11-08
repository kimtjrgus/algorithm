class Solution {
    public int solution(String s) { 
        int answer = 0;
        
        // 1. String 영단어 배열 선언
        String[] eng = {"zero", "one", "two", "three", "four", "five", 
                       "six", "seven", "eight", "nine"};
        
        // 2. s 내에 영단어가 있다면(contains) replace
        for(int i =0; i<eng.length; i++){
            if(s.contains(eng[i])){
                s = s.replace(eng[i], Integer.toString(i));
            }
        }
        answer = Integer.parseInt(s);
        
        return answer;
    }
}