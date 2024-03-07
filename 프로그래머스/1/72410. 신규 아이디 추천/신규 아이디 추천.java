class Solution {
    public String solution(String new_id) {
        while(true){
            String temp = new_id;
            // 1. 소문자 치환
            new_id = new_id.toLowerCase();

            // 2. 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 문자 제거
            new_id = new_id.replaceAll("[^a-z0-9-_.]", "");

            // 3. 마침표가 2번이상 연속되면 한개로 치환
            new_id = new_id.replaceAll("\\.{2,}", ".");

            // 4. 마침표가 처음이나 끝에 있다면 제거
            new_id = new_id.replaceAll("^[.]|[.]$", "");

            // 5. 빈문자열이라면 a를 대입
            if (new_id.equals("")) 
                new_id = "a";

            // 6. 길이가 16자이상이면 첫 15문자 이외 제거
            if (new_id.length() > 15) 
                new_id = new_id.substring(0, 15);

            // 7. 글자가 2자이하면 마지막문자를 3이 될때까지 반복해서 붙임
            if (new_id.length() < 3) {
                char last = new_id.charAt(new_id.length() - 1);

                StringBuilder sb = new StringBuilder();
                sb.append(new_id);
                sb.append(String.valueOf(last).repeat(3- new_id.length()));

                new_id = sb.toString();
            }
            
            if(temp.equals(new_id)) {
                break;
            }
        }
        return new_id;
    }
}