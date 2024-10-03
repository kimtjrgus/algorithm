import java.util.*;

class Solution {
    public int solution(int[][] data, int col, 
                        int row_begin, int row_end) {
        // 1. 주어진 col 번째 컬럼을 기준으로 오름차순 정렬
        //    같은 값일 경우 기본키인 첫 번째 컬럼을 기준으로 내림차순 정렬
        Arrays.sort(data, (a, b) -> {
            // 기본키 기준 내림차순    
            if (a[col - 1] == b[col - 1]) return b[0] - a[0];
            
            // col 번째 컬럼 기준 오름차순
            else return a[col - 1] - b[col - 1]; 
        });

        // 2. row_begin 부터 row_end 까지의 행에 대해 S_i 계산 및 XOR 누적
        int hashValue = 0; // 해시값 선언
        
        for (int i = row_begin - 1; i < row_end; i++) { // 인덱스는 0부터 시작하므로 -1
            int sum = 0;
            for (int value : data[i]) {
                // S_i 계산 (i + 1 은 1-based 인덱스)
                sum += value % (i + 1); 
            }
            hashValue ^= sum; // XOR 연산
        }
        
        // return 최종 해시값 
        return hashValue; 
    }
}
// 정렬된 데이터에서 S_i를 i 번째 행의 튜플에 대해 각 컬럼의 값을 i 로 나눈 
//나머지들의 합으로 정의합니다.
// row_begin ≤ i ≤ row_end 인 모든 S_i를 누적하여 
// bitwise XOR 한 값을 해시 값으로서 반환합니다.
