import java.util.*;

class Solution {    // arrA는 철수, arrB는 영희
    public int solution(int[] arrayA, int[] arrayB) {
        int gcdA = arrayA[0];
        for (int i = 1; i < arrayA.length; i++) {
            gcdA = getGCD(gcdA, arrayA[i]);
        }
        
        int gcdB = arrayB[0];
        for (int i = 1; i < arrayB.length; i++) {
            gcdB = getGCD(gcdB, arrayB[i]);
        }
        
        boolean isDivisibleByA = false;
        for (int numB : arrayB) {
            if (numB % gcdA == 0) {  // gcdA가 arrayB의 원소로 나누어지는지 확인
                isDivisibleByA = true;
                break;
            }
        }
        
        boolean isDivisibleByB = false;
        for (int numA : arrayA) {
            if (numA % gcdB == 0) {  // gcdB가 arrayA의 원소로 나누어지는지 확인
                isDivisibleByB = true;
                break;
            }
        }
        
        if (!isDivisibleByA && !isDivisibleByB) {
            return Math.max(gcdA, gcdB);
        } else if (!isDivisibleByA) {
            return gcdA;
        } else if (!isDivisibleByB) {
            return gcdB;
        } else {
            return 0;
        }
    }
    
    // 두 수의 최대공약수를 찾는 메서드
    private int getGCD(int num1, int num2) {
        if (num1 % num2 == 0) {
            return num2;
        }
        return getGCD(num2, num1%num2);
    }
}

// 1. 철수가 가진 모든 숫자를 나눌 수 있고(철수의 최대공약수), 영희가 가진 숫자로는 하나도 나눌 수 없다.
// 2. 1번의 역
// 중복된 원소가 있을 수 있음 -> 이 경우 return 0

