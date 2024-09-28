class Solution {
    public String solution(String p) {
        // 1. 빈 문자열인 경우, 빈 문자열 반환
        if (p.isEmpty()) {
            return "";
        }
        
        // 2. 문자열을 균형잡힌 괄호 문자열 u, v로 분리
        int idx = splitBalanced(p);
        String u = p.substring(0, idx);
        String v = p.substring(idx);
        
        // 3. u가 올바른 괄호 문자열인 경우
        if (isCorrect(u)) {
            return u + solution(v); // v를 재귀적으로 수행한 결과를 붙여서 반환
        } else {
            // 4. u가 올바르지 않은 경우
            StringBuilder sb = new StringBuilder();
            sb.append('('); // 4-1. '(' 추가
            sb.append(solution(v)); // 4-2. v에 대해 1단계부터 재귀적으로 수행한 결과 붙이기
            sb.append(')'); // 4-3. ')' 추가
            sb.append(reverseAndRemoveFirstLast(u)); // 4-4. u의 첫번째와 마지막 문자를 제거하고 뒤집어서 붙이기
            return sb.toString(); // 4-5. 생성된 문자열 반환
        }
    }

    // 문자열을 균형잡힌 괄호 문자열로 분리하는 함수
    private int splitBalanced(String p) {
        int balance = 0;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(') {
                balance++;
            } else {
                balance--;
            }
            // 균형잡힌 문자열이 되는 지점
            if (balance == 0) {
                return i + 1;
            }
        }
        return p.length(); // 이론적으로 여기에 도달하지 않음
    }

    // 올바른 괄호 문자열인지 체크하는 함수
    private boolean isCorrect(String u) {
        int balance = 0;
        for (char c : u.toCharArray()) {
            if (c == '(') {
                balance++;
            } else {
                balance--;
            }
            // 중간에 balance가 음수가 되면 올바른 문자열이 아님
            if (balance < 0) {
                return false;
            }
        }
        return balance == 0; // 모두 탐색 후 balance가 0이어야 올바른 문자열
    }

    // u의 첫번째와 마지막 문자를 제거하고 나머지 문자열의 괄호 방향을 뒤집는 함수
    private String reverseAndRemoveFirstLast(String u) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < u.length() - 1; i++) {
            if (u.charAt(i) == '(') {
                sb.append(')');
            } else {
                sb.append('(');
            }
        }
        return sb.toString();
    }
}