import java.util.*;

class Solution {
    // 이동 방향 (우, 좌, 하, 상)
    private static final int[] dx = {0, 0, 1, -1};
    private static final int[] dy = {1, -1, 0, 0};

    // solution 메서드: storage와 requests 배열을 받아서 처리하고 결과 반환
    public int solution(String[] storage, String[] requests) {
        // storage를 2D char 배열로 변환
        char[][] containers = new char[storage.length][];

        for (int i = 0; i < storage.length; i++) {
            containers[i] = storage[i].toCharArray();  // 각 행을 문자 배열로 변환
        }

        // 요청 처리
        for (String request : requests) {
            char c = request.charAt(0);  // 요청의 첫 문자 가져오기

            // 요청이 1글자면 지게차 방식으로, 그 외는 크레인 방식으로 처리
            if (request.length() == 1) {
                removeWithForklift(containers, c);  // 지게차 방식으로 제거
            } else {
                removeWithCrane(containers, c);  // 크레인 방식으로 제거
            }
        }

        // 남은 컨테이너 개수 계산
        int count = 0;
        for (char[] container : containers) {
            for (char c : container) {
                if (c != 0) {  // 제거되지 않은 컨테이너는 '0'이 아니므로 카운트
                    count++;
                }
            }
        }
        return count;  // 남은 컨테이너 개수 반환
    }

    // 크레인 방식으로 컨테이너 제거
    private void removeWithCrane(char[][] containers, char c) {
        for (int i = 0; i < containers.length; i++) {
            for (int j = 0; j < containers[i].length; j++) {
                if (containers[i][j] == c) {
                    containers[i][j] = 0;  // 해당 컨테이너를 '0'으로 설정하여 제거
                }
            }
        }
    }

    // 지게차 방식으로 외부 경계에서 연결된 컨테이너를 제거
    private void removeWithForklift(char[][] containers, char c) {
        boolean[][] isVisited = new boolean[containers.length][containers[0].length];  // 방문 여부 체크 배열

        // 외부 경계부터 DFS로 접근 가능한 컨테이너를 찾기
        for (int i = 0; i < containers.length; i++) {
            for (int j = 0; j < containers[i].length; j++) {
                // 외부 경계에 있는 컨테이너들만 탐색
                if ((i == 0 || j == 0 || i == containers.length - 1 || j == containers[i].length - 1)
                        && !isVisited[i][j]) {
                    dfs(containers, i, j, c, isVisited);  // DFS로 연결된 컨테이너 제거
                }
            }
        }

        // DFS를 통해 '1'로 표시된 컨테이너들을 '0'으로 바꿔서 제거
        for (int i = 0; i < containers.length; i++) {
            for (int j = 0; j < containers[i].length; j++) {
                if (containers[i][j] == 1) {
                    containers[i][j] = 0;  // '1'로 표시된 컨테이너 제거
                }
            }
        }
    }

    // DFS 탐색 함수: (x, y)에서 시작하여 연결된 동일한 컨테이너들을 제거
    private void dfs(char[][] containers, int x, int y, char c, boolean[][] isVisited) {
        // 경계 밖이거나 이미 방문한 곳이면 종료
        if (x < 0 || y < 0 || x >= containers.length || y >= containers[x].length 
                || isVisited[x][y]) {
            return;
        }

        isVisited[x][y] = true;  // 현재 위치 방문 처리

        // 현재 위치가 목표 문자와 일치하면, 해당 위치를 '1'로 표시하여 제거 예정
        if (containers[x][y] == c) {
            containers[x][y] = 1;  // 제거 가능한 컨테이너 표시
            return;
        }

        // 빈 공간인 경우는 종료
        if(containers[x][y] != 0) return;

        // 상하좌우로 DFS 재귀 호출
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            dfs(containers, nx, ny, c, isVisited);  // 인접한 위치로 DFS 재귀
        }
    }
}


/*
1. 이동 방향 배열 정의: dx = [0, 0, 1, -1], dy = [1, -1, 0, 0]
2. 'solution' 함수 정의 (입력: storage, requests)
    1. storage 배열을 2D 문자 배열 'containers'로 변환
    2. 각 요청에 대해 처리
        a. 요청이 1글자일 경우, 'removeWithForklift' 함수 호출
        b. 요청이 1글자가 아닐 경우, 'removeWithCrane' 함수 호출
    3. 남은 컨테이너 개수 계산
        a. 'containers' 배열을 순회하며 '0'이 아닌 컨테이너 개수 세기
    4. 남은 컨테이너 개수 반환

3. 'removeWithCrane' 함수 정의 (입력: containers, c)
    1. 'containers' 배열을 순회하며 주어진 문자 'c'를 찾고 해당 위치를 '0'으로 설정 (제거)

4. 'removeWithForklift' 함수 정의 (입력: containers, c)
    1. 방문 여부를 추적할 'isVisited' 배열 초기화
    2. 'containers' 배열의 외부 경계를 순회하며 DFS 탐색
        a. 외부 경계에 위치한 미방문 컨테이너가 'c'와 일치하면 DFS 호출하여 연결된 컨테이너 제거
    3. DFS 탐색 후, '1'로 표시된 컨테이너들을 '0'으로 변경하여 제거

5. 'dfs' 함수 정의 (입력: containers, x, y, c, isVisited)
    1. 현재 위치가 배열의 경계를 벗어나거나 이미 방문한 곳이라면 종료
    2. 현재 위치가 주어진 문자 'c'와 일치하면 해당 위치를 '1'로 표시
    3. 현재 위치가 빈 공간이 아니면 종료
    4. 상하좌우로 인접한 위치들에 대해 DFS 재귀 호출
    
*/
