import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        // 논문 n편중 h번이상 인용된 논문이 h이상
        // n-h편중 h번이하 인용되었다면 h는 H-Index
        
        // 1. citations는 논문의 인용횟수를 담은 배열
        int n = citations.length;
        int Hindex = 0;
        Arrays.sort(citations); 
        
        // 2. H-Index 계산
        for (int i = 0; i < n; i++) {
            // citations[i]는 현재 논문의 인용 횟수
            // (n - i)는 현재 논문을 인용한 논문의 수
            if (citations[i] >= n - i) {
                Hindex = n - i; // H-Index 갱신
                break; // 조건을 만족하면 반복 종료
            }
        }
        
        return Hindex;
    }
}