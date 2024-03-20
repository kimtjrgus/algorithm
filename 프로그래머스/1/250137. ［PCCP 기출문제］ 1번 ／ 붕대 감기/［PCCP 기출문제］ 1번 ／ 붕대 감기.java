/*
붕대감기 : t초동안 초당 x만큼 회복, t초를 모두 완수한다면 y만큼 추가회복
단, 최대체력은 초과x

공격당하면 즉시 붕대감기 재시작, 시간은 0으로 초기화
피해량만큼 체력감소, 0되면 사망

@param bandage : [붕대 감기 시전시간t, 초당 회복량x, 추가회복량y]
@param health  : 최대 체력
@param attacks : [[공격시간, 피해량], [공격시간, 피해량], ...]
@return : 모든 공격이 끝난 후 남은 체력/ 캐릭터사망시 -1 
*/
class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        // 변수 선언 
        int HP = health;    // 현재 체력, 최대체력으로 초기화
        int recoveryTime = 0; // 붕대 감기 시간 카운트
        int endOfAttack = attacks[attacks.length -1][0]; // 공격 종료 시점
        int attackIndex = 0;
        
        // 공격 -> 회복
        for(int i = 1; i<= endOfAttack; i++){
            // 현재시간이 공격시간과 일치한다면 체력깎고, recoveryTime 0으로 초기화
            // 공격
            if(attacks[attackIndex][0] == i){
                HP -= attacks[attackIndex][1]; // 체력 감소
                if(HP <= 0) return -1; // 캐릭터 사망
                
                attackIndex++; // 다음 공격 준비
                recoveryTime = 0; // 붕대 연속 감기 초기화
            }
            
            // 회복
            else{ // bandage : [붕대 감기 시전시간t, 초당 회복량x, 추가회복량y]
                recoveryTime++;
                HP = Math.min(HP + bandage[1], health);
                
                if(recoveryTime == bandage[0]){                  
                    HP = Math.min(HP + bandage[2], health); // 추가 회복
                    recoveryTime = 0;
                }
            }
            
        }
        
        int answer = HP; // 모든 공격이 종료된 후 HP
        return answer; 
    }
}