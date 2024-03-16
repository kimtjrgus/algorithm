/*
@param 시작점 S, 길이 O, 장애물이 X의 격자공원 park
@param 로봇강아지, 미리 입력된 명령 routes
@return 모든 명령 수행 후 놓일 지점

* 범위를 벗어나거나 장애물을 만날 경우 해당명령을 무시, 다음명령 수행
*/

class Solution {
    public int[] solution(String[] park, String[] routes) {
        // 1. 강아지의 위치를 저장할 변수 선언 및 초기화 (x,y)
        int x = 0, y = 0;
        
        // 2. 시작점 x,y 찾기
        for (int i = 0; i < park.length; i++) {
            if (park[i].indexOf('S') != -1) {
                x = i; // 행 위치 저장
                y = park[i].indexOf('S'); // 열 위치 저장
                break;
            }
        }
        
        // 3. routes 순회 > 순회하며 if 예외조건시 continue
        for(String route : routes){
            char direction = route.charAt(0);
            int distance = Integer.parseInt(route.substring(2));
            
            // 이동하기 전 위치 저장
            int prevX = x, prevY = y;

            for (int d = 1; d <= distance; d++) {
                switch (direction) {
                    case 'E':
                        if (++y >= park[0].length() || park[x].charAt(y) == 'X') {
                            x = prevX;
                            y = prevY; // 회귀
                            break;
                        }
                        break;
                    case 'W':
                        if (--y < 0 || park[x].charAt(y) == 'X') {
                            x = prevX;
                            y = prevY; // 회귀
                            break;
                        }
                        break;
                    case 'S':
                        if (++x >= park.length || park[x].charAt(y) == 'X') {
                            x = prevX;
                            y = prevY; // 회귀
                            break;
                        }
                        break;
                    case 'N':
                        if (--x < 0 || park[x].charAt(y) == 'X') {
                            x = prevX;
                            y = prevY; // 회귀
                            break;
                        }
                        break;
                }
                // 예외 상황 발생 시 for 루프 탈출
                if (x == prevX && y == prevY) break;
            }
        }
        
        // 4. return (x,y)
        return new int[]{x, y};
    }
}