import java.util.*;

/*
선물지수 : 이번달까지 자신이 친구에게 선물한 수 - 받은 선물 수  
if 두사람이 선물을 주고 받은 기록이 있다
- 이번달까지 두사람 사이 더 많은 선물을 준사람이 다음달에 선물을 하나 받음
else if 없거나 주고받은 수가 같을 경우
- 선물지수가 더 작은사람이 하나받음.
else (선물지수도 같고 선물수도 같다) 서로 선물을 주고받지 않음

@param friends : 친구들의 이름은 담은 1차원 배열
@param gifts   : 주고받은 선물 기록을 담은 1차원 배열["준사람 받은사람", ...]
@return : 다음달에 가장 많은 선물을 받는 친구의 선물 수
*/
class Solution {
    public int solution(String[] friends, String[] gifts) {
        int n = friends.length;
        int[][] history = new int[n][n]; //주고 받은 선물 내역 저장
        int[] giftScore = new int[n]; //선물 지수 저장
        int[] nextMonthGift = new int[n]; //다음달 받는 선물의 수 저장

        HashMap<String, Integer> friendIdx = new HashMap<>(); //친구들의 index를 저장
        for (int i = 0; i < n; i++) {
            friendIdx.put(friends[i], i);
        }

        for (String gift : gifts) {
            String[] tmp = gift.split(" ");
            int giverIdx = friendIdx.get(tmp[0]);
            int takerIdx = friendIdx.get(tmp[1]);

            //선물을 주고 받은 내역 기록
            history[giverIdx][takerIdx]++;

            //선물 지수를 계산
            giftScore[giverIdx]++;
            giftScore[takerIdx]--;
        }

        //history 배열은 주고 받은 관계가 i와 j가 대칭을 이루므로 절반만 반복하면 된다.
        for (int giver = 0; giver < n; giver++) {
            for (int taker = giver + 1; taker < n; taker++) {
                int give = history[giver][taker];
                int take = history[taker][giver];

                //주고 받은 선물 계산
                if (give > take) {
                    nextMonthGift[giver]++;
                }
                else if (give < take) {
                    nextMonthGift[taker]++;
                }
                //주고 받은 기록이 없거나 주고 받은 수가 같은 경우 선물 지수를 비교한다.
                else {
                    if (giftScore[giver] > giftScore[taker]) {
                        nextMonthGift[giver]++;
                    } else if (giftScore[giver] < giftScore[taker]) {
                        nextMonthGift[taker]++;
                    }
                }
            }
        }

        //선물 지수 중 가장 큰 값을 찾아 반환
        return Arrays.stream(nextMonthGift)
                .max()
                .getAsInt();
    }
}