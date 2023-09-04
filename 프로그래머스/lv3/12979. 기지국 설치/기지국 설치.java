class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        
        int idx = 0; // 현재 기지국 위치를 나타내는 인덱스

        // 아파트 단위로 반복
        for (int i = 1; i <= n; i++) {
            // 현재 위치가 기지국의 영향을 받지 않는 경우
            if (idx < stations.length && i >= stations[idx] - w) {
                // 기지국의 영향을 받지 않는 아파트를 설치해야 함
                i = stations[idx] + w; // 기지국의 오른쪽 끝으로 이동
                idx++; // 다음 기지국으로 이동
            } else {
                // 현재 위치에 기지국이 설치되어 있지 않으면
                // 기지국을 설치하고 기지국의 영향을 제외한 범위로 이동
                answer++;
                i += 2 * w;
            }
        }

        return answer;
    }
}