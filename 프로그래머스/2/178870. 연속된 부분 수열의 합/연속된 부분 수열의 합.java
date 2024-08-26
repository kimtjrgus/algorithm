class Solution {
    public int[] solution(int[] sequence, int k) {
        // 1. 투 포인터를 사용할 초기 변수 설정
        int left = 0;  // 왼쪽 포인터 초기화
        int right = 0; // 오른쪽 포인터 초기화
        int currentSum = 0; // 현재 부분 수열의 합 초기화
        int[] result = {0, sequence.length}; // 결과를 저장할 배열 초기화 

        // 2. 오른쪽 포인터가 수열의 끝에 도달할 때까지 반복
        while (right < sequence.length) {
            currentSum += sequence[right]; 

            // 3. 현재 부분 수열의 합이 k보다 크거나 같으면, 왼쪽 포인터를 이동시켜 조건을 만족시키는지 확인
            while (currentSum >= k) {
                // 4. 합이 정확히 k일 경우 결과 업데이트
                if (currentSum == k) {
                    if ((right - left) < (result[1] - result[0])) {
                        result[0] = left;
                        result[1] = right;
                    }
                }
                // 5. 왼쪽 포인터를 오른쪽으로 이동하며, 부분 수열의 합을 감소시킴
                currentSum -= sequence[left];
                left++;
            }
            // 6. 오른쪽 포인터를 오른쪽으로 이동
            right++;
        }
        
        return result;
    }
}