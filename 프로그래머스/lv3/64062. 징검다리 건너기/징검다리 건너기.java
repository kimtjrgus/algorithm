class Solution {
    public int solution(int[] stones, int k) {
        int left = 1;
    int right = 200_000_000; // 친구의 수 범위

    while (left <= right) {
        int mid = (left + right) / 2; // 현재 시도하는 친구의 수
        int cnt = 0; // 연속으로 못 건넌 디딤돌 개수

        for (int stone : stones) {
            if (stone - mid <= 0) {
                cnt++;
                if (cnt >= k) break; // k번 이상 연속으로 건너지 못하면 종료
            } else {
                cnt = 0; // 연속으로 못 건넌 디딤돌 개수 초기화
            }
        }

        if (cnt >= k) {
            right = mid - 1; // 더 작은 범위에서 다시 시도
        } else {
            left = mid + 1; // 더 큰 범위에서 다시 시도
        }
    }

    return left; // 최대로 건널 수 있는 친구의 수 반환
    }
}


// k는 점프할 수 있는 징검다리 수