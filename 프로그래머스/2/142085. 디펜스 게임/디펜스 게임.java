import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        // 1. 변수 선언
        int answer = 0; // 막은 라운드 수
        int army = n;
        int shield = k; 
        
        // 2. 우선순위 큐 생성
        Queue<Integer> pq = 
            new PriorityQueue<>(Collections.reverseOrder());
        
        // 3. 게임 진행
        for(int i = 0; i < enemy.length; i++){
            // 3-1. 병사를 소모하며 우선순위큐에 추가.
            army -= enemy[i];
            pq.add(enemy[i]);
            
            // 3-2. 만약 병사 수가 부족하면 무적권 사용
            if (army < 0) {
                if (shield > 0) {
                    army += pq.poll();
                    shield--; 
                } 
                // 무적권이 모두 소진된 상태라면 게임 종료
                else break;
            }
            // 3-3. 라운드를 성공적으로 막은 경우 answer 증가
            answer++;
        }
        
        return answer;
    }
}

/*
디펜스게임은 n명의 병사가 연속되는 적의 공격을 '순서대로' 막는 게임
처음에 병사 n명, 매 라운드마다 enemy[i]마리 수의 적
남은 병사 중 enemyp[i]만큼 소모하여 적을 막을 수 있음
무적권이란 스킬이 있으며 소모없이 한라운드를 막을 수 있고,
무적권은 k번 사용가능

1. enemy배열에서 큰 수를 무적권으로 막아야함.
2. 큰 수를 정렬해서 찾기엔 큰 수의 기준도 모호하고, 길이가 김
//

1. 라운드를 지나며, 무적권 갯수의 길이만큼 큐를 만들고, 지나온 수들을 저장하자, 
2. 최대값을 우선순위 큐에 , 해당 라운드에 무적권을 사용하고, 병사수 복구
*/