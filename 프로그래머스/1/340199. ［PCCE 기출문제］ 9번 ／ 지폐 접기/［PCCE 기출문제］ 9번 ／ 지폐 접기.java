class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        
        while (true) {
            // 현재 지폐 상태에서 지갑에 들어가는지 확인 (회전 고려)
            if ((bill[0] <= wallet[0] && bill[1] <= wallet[1]) ||
                (bill[1] <= wallet[0] && bill[0] <= wallet[1])) {
                break;
            }

            // 더 긴 변을 반으로 접음
            if (bill[0] > bill[1]) {
                bill[0] /= 2;
            } else {
                bill[1] /= 2;
            }
            
            answer++; 
        }
        
        return answer;
    }
}

/*
1. 지폐를 접은 횟수를 저장할 정수 변수 answer를 만들고 0을 저장합니다.
2. 반복문을 이용해 bill의 작은 값이 wallet의 작은 값 보다 크거나 
                 bill의 큰 값이 wallet의 큰 값 보다 큰 동안 아래 과정을 반복합니다.
    2-1. bill[0]이 bill[1]보다 크다면
        bill[0]을 2로 나누고 나머지는 버립니다.
    2-2. 그렇지 않다면
        bill[1]을 2로 나누고 나머지는 버립니다.
    2-3. answer을 1 증가시킵니다.
3. answer을 return합니다.

*/