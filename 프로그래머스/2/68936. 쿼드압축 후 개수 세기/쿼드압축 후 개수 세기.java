class Solution {
    public int[] solution(int[][] arr) {
        // 압축 후 최종적으로 남은 [0의 개수, 1의 개수]
        int[] answer = new int[2]; 
        
        quadTree(arr, 0, 0, arr.length, answer);
        
        return answer;
    }
    
    // 재귀, 쿼드트리를 압축하는 메서드
    private void quadTree(int[][] arr, int x, int y, 
                          int size, int[] answer){
        
        // 구역 내 배열이 모두 동일한 값이라면
        if(isCheck(arr, x, y, size)){
            if(arr[x][y] == 0) answer[0]++;
            else answer[1]++; 
        }
        else { // 배열이 같은 값으로 이루어져 있지 않으면 4분할
            int newSize = size / 2;
            quadTree(arr, x, y, newSize, answer);
            quadTree(arr, x, y + newSize, newSize, answer);
            quadTree(arr, x + newSize, y, newSize, answer);
            quadTree(arr, x + newSize, y + newSize, newSize, answer);
        }
    }
    
    // 한 영역 내 모두 동일한 값인지 확인하는 메서드
    private boolean isCheck(int[][] arr, int x, int y, int size){
        int value = arr[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (arr[i][j] != value) {
                    return false;
                }
            }
        }
        return true;
    }
}


/* 
- 0과 1로 이루어진 2차원 정수 배열 arr
- 당신이 압축하고자 하는 특정 영역을 S라고 정의합니다.
- 만약 S 내부에 있는 모든 수가 같은 값이라면, S를 해당 수 하나로 압축
- 그렇지 않다면, S를 정확히 4개의 균일한 정사각형 영역(입출력 예를 참고해주시기 바랍니다.)으로 쪼갠 뒤, 각 정사각형 영역에 대해 같은 방식의 압축을 시도합니다.
- 정답배열은 압축 후 최종적으로 남은 [0의 개수, 1의 개수]
*/