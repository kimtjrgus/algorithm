import java.util.*;

class Solution {    // arrA는 철수, arrB는 영희
    public int solution(int[] arrayA, int[] arrayB) {
        // 철수 배열의 최대공약수 구하기
        int gcdA = arrayA[0];
        for (int i = 1; i < arrayA.length; i++) {
            gcdA = getGCD(gcdA, arrayA[i]);
        }
        
        // 영희 배열의 최대공약수 구하기
        int gcdB = arrayB[0];
        for (int i = 1; i < arrayB.length; i++) {
            gcdB = getGCD(gcdB, arrayB[i]);
        }
        
        // 철수의 gcdA가 영희의 배열에 있는 원소들로 나눠지지 않는지 확인
        if (isDivisibleByAny(arrayB, gcdA)) {
            gcdA = 0; // 철수의 gcdA가 영희의 배열에 있는 원소들로 나눠지면 철수의 gcdA는 무효
        }

        // 영희의 gcdB가 철수의 배열에 있는 원소들로 나눠지지 않는지 확인
        if (isDivisibleByAny(arrayA, gcdB)) {
            gcdB = 0; // 영희의 gcdB가 철수의 배열에 있는 원소들로 나눠지면 영희의 gcdB는 무효
        }
        
        // 유효한 최대공약수 반환
        return Math.max(gcdA, gcdB);
    }

    // 두 수의 최대공약수를 찾는 메서드
    private int getGCD(int num1, int num2) {
        if (num1 % num2 == 0) {
            return num2;
        }
        return getGCD(num2, num1%num2);
    }
    
    // 배열의 모든 원소가 gcd로 나누어지는지 확인하는 메서드
    private boolean isDivisibleByAny(int[] array, int gcd) {
        for (int num : array) {
            if (num % gcd == 0) {
                return true; // 하나라도 나눠지면 true 반환
            }
        }
        return false; // 아무것도 나눠지지 않으면 false 반환
    }
}

// 1. 철수가 가진 모든 숫자를 나눌 수 있고(철수의 최대공약수), 영희가 가진 숫자로는 하나도 나눌 수 없다.
// 2. 1번의 역
// 중복된 원소가 있을 수 있음 -> 이 경우 return 0

