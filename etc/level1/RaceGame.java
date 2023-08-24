package etc.level1;

import java.util.Arrays;
import java.util.HashMap;

public class RaceGame {
    public static void main(String[] args) {
        String[] players = {"mumu", "soe", "poe", "kai", "mine"};
        String[] callings = {"kai", "kai", "mine", "mine"};

        String[] answer = solution(players, callings);
        System.out.println(
                "answer: "+ Arrays.toString(answer)); // ["mumu", "kai", "mine", "soe", "poe"]
    }

    public static String[] solution(String[] players, String[] callings) {
        String[] answer = Arrays.copyOf(players, players.length);

        //1. 선수이름과 초기 등수 매핑
        HashMap<String, Integer> playerMap = new HashMap<>();
        for (int i=0; i< players.length; i++){
            playerMap.put(players[i], i+1);
        }

        //2. 자기 앞 선수를 추월할 때 추월한 선수의 이름을 부름
        //3. 부른 선수와 앞선수의 등수를 바꿔줌
        for (String calling : callings) {
            int currentPlayerRank = playerMap.get(calling);

            // 현재 선수와 그 앞선 선수의 등수를 바꿔줌
            if (currentPlayerRank > 1) {
                String currentPlayer = answer[currentPlayerRank - 1];
                String prevPlayer = answer[currentPlayerRank - 2];
                answer[currentPlayerRank - 1] = prevPlayer;
                answer[currentPlayerRank - 2] = currentPlayer;

                // 선수 등수를 업데이트
                playerMap.put(currentPlayer, currentPlayerRank - 1);
                playerMap.put(prevPlayer, currentPlayerRank);
            }
        }
        return answer;
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