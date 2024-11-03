class Solution {
    // 상하좌우, 대각선, 두 칸 상하좌우 방향 배열을 상수
    private static final int[][] DIRECTIONS = 
    {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 상하좌우
    private static final int[][] DIAGONAL_DIRECTIONS = 
    {{-1, -1}, {-1, 1}, {1, -1}, {1, 1}}; // 대각선
    private static final int[][] TWO_STEPS_DIRECTIONS = 
    {{-2, 0}, {2, 0}, {0, -2}, {0, 2}}; // 두 칸 상하좌우

    public int[] solution(String[][] places) {
        int[] answer = new int[5]; // 각 대기실의 거리두기 여부
        
        // 각 대기실에 대해 거리두기 검사
        for (int i = 0; i < places.length; i++) {
            answer[i] = checkPlace(places[i]) ? 1 : 0;
        }
        
        return answer;
    }
    
    // 각 대기실 거리두기 여부 
    private boolean checkPlace(String[] place) {
        // 대기실을 2차원 배열로 변환
        char[][] map = new char[5][5]; 
        for (int i = 0; i < 5; i++) {
            map[i] = place[i].toCharArray();
        }

        // 모든 좌표를 순회하며 응시자 위치('P') 찾기
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (map[i][j] == 'P' && !isValid(map, i, j)) {
                    return false; // 거리두기 위반 시 즉시 반환
                }
            }
        }
        return true; // 거리두기 조건 만족 시 
    }

    private boolean isValid(char[][] map, int x, int y) {
        // 상하좌우 검사
        for (int[] d : DIRECTIONS) {
            int nx = x + d[0], ny = y + d[1];
            if (nx >= 0 && ny >= 0 && nx < 5 && ny < 5 && map[nx][ny] == 'P') {
                return false;
            }
        }

        // 대각선 검사
        for (int[] d : DIAGONAL_DIRECTIONS) {
            int nx = x + d[0], ny = y + d[1];
            if (nx >= 0 && ny >= 0 && nx < 5 && ny < 5 && map[nx][ny] == 'P') {
                if (map[x][ny] != 'X' || map[nx][y] != 'X') {
                    return false;
                }
            }
        }

        // 두 칸 떨어진 상하좌우 검사
        for (int[] d : TWO_STEPS_DIRECTIONS) {
            int nx = x + d[0], ny = y + d[1];
            if (nx >= 0 && ny >= 0 && nx < 5 && ny < 5 && map[nx][ny] == 'P') {
                int mx = x + d[0] / 2, my = y + d[1] / 2;
                if (map[mx][my] != 'X') {
                    return false;
                }
            }
        }

        return true;
    }
}


/*
param : places > 5개 대기실의 원소값 > 5*5배열
p 응시자, 0은 빈테이블, x는 파티션

응시자들끼리 맨해튼거리 2이하 금지,
단, 파티션으로 막혀있을 경우는 허용,

return 거리두기 지킴 1 , 안지킴 0 
ex [0,0,0,1,0]
*/