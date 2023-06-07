package level1;

import java.util.Arrays;
import java.util.HashMap;

class RunRace {
    public static String[] solution(String[] players, String[] callings) {
        HashMap<String, Integer> playerMap = new HashMap<>();

        // 선수 이름과 초기 등수 매핑
        for (int i = 0; i < players.length; i++) {
            playerMap.put(players[i], i + 1);
        }

        // 부른 선수가 누구인지 확인하고 등수 조정
        for (String calling : callings) {
            int callingIndex = playerMap.get(calling);

            // 부른 선수의 등수를 1 감소시킴
            for (String player : playerMap.keySet()) {
                if (playerMap.get(player) < callingIndex) {
                    playerMap.put(player, playerMap.get(player) - 1); // 수정: 등수를 1 감소시킴
                }
            }

            // 부른 선수의 등수를 1등으로 변경
            playerMap.put(calling, 1);
        }

        // 등수 순서대로 선수 이름을 배열에 담음
        String[] answer = new String[players.length];
        for (String player : playerMap.keySet()) {
            int index = playerMap.get(player) - 1;
            answer[index] = player;

            // 수정: 인덱스 범위를 체크하고, 유효한 범위 내에서만 값을 할당
            if (index >= 0 && index < answer.length) {
                answer[index] = player;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] players = {"mumu", "soe", "poe", "kai", "mine"};
        String[] callings = {"kai", "kai", "mine", "mine"};

        String[] answer = solution(players, callings);

        System.out.println(Arrays.toString(answer));
    }
}

/*

# 제한사항
5 ≤ players의 길이 ≤ 50,000
- players[i]는 i번째 선수의 이름을 의미합니다.
- players의 원소들은 알파벳 소문자로만 이루어져 있습니다.
- players에는 중복된 값이 들어가 있지 않습니다.
- 3 ≤ players[i]의 길이 ≤ 10

2 ≤ callings의 길이 ≤ 1,000,000
- callings는 players의 원소들로만 이루어져 있습니다.
- 경주 진행중 1등인 선수의 이름은 불리지 않습니다.

*/