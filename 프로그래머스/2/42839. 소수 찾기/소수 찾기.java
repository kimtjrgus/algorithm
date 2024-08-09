import java.util.HashSet;
import java.util.Set;

class Solution {
    static Set<Integer> set;
    static boolean[] visited = new boolean[7]; 
 
    // numbers는 길이 1 이상 7 이하인 문자열
    public int solution(String numbers) {
        int answer = 0;
        set = new HashSet<>();
        dfs(numbers, "", 0);
 
        for (Integer num : set) {
            if (isPrime(num)) {
                answer++;
            }
        }
        return answer;
    }
    
    // 숫자조각으로 완전 탐색 메서드
    private void dfs(String numbers, String s, int depth) {
		// numbers 의 끝까지 다 탐색했다면 종료
        if (depth > numbers.length()) {
            return;
        }
 
        for (int i = 0; i < numbers.length(); i++) {
            if(!visited[i]) {
                visited[i] = true;
                set.add(Integer.parseInt(s + numbers.charAt(i)));
                dfs(numbers ,s + numbers.charAt(i), depth + 1);
                visited[i] = false;
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