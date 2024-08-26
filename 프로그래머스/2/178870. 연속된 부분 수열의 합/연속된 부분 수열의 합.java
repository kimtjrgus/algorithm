class Solution {
    public int[] solution(int[] sequence, int k) {
        // 1. 투 포인터를 사용할 초기 변수 설정
        int left = 0;  // 왼쪽 포인터 초기화
        int right = 0; // 오른쪽 포인터 초기화
        int currentSum = 0; // 현재 부분 수열의 합 초기화
        int[] result = {0, sequence.length};

        while (right < sequence.length) {
            currentSum += sequence[right]; 

            while (currentSum >= k) {
                if (currentSum == k) {
                    if ((right - left) < (result[1] - result[0])) {
                        result[0] = left;
                        result[1] = right;
                    }
                }
                
                currentSum -= sequence[left];
                left++;
            }
            
            right++;
        }
        
        return result;
    }
}