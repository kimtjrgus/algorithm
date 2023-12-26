import java.util.Arrays;

class Solution {
    public String solution(String[] participant, String[] completion) {
        // comp는 part보다 길이 1 짧음
        // 동명이인이 있을 수 있음. 1명만 체크하라는 뜻인듯
        String answer = ""; // answer = 완주 못한 선수
        // 1. 반복문은 케이스가 너무 많아서 비효율적
        // 2. 해시 ?
        
        // 1. 두 배열을 정렬한다
        Arrays.sort(participant);
        Arrays.sort(completion);

        // 2. 두 배열이 다를 때까지 찾는다
        int i = 0;
        for(i=0;i<completion.length;i++)
            if(!participant[i].equals(completion[i]))
                break;


        // 3. 여기까지 왔다는 것은 마지막 주자가 완주하지 못했다는 의미이다.
        answer = participant[i];
        
        return answer;
    }
}