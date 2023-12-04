class Solution {
    public int solution(String dartResult) {
        int answer = 0; // 다트게임 총점
        // 게임당 점수 배열 선언
        int[] scores = new int[3];
        String[] dart = dartResult.split("");
        int scoreIdx = -1; // 해당 라운드를 추적할 인덱스
        
        for(int i=0; i<dart.length; i++){
            // 숫자인지 확인
            if(dart[i].matches("[0-9]")){
                scoreIdx++;
                scores[scoreIdx] = Integer.parseInt(dart[i]);
                // 두자리 숫자인지 
                if(dart[i+1].matches("[0-9]")){
                    scores[scoreIdx] *= 10;
                    i++;
                }
            }
            
            // 보너스SDT와 옵션 확인
            switch(dart[i]){
                case "D":
                    scores[scoreIdx] = (int)Math.pow(scores[scoreIdx], 2);
                    break;
                case "T" :
                    scores[scoreIdx] = (int)Math.pow(scores[scoreIdx], 3);
                    break;
                case "*" :
                    scores[scoreIdx] *= 2;
                    if(scoreIdx - 1 >= 0) scores[scoreIdx-1] *= 2;
                    break;
                case "#" :
                    scores[scoreIdx] *= -1;
            }   
        }
        for(int s : scores) {
            answer += s;
        }
        
        return answer;
    }
}
// 1. 다트 게임은 총 3회
// 2. 기회마다 얻는 점수 0~10
// 3. 영역: S-1제곱, D-2제곱, T-3제곱
// 4. 옵션: 스타상*- 해당점수와 이전점수 각2배/ 아차상#- 해당점수 마이너스
// 5. 스타상은 첫번째에도 나올수있음, 이경우 첫번째만 적용,
//     스타상은 다른스타상과 중첩적용 이경우 4배,
//     스타상과 아차상 중첩적용 이경우 -2배
// 6. S,D,T 는 점수마다 하나씩 존재, 
//     스타상과 아차상은 둘중하나만 존재하며 존재하지 않을 수도 있음.
// 7. answer = 다트게임3회의 총점수