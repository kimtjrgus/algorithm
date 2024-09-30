import java.util.*;

class Solution {
    public long solution(String expression) {
        // 1. 연산자 추출
        Set<String> operatorSet = new HashSet<>();
        for (char c : expression.toCharArray()) {
            if (c == '+' || c == '-' || c == '*') {
                operatorSet.add(String.valueOf(c));
            }
        }
        
        // 2. 연산자 순열 생성
        List<String> operators = new ArrayList<>(operatorSet);
        List<List<String>> operatorPermutations = new ArrayList<>();
        permute(operators, 0, operatorPermutations);
        
        // 숫자와 연산자 분리
        List<Long> numbers = new ArrayList<>();
        List<String> ops = new ArrayList<>();
        
        StringBuilder number = new StringBuilder();
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (Character.isDigit(c)) {
                number.append(c);
            } else {
                numbers.add(Long.parseLong(number.toString()));
                number = new StringBuilder();
                ops.add(String.valueOf(c));
            }
        }
        numbers.add(Long.parseLong(number.toString())); // 마지막 숫자 추가
        
        long maxResult = 0;
        
        // 3. 우선순위 경우의 수마다 연산 수행
        for (List<String> priority : operatorPermutations) {
            List<Long> tempNumbers = new ArrayList<>(numbers);
            List<String> tempOperators = new ArrayList<>(ops);
            
            for (String op : priority) {
                for (int i = 0; i < tempOperators.size();) {
                    if (tempOperators.get(i).equals(op)) {
                        long num1 = tempNumbers.get(i);
                        long num2 = tempNumbers.get(i + 1);
                        long result = calculate(num1, num2, op);
                        
                        tempNumbers.remove(i + 1);
                        tempNumbers.set(i, result);
                        tempOperators.remove(i);
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
    private void permute(List<String> arr, int k, List<List<String>> permutations) {
        if (k == arr.size()) {
            permutations.add(new ArrayList<>(arr));
        } else {
            for (int i = k; i < arr.size(); i++) {
                Collections.swap(arr, i, k);
                permute(arr, k + 1, permutations);
                Collections.swap(arr, i, k); // 복구
            }
        }
    }
    
    // 두 숫자와 연산자를 받아서 계산
    private long calculate(long num1, long num2, String op) {
        switch (op) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
        }
        return 0;
    }
}
