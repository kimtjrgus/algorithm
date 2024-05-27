class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        // 곱할 수 있는 배열만 주어짐.
        // arr1 (m,n)크기의 배열/ arr2 (n, p)크기의 배열
        int m = arr1.length; 
        int n = arr1[0].length; 
        int p = arr2[0].length; 
        
        int[][] result = new int[m][p]; 
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < p; j++) {
                for (int k = 0; k < n; k++) {
                    result[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }

        return result;
    }
}