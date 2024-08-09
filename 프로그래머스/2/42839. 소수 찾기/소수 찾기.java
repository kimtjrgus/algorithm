import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(String numbers) {
        int answer = 0;
        
        // 중복 방지를 위해 Set을 사용하여 순열을 저장
        Set<Integer> permutations = new HashSet<>();
        
        // 모든 순열을 생성
        permutation("", numbers, permutations);
        
        // 생성된 순열 중에서 소수를 판별하여 개수를 센다
        for (int num : permutations) {
            if (isPrime(num)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    // 숫자 조각으로 순열을 생성하는 메서드
    private void permutation(String prefix, String numbers, Set<Integer> set) {
        int n = numbers.length();
        
        // prefix가 비어있지 않으면 정수로 변환하여 Set에 추가
        if (!prefix.equals("")) {
            set.add(Integer.parseInt(prefix));
        }

        // 재귀적으로 순열을 생성
        for (int i = 0; i < n; i++) {
            // 현재 문자를 추가하고, 나머지 문자들로 재귀 호출
            permutation(prefix + numbers.charAt(i), 
                        numbers.substring(0, i) + numbers.substring(i + 1, n), 
                        set);
        }
    }
    
    // 소수 판별 메서드 - 에라토스테네스의 체
    private boolean isPrime(int n){
        if(n == 0 || n == 1) return false;
        
        for(int i = 2; i <= Math.sqrt(n); i++){
            if(n % i == 0) return false;
        }
        
        return true;
    }
}