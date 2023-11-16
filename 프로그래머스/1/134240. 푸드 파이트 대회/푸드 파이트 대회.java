class Solution {
    public String solution(int[] food) {
        // food의 인덱스가 칼로리, 원소는 음식갯수 
        // (index >=1) /2 (int)소수점버림
        StringBuilder sb = new StringBuilder();
         
        for(int i=1; i<food.length; i++){
            int count = food[i] / 2;
            sb.append(String.valueOf(i).repeat(count));
        }
        
        // StringBuilder에 추가된 음식에 0과 reverse된 문자열 더하기
        String answer = sb + "0";
        answer += sb.reverse();

        return answer;
    }
}