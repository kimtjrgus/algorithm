import java.util.*;

class Solution {
    int answer = 0; // 비밀코드로 가능한 정수 조합 갯수
    int[][] qGlobal;
    int[] ansGlobal;
    int n;

    public int solution(int n, int[][] q, int[] ans) {
        this.n = n;
        this.qGlobal = q;
        this.ansGlobal = ans;

        List<Integer> current = new ArrayList<>();
        comb(1, current);

        return answer;
    }

    // 1~n 사이 서로 다른 정수 5개 조합을 생성
    void comb(int start, List<Integer> current) {
        if (current.size() == 5) {
            if (isValid(current)) {
                answer++;
            }
            return;
        }

        for (int i = start; i <= n; i++) {
            current.add(i);
            comb(i + 1, current);
            current.remove(current.size() - 1); // 백트래킹
        }
    }

    // q, ans 조건을 만족하는지 검사
    boolean isValid(List<Integer> comb) {
        Set<Integer> codeSet = new HashSet<>(comb);

        for (int i = 0; i < qGlobal.length; i++) {
            int count = 0;
            for (int val : qGlobal[i]) {
                if (codeSet.contains(val)) count++;
            }

            if (count != ansGlobal[i]) {
                return false;
            }
        }

        return true;
    }
}

// 1. 비밀코드로 만들 1~n 사이 정수 5개를 뽑아 조합 생성
// 2. 생성된 조합을 2차원배열 q와 ans배열 값 비교
// 3. 2번 조건에 적합하다면 answer++
        