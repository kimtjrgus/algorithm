class Solution {
    public int solution(int number, int limit, int power) {
        // 기사에겐 번호가 있고, 자신의 번호에 해당하는 약수개수의 공격력 무기
        // if(공격력 > 제한수치) 정해진 공격력을 구매
        // limit은 제한수치, power은 정해진 공격력
        int answer = 0; // 공격력1당 철1kg, answer = 철 무게kg(총공격력)
    
        // 2. 약수 갯수 구하기
        for(int i=1; i<= number; i++){
            int count = 0; // 약수갯수 초기화
            
            for(int j=1; j*j<= i; j++){
                if(j*j == i) count++;
                else if(i % j ==0) count +=2;
            }
            
            // 3. count가 limit 넘을 시 power로 치환
            if(count > limit) count = power;
            
            // 4. 총합
            answer += count;
        }
        
        return answer;
    }
}