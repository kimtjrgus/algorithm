class Solution {
    static int[][] matrix;
    
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length]; // 위치가 바뀐 숫자들 중 가장 작은 숫자 배열
		int plus = 0;
		
		// 1. 초기 행렬 선언
		matrix = new int[rows][columns];
		for(int i=0; i<rows; i++) {
			for(int j=0; j<columns; j++) {
				plus ++;
				matrix[i][j] = plus;
			}
		}
		
        // 2. 회전
		for(int i=0; i<queries.length; i++) {
			answer[i] = rotate(queries[i][0], queries[i][1],
                               queries[i][2], queries[i][3]);
		}
        return answer;
    }
    
    // 회전 메서드
	private static int rotate(int x1, int y1, int x2, int y2) {
		// 행렬과 배열을 --로 맞춰주기 
		x1--;
		y1--;
		x2--;
		y2--;
		
		// 임의의 값 하나 잡아서 temp로 빼기
		int temp = matrix[x1][y1];
		// 최소값 초기화
		int min = temp;
		
		// 윗변
		for(int i=x1; i<x2; i++) {
			matrix[i][y1] = matrix[i + 1][y1];
			min = Math.min(min, matrix[i][y1]);
		}
		// 아랫변
		for(int i=y1; i<y2; i++) {
			matrix[x2][i] = matrix[x2][i + 1];
			min = Math.min(min, matrix[x2][i]);
		}
		// 오른쪽
		for(int i=x2; i>x1; i--) {
			matrix[i][y2] = matrix[i - 1][y2];
			min = Math.min(min, matrix[i][y2]);
		}
		// 왼쪽
		for(int i=y2; i>y1; i--) {
			matrix[x1][i] = matrix[x1][i - 1];
			min = Math.min(min, matrix[x1][i]);
		}
		matrix[x1][y1 + 1] = temp;
		return min;
	}
}

// https://youtu.be/Z6QwmMQYZr8
// https://rovictory.tistory.com/17 참고함.

