import java.util.Arrays;

class Solution {
    public String solution(String X, String Y) {
        // 1. 맵핑 ?? 0~9 갯수 세기 ??
        // X, Y의 짝꿍이 존재X -> -1 
        // X, Y의 짝꿍이 0으로만 구성되어 있다면, -> 0
        
        // 1. X, Y를 한자리씩 비교하기 위해 배열 변환 후 정렬
        char[] charX = X.toCharArray();
        char[] charY = Y.toCharArray();
        Arrays.sort(charX);
        Arrays.sort(charY);
        
        // 2. 숫자 비교 후 일치할 경우 idx 감소
        StringBuilder answer = new StringBuilder();
        int idxX = charX.length -1;
        int idxY = charY.length - 1;
        
        while(idxX >= 0 && idxY >= 0){
            // 두수가 짝꿍을 이룰 경우
            if(charX[idxX] == charY[idxY]){
                answer.append(charX[idxX]);
                idxX--;
                idxY--;
            }
            else if (charX[idxX] > charY[idxY]) {
                idxX--;
            } else {
                idxY--;
            }
        }
        
        // 공통으로 나타나는 정수가 없을 경우
        if (answer.length() == 0) {
            return "-1";
        }

        // 정수 k가 0으로만 구성되어 있을 경우
        if (answer.toString().matches("0+")) {
            return "0";
        }
        
        return answer.toString();
    }
}