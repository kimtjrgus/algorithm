import java.util.*;


class Solution {
    static final int[] DISCOUNTS = {10, 20, 30, 40};  // 가능한 할인율
    static int maxSubscribers = 0;
    static int maxRevenue = 0;
    
    public int[] solution(int[][] users, int[] emoticons) {
        int[] result = new int[2]; // 정답 배열[구독자, 매출액]
        // 1. emo.length 길이의 할인율 조합 생성 [10, 10,,,] [10, 20,,,]
        int[] discountRates = new int[emoticons.length];
        List<int[]> allComb = 
            createCombinations(discountRates.length);
        
        // 2. 더 최적의 조합 평가
        for (int[] discountRate : allComb){
            evaluate(discountRate, users, emoticons);
        }
        
        result[0] = maxSubscribers;
        result[1] = maxRevenue;
        return result;
    }
    
    // 모든 할인율 조합 생성 메서드
    private List<int[]> createCombinations(int length){
        List<int[]> allComb = new ArrayList<>();
        int totalComb = (int)Math.pow(DISCOUNTS.length, length);
        
        // 1. 가능한 모든 조합 생성
        for(int comb=0; comb<totalComb; comb++){
            int[] discountRates = new int[length];
            int temp = comb;
            
            for(int i=0; i<length; i++){
                discountRates[i] = DISCOUNTS[temp %DISCOUNTS.length];
                temp /= DISCOUNTS.length;
            }
            allComb.add(discountRates); // 조합리스트에 추가
        }
        return allComb;
    }
    
    // 최적 조합인지 평가 메서드
    private void evaluate(int[] discountRates, int[][] users, int[] emoticons) {
        int subscribers = 0;
        int revenue = 0;

        for (int[] user : users) {
            int requiredDiscount = user[0];  // 유저가 요구하는 최소 할인율
            int minPrice = user[1];         // 임플 가입 조건
            int totalSpent = 0;

            // 사용자가 이모티콘을 구매
            for (int i = 0; i < emoticons.length; i++) {
                if (discountRates[i] >= requiredDiscount) {
                    totalSpent += emoticons[i] * (100 - discountRates[i]) / 100;
                }
            }

            // 기준 금액 초과 시 임플 가입, 그렇지 않으면 매출 합산
            if (totalSpent >= minPrice) {
                subscribers++;
            } else {
                revenue += totalSpent;
            }
        }

        // 최적화 조건에 따라 결과 갱신
        if (subscribers > maxSubscribers) {
            maxSubscribers = subscribers;
            maxRevenue = revenue;
        } else if (subscribers == maxSubscribers) {
            if (revenue > maxRevenue) {
                maxRevenue = revenue;
            }
        }
    }
}

/*
user[][] 2차원 배열 [할인율, 금액이상 이면 임플 구독]
emoticons[] 1차원 배열 [이모티콘의 정가] 
result[임플 구독자 수, 임티 매출액] 

규칙: 
- 정해진 할인 비율은 없으나, 임티별 할인율을 각개지정해 result를 최대로 만들 것
- 1. 이모티콘 플러스 가입자 최대, 2. 이모티콘 판매액 최대
- 1번 우선, 이후 2번

// 1. 할인율 조합 생성 [10, 10,,,] [10, 20,,,] 
// 2. 결과 계산
// 3. 더 최적의 조합 선택 
*/