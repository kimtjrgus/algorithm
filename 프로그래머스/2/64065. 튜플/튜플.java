import java.util.*;

class Solution {
    public int[] solution(String s) {
        // 1. 문자열 전처리
        s = s.substring(2, s.length() - 2);
        String[] parts = s.split("\\},\\{");
        
        // 2. 문자열을 정수 집합으로 변환
        List<Set<Integer>> sets = new ArrayList<>();
        for (String part : parts) {
            Set<Integer> set = new HashSet<>();
            for (String num : part.split(",")) {
                set.add(Integer.parseInt(num));
            }
            sets.add(set);
        }
        
        // 3. 부분집합 배열을 길이에 따라 정렬
        sets.sort(Comparator.comparingInt(Set::size));
        
        // 4. 튜플 구성
        List<Integer> result = new ArrayList<>();
        Set<Integer> seen = new HashSet<>();
        for (Set<Integer> set : sets) {
            for (int num : set) {
                if (!seen.contains(num)) {
                    seen.add(num);
                    result.add(num);
                    break;
                }
            }
        }
        
        // 5. 배열로 변환
        return result.stream().mapToInt(i -> i).toArray();
    }
}

/*
부분집합내 순서는 바뀌어도 되지만, 부분집합을 만드는 순서는 정해져있다.
{1,2,3,4} 가 있을 경우
{1} {1,2} {1,2,3} {1,2,3,4} O
{1,4} {2,4} X
*/
