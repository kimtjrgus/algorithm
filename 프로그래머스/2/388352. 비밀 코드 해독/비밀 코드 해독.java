import java.util.*;

class Solution {
    int answer = 0; // 비밀코드로 가능한 정수 조합 갯수
    int[][] q;
    int[] ans;
    int n, m;

    public int solution(int n, int[][] q, int[] ans) {
        this.n = n;
        this.q = q;
        this.ans = ans;
        this.m = ans.length;
        
        // 1. 비밀코드로 만들 1~n 사이 정수 5개를 뽑아 조합 생성
        // 2. 생성된 조합을 2차원배열 q와 ans배열 값 비교 isValid
        // 3. 2번 조건에 적합하다면 answer++
        
        int[] comb = new int[5];
        generateComb(0, 1, comb);

        return answer;
    }

    // 1~n 사이 서로 다른 정수 5개 조합을 생성
    void generateComb(int depth, int start, int[] comb) {
        if (depth == 5) {
            if (isValid(comb)) answer++;
            
            return;
        }

        for (int i = start; i <= n; i++) {
            comb[depth] = i;
            generateComb(depth + 1, i + 1, comb); 
        }
    }

    // q, ans 조건을 만족하는지 검사
    boolean isValid(int[] comb) {
        for (int i = 0; i < m; i++) {
            int cnt = 0;

            // q[i].length == 5, comb.length == 5 -> 작은 루프
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    if (comb[k] == q[i][j]) {
                        cnt++;
                        break;
                    }
                }
            }

            // 조기 탈락
            if (cnt != ans[i]) return false;
        }

        return true;
    }
}
