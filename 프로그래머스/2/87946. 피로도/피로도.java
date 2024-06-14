import java.util.*;
// 현재 피로도 k, dungeons [[최소 필요 피로도, 소모 피로도], [ ], ,,,]
// 서로 다른 던전도 피로도 배열이 같을 수 있음. 다른 던전 취급 요망
// 던전은 한개에 한번씩, 재도전x 
class Solution {
    // 전역변수 : 최대 던전 수 
    private int maxDungeons = 0;

    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        exploreDungeons(k, dungeons, visited, 0);
        return maxDungeons;
    }
    
    // 현재 피로도, 던전 정보, 방문 여부
    private void exploreDungeons(int fatigue, int[][] dungeons, boolean[] visited, int count) {
        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && fatigue >= dungeons[i][0]) {
                visited[i] = true;
                exploreDungeons(fatigue - dungeons[i][1], dungeons, visited, count + 1);
                visited[i] = false;
            }
        }
        maxDungeons = Math.max(maxDungeons, count);
    }
}