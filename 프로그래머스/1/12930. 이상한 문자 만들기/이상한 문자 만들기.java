class Solution {
    public String solution(String s) {
        // 하나이상의 단어 하나이상의 공백
        // 인덱스가 아닌 각 단어의 0번째, 짝수번째는 대문자
        // 1. " " 공백문자로 split
        StringBuilder answer = new StringBuilder();
        String[] words = s.split(" ", -1);
        
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                if (i % 2 == 0) {
                    answer.append(Character.toUpperCase(word.charAt(i)));
                } else {
                    answer.append(Character.toLowerCase(word.charAt(i)));
                }
            }
            answer.append(" ");
        }
        
        // 마지막에 공백 제거
        answer.deleteCharAt(answer.length() - 1);
        
        return answer.toString();
    }
}