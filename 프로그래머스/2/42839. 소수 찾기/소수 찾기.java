import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(String numbers) {
        Set<Integer> primes = new HashSet<>();
        boolean[] visited = new boolean[numbers.length()];

        // DFS를 통해 모든 숫자 조합을 탐색
        dfs("", numbers, visited, primes);

        return primes.size();  // 찾은 소수의 개수를 반환
    }

    // DFS를 사용하여 숫자 조합을 생성하면서 소수 판별
    private void dfs(String current, String numbers, boolean[] visited, Set<Integer> primes) {
        // 중간에 소수인지 확인하고, 소수이면 Set에 추가
        if (!current.equals("")) {
            int num = Integer.parseInt(current);
            if (isPrime(num)) {
                primes.add(num);
            }
        }

        // DFS로 모든 조합을 생성
        for (int i = 0; i < numbers.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(current + numbers.charAt(i), numbers, visited, primes);
                visited[i] = false;  // 백트래킹
            }
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