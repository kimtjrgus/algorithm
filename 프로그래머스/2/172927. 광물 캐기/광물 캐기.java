import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        // picks[다이아, 철, 돌] 곡괭이 순 개수, 각 최소 1개이상
        // 예외, 곡괭이 수가 광물 수보다 부족할 경우
        int maxMinerals = 5 * (picks[0] + picks[1] + picks[2]); 
        minerals = Arrays.copyOfRange(minerals, 0, Math.min(maxMinerals, minerals.length));

        
        // 1. 광물 구간별 [다이아, 철, 돌] 개수 기록
        List<int[]> mineralCounts = new ArrayList<>();
        for (int i = 0; i < minerals.length; i += 5) {
            int[] count = new int[3]; // [다이아, 철, 돌] 개수
            for (int j = i; j < Math.min(i + 5, minerals.length); j++) {
                if (minerals[j].equals("diamond")) count[0]++;
                else if (minerals[j].equals("iron")) count[1]++;
                else count[2]++;
            }
            mineralCounts.add(count);
        }

        // 2. 구간별 피로도 계산 (최악의 경우 돌 곡괭이로 캤을 때)
        mineralCounts.sort((a, b) -> {
            int worstA = a[0] * 25 + a[1] * 5 + a[2];
            int worstB = b[0] * 25 + b[1] * 5 + b[2];
            return Integer.compare(worstB, worstA); // 내림차순 정렬
        });

        // 3. 곡괭이 사용하며 최소 피로도 계산
        int answer = 0;
        for (int i = 0; i < mineralCounts.size(); i++) {
            int[] count = mineralCounts.get(i);

            if (picks[0] > 0) { // 다이아 곡괭이 사용
                answer += count[0] + count[1] + count[2]; // 피로도 1씩
                picks[0]--;
            } else if (picks[1] > 0) { // 철 곡괭이 사용
                answer += count[0] * 5 + count[1] + count[2]; // 다이아 5, 나머지 1
                picks[1]--;
            } else if (picks[2] > 0) { // 돌 곡괭이 사용
                answer += count[0] * 25 + count[1] * 5 + count[2]; // 다이아 25, 철 5, 돌 1
                picks[2]--;
            } else {
                break; // 더 이상 곡괭이가 없으면 종료
            }
        }

        return answer;
    }
}

/*
- 각 괭이는 종류 상관없이 광물5개를 캐면 사용 불가
- 최소 피로도.
- 사용가능한 괭이중 아무거나 선택해 광물캠
- 한번 사용하기 시작한 것은 못 쓸 때까지 사용 -> 5회 사용
- 골라캐기x, 순서대로만 캐기
//
/*생각하기
최소 피로도를 충족하기 위해, 그리디? dp?
다이아가 많은 구간을 캐치해서 다이아 곡괭이를 잘 배치해야함.

1) 미네랄을 5씩 구간을 나누고, 점수화? 높은 구간순으로 정렬 후 정리
최악의 상황시(돌괭이) 미네랄 5개의 피로도를 수치화하고 높은 순으로 정렬
*/