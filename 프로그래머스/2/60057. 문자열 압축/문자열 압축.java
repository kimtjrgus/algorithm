class Solution {
    public int solution(String s) {
        int n = s.length();
        int answer = n; // 최악의 경우, 원본 그대로
        
        // 1. 1부터 n/2까지 단위 크기만큼 반복
        // n/2까지인 이유는 이후는 압축의미가 없음
        for (int unit = 1; unit <= n / 2; unit++) {
            StringBuilder compressed = new StringBuilder();
            String prev = s.substring(0, unit);  // 첫 번째 단위
            int count = 1;
            
            // 문자열을 unit 크기씩 나누어 처리
            for (int i = unit; i < n; i += unit) {
                String current = s.substring(
                    i, Math.min(i + unit, n)); // 나머지 부분 고려
                if(prev.equals(current)) count++;
                else {
                    if(count > 1) compressed.append(count);
                    
                    compressed.append(prev);
                    prev = current;
                    count = 1;
                }
            }
            
            // 마지막 남은 부분 처리
            if (count > 1) compressed.append(count);

            compressed.append(prev);
            
            // 압축된 문자열의 길이 비교
            answer = Math.min(answer, compressed.length());
        }
        
        return answer;
    }
}
/*
효율적인 문자열 압축법 고민
1개단위, 2개단위, 3개단위, 이런식,
ababbaba 반복이 있을 수록 
1개단위 -> aba2baba / 2개단위 -> ababbaba 2ab2ba

(생각)
단위를 끊을 경우, 1~문자열 최대길이까지,
생각가능한 최대 반복길이는 n/2

*/