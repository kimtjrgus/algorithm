class Solution {
    public int solution(int[] nums) {
        int answer = 0; // 경우의 수 count
        
        // nums.length 중 3개를 뽑아 소수가 되는 수
        // 1. nums 중 3개 뽑기, 순서상관x
        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                for(int k=j+1; k<nums.length; k++){
                    int sum = nums[i] + nums[j] + nums[k];
                    // 2. if(sum이 소수일 때) answer++
                    if(isPrime(sum)) answer++;
                }
            }
        }
        
        return answer;
    }
    
    // 소수 체크 메서드
    public boolean isPrime(int n){
        boolean check = true;
        // n이 1이 아닌 약수로 나누어 떨어질 경우 false
        for(int i=2; i <= Math.sqrt(n); i++){
            if(n % i ==0) check = false;
        }
        
        return check;
    }
}