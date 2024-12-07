import java.util.*;

class Solution {
    public int solution(int[] cards) {
        int answer = 0;
        // 1. visited배열, 그룹리스트 생성
        boolean[] visited = new boolean[cards.length];
        List<Integer> groupSize = new ArrayList<>();
        
        // 2. 우선 1번카드를 고른다. 모든 그룹의 경우의 수를 나눔.
        for(int i=0; i<cards.length; i++){ 
            if(!(visited[i])){ // 아직 방문하지 않았을 경우
                // 현재 그룹의 사이즈와 상자번호 지정
                int size = 0;
                int cur = i;
                
                // while(visited[i]가 false일 경우)
                //(i를 방문하고, 사이즈++)
                while(!(visited[cur])){
                    visited[cur] = true;
                    size++;
                    cur = cards[cur] -1;
                }
                
                groupSize.add(size);
            }
        }
        
        // 3. 그룹 카드수를 비교하고 더 많은 경우의 수인 그룹 2개를 픽
        // groupSize 내림차순 정렬
        groupSize.sort(Collections.reverseOrder());
        
        if(groupSize.size() < 2) return 0;
        else return groupSize.get(0) * groupSize.get(1); 
    }
}

/*
카드 100장, 자연수 2~100
x보다 작거나 같은 카드들, 이때 무작위 카드배열 cards[]

^규칙찾기^
무작위 카드, 최대한 많은 카드가 픽되고, 많은 카드가 남는 조합
1. 우선 1번카드를 고른다. 모든 그룹의 경우의 수를 나눔.
2. 그룹 카드수를 비교하고 더 많은 경우의 수인 그룹 2개를 픽

1. visited[] 배열 생성
2. 해당 번호를 방문했을 경우 체크하며 순회
*/