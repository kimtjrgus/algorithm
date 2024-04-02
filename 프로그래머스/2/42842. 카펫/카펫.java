/*
중앙은 노란색, 테두리1줄은 갈색인 카페트
카펫 타일 규칙 찾기

brown - 4 == 노란색타일의 가로+세로
노란 타일의 width = length + 4 - brown

*/
class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2]; // brown의 가로세로,[width+2, length+2]
        int width = 0;
        int length = 0; // yellow의 가로세로
        
        for(int l=1; l<= yellow; l++){
            // yellow 타일이 세로길이로 나누어떨어지는 경우 가로세로 결정
            length = l;
            if(yellow % length == 0){
                width = yellow/length;
                int b = (length + width) * 2 + 4;
                
                System.out.print(width + " " + length + " " + b);
                
                if(brown == b){
                    answer[0] = width + 2;
                    answer[1] = length + 2;
                    break;
                }
            }
        }
        
        return answer;
    }
}