import java.util.*;

class Solution {
    public int solution(String[][] relation) {
        int columnCount = relation[0].length; // 속성 개수
        int rowCount = relation.length;      // 튜플 개수
        List<Integer> candidateKeys = new ArrayList<>();//후보키 리스트

        // 모든 속성 조합 탐색(1부터 2^columnCount - 1까지)
        for (int subset = 1; subset < (1 << columnCount); subset++) {
            if (!isUnique(subset, relation)) continue;
            if (!isMinimal(subset, candidateKeys)) continue;

            candidateKeys.add(subset);
        }

        return candidateKeys.size(); // 후보키 개수 반환
    }
    
    // 유일성 검사 메서드
    private boolean isUnique(int subset, String[][] relation){
        Set<String> seen = new HashSet<>();
        for (String[] tuple : relation) {
            StringBuilder key = new StringBuilder();
            for (int col = 0; col < relation[0].length; col++) {
                // subset에 col이 포함된 경우
                if ((subset & (1 << col)) != 0) { 
                    key.append(tuple[col]).append(",");
                }
            }
            // 중복 발견
            if (!seen.add(key.toString())) return false; 
        }
        return true;
    }
    
    // 최소성 검사 메서드
    private boolean isMinimal(int subset, 
                              List<Integer> candidateKeys){
        for (int key : candidateKeys){
            // 기존 후보키의 부분 집합이면 실패
            if ((key & subset) == key) return false; 
        }
        return true;
    }
}

/*
후보키- 유일성, 최소성

1) 유일성 검사
2) 최소성 검사
*/