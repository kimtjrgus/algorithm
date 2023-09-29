class Solution {
    public int solution(int[] numbers) {
        int sum = 0;
        // 0~9까지 탐색 , 있는지 검사
        
        for(int i=0; i<=9; i++){
            boolean match = false;  // 배열내 숫자 매치 여부
            
            for(int j=0; j< numbers.length; j++){
                if (numbers[j] == i) {
                    match = true; 
                    break;
                }
            }
            if(!match){ //매칭하지 못한 경우
                sum += i;
            } 
        }
        
        return sum;
    }
}