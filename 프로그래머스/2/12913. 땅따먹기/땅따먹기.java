class Solution {
    int solution(int[][] land) {
        int rows = land.length;

        // 각 행을 순회
        for (int i = 1; i < rows; i++) {
            // 각 열에 대해 가능한 최대 점수를 갱신
            land[i][0] += Math.max(Math.max(land[i - 1][1], land[i - 1][2]), land[i - 1][3]);
            land[i][1] += Math.max(Math.max(land[i - 1][0], land[i - 1][2]), land[i - 1][3]);
            land[i][2] += Math.max(Math.max(land[i - 1][0], land[i - 1][1]), land[i - 1][3]);
            land[i][3] += Math.max(Math.max(land[i - 1][0], land[i - 1][1]), land[i - 1][2]);
        }

        // 마지막 행에서 최대값을 찾아 반환
        return Math.max(Math.max(land[rows - 1][0], land[rows - 1][1]),
                        Math.max(land[rows - 1][2], land[rows - 1][3]));
    }
}