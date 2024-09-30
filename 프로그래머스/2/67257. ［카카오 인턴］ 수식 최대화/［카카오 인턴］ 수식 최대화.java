import java.util.*;

class Solution {
    public long solution(String expression) {
        // 1. 연산자 추출 및 순열 생성
        List<String> operators = new ArrayList<>();
        for (char c : expression.toCharArray()) {
            if (c == '+' || c == '-' || c == '*') {
                if (!operators.contains(String.valueOf(c))) operators.add(String.valueOf(c));
            }
        }
        List<List<String>> permutations = getPermutations(operators);

        // 숫자와 연산자 분리
        List<Long> numbers = new ArrayList<>();
        List<String> ops = new ArrayList<>();
        String num = "";
        for (char c : expression.toCharArray()) {
            if (Character.isDigit(c)) {
                num += c;
            } else {
                numbers.add(Long.parseLong(num));
                ops.add(String.valueOf(c));
                num = "";
            }
        }
        numbers.add(Long.parseLong(num));

        long maxResult = 0;

        // 2. 우선순위 경우의 수마다 연산 수행
        for (List<String> priority : permutations) {
            List<Long> tempNumbers = new ArrayList<>(numbers);
            List<String> tempOps = new ArrayList<>(ops);
            for (String op : priority) {
                for (int i = 0; i < tempOps.size(); ) {
                    if (tempOps.get(i).equals(op)) {
                        long result = calculate(tempNumbers.remove(i), tempNumbers.remove(i), op);
                        tempNumbers.add(i, result);
                        tempOps.remove(i);
                    } else {
                        i++;
                    }
                }
            }
            maxResult = Math.max(maxResult, Math.abs(tempNumbers.get(0)));
        }

        return maxResult;
    }

    // 순열 생성 함수
    private List<List<String>> getPermutations(List<String> operators) {
        List<List<String>> result = new ArrayList<>();
        if (operators.isEmpty()) return result;
        permute(operators, 0, result);
        return result;
    }

    // 순열 로직
    private void permute(List<String> arr, int index, List<List<String>> result) {
        if (index == arr.size()) {
            result.add(new ArrayList<>(arr));
        } else {
            for (int i = index; i < arr.size(); i++) {
                Collections.swap(arr, i, index);
                permute(arr, index + 1, result);
                Collections.swap(arr, i, index); // 원상복구
            }
        }
    }

    // 연산 수행
    private long calculate(long num1, long num2, String op) {
        return op.equals("+") ? num1 + num2 :
               op.equals("-") ? num1 - num2 : num1 * num2;
    }
}
