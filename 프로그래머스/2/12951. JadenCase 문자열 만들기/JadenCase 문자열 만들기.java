/*
첫문자가 대문자, 그외 소문자
첫문자가 알파가 아닐땐 소문자

@param s : 주어진 문자열
@return s를 JC로 바꾼 문자열
*/
class Solution {
    public String solution(String s) {
        String answer = "";
        // 1. 전체 소문자로 변환
        s= s.toLowerCase();
        
        // 2. " "로 split
        String[] arr = s.split(" ");
        
        // 3. 배열내 원소의 첫번째 인덱스가 숫자가 아닐 경우 UpperCase
        for(String str : arr){
            if (str.isEmpty()) {
                answer+= " ";
            }
            
            else{
                answer += str.substring(0, 1).toUpperCase();
                answer += str.substring(1);
                answer += " ";
            }
        }
        
        // return answer.trim();
        if(s.substring(s.length()-1, s.length()).equals(" ")){
            return answer;
        }
        
        // 맨 마지막 " " 제거 후 반환
        return answer.substring(0, answer.length()-1);
    }  
}