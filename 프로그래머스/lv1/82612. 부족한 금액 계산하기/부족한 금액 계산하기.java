class Solution {
    public long solution(int price, int money, int count) {
        long result = 0;
        long sum = 0;
        
        for(int i=1; i<=count; i++){
            sum += price * i;
        }
        
        result = sum - money;
        if(result<=0) return 0; // 금액이 부족하지 않을 경우
        return result;
    }
}
// price 기존 이용료
// coumt번째 이용하면 price * count