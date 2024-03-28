class Solution {
    public int solution(int n) {
        return fibonacci(n) % 1234567;
    }
    
    public int fibonacci(int num) {
        int a = 0;
        int b = 1;
        
        for (int i = 2; i <= num; i++) {
            int temp = (a + b) % 1234567;
            a = b;
            b = temp;
        }
        
        return b;
    }
}