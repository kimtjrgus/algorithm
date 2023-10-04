class Solution {
    public int solution(int left, int right) {
        int result = 0;
        int count = 0; // 약수의 개수
        
        for(int i = left; i <= right; i++){ // i= left~right
            for (int j = 1; j * j <= i; j++) {
	            if (j * j == i) count++;
	            else if (i % j == 0) count += 2;
            }
            // 약수의 개수가 짝수라면
            if(count % 2 == 0){
                result += i;
                count = 0; // count 초기화
            } 
            else{
                result -= i;
                count = 0;
            } 
        }
        
        return result;
    }
}
// left~right 까지의 모든 수들 중
// 약수의 개수가 짝수는 + / 홀수는 -