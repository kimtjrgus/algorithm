class Solution {
    public int solution(int n, int w, int num) {
        // 1. num번 상자가 속한 라인 계산 (1-based)
        int numLine = (num - 1) / w + 1;  // num이 속한 라인의 번호

        // 2. 전체 라인 수 계산
        int totalLines = (n + w - 1) / w;  // 전체 라인 수

        // 3. 마지막 라인 박스 개수 계산
        int lastLineBoxes = n % w == 0 ? w : n % w;

        // 4. num번 상자가 속한 라인과 마지막 라인의 관계만 고려
        // 현재 라인부터 마지막 라인까지 꺼내야 하는 상자 개수 계산
        int answer = 1; // 현재 num 상자 포함
        
        // num번 상자 속한 라인과 마지막 라인의 관계에 따른 계산
        if (numLine == totalLines) { // num이 마지막 라인에 있을 경우.
            return answer;
        } 
        else{ // num이 마지막이 아닌 경우
            int numIndex = (num - 1) % w + 1;
            
            // 1. totalLines -numLine 가 홀수일 경우(서로 방향이 다름)
            if((totalLines - numLine) %2 ==1){
                // 서로 방향이 다르므로 numIndex + lastLineBoxes가 w보다 작거나 같은 경우 
                // 해당 인덱스에서 마지막 라인의 박스 개수가 채워지지 않음.
                if(numIndex + lastLineBoxes <= w){
                    answer += (totalLines - numLine) - 1;
                }
                // 큰 경우
                else{
                    answer += (totalLines - numLine);
                }
            }
            else{
                // 2. totalLines -numLine 가 짝수일 경우(방향 같음)
                // numIndex가 lastLineBoxes보다 작거나 같을 경우
                if(numIndex <= lastLineBoxes){
                    answer += (totalLines - numLine);
                }
                else answer += (totalLines - numLine) -1;
            }
        }

        return answer;
    }
}