
class Solution {
    public int[] solution(int brown, int yellow) {
        // brown의 가로세로,[width+2, length+2]
        int[] answer = new int[2]; 
        int totalTiles = brown + yellow; // 전체 타일 수
        
        // 전체 타일 수의 제곱근까지 약수를 찾습니다.
        for (int width = 1; width <= Math.sqrt(totalTiles); width++) {
            if (totalTiles % width == 0) {
                int length = totalTiles / width;
                
                // yellow 타일의 가로, 세로 길이를 구하고 조건을 만족하는지 확인합니다.
                if ((width - 2) * (length - 2) == yellow) {
                    answer[1] = width;
                    answer[0] = length;
                    break;
                }
            }
        }
        
        return answer;
    }
}
/*
중앙은 노란색, 테두리1줄은 갈색인 카페트
카펫 타일 규칙 찾기

brown - 4 == 노란색타일의 가로+세로
노란 타일의 width = length + 4 - brown

*/