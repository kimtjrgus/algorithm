/*
 @param arr : n개의 숫자를 담은 배열
 @return arr의 최소공배수
 
 LCM은 두수의 곱을 최소공약수로 나눠줌
*/
class Solution {
    public int solution(int[] arr) {
        int result = arr[0];
        for (int i = 1; i < arr.length; i++) {
            result = lcm(result, arr[i]);
        }
        return result;
    }

    // 두 수의 최소공배수
    public static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }
        
    // 두수의 최대 공약수
    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}