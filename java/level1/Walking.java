package level1;

import java.util.Arrays;

public class Walking {
    public static int[] solution(String[] park, String[] routes) {
        // S는 시작점, O는 통로, X는 장애물
        // E동 W서 S남 N북
        int[] answer = {};



        return answer;
    }

    public static void main(String[] args) {
        String[] park = {"SOO","OOO","OOO"};
        String[] routes = {"E2", "S2" ,"W1"};
        int[] answer = solution(park, routes);

        System.out.println(
                "answer: "+ Arrays.toString(answer));
    }
}
// S는 시작점, O는 통로, X는 장애물
// E동 W서 S남 N북

// 로봇 강아지는 명령을 수행하기 전에 다음 두 가지를 먼저 확인합니다.
// 1.주어진 방향으로 이동할 때 공원을 벗어나는지 확인합니다.
// OR 2.주어진 방향으로 이동 중 장애물을 만나는지 확인합니다.
// 둘중 하나라도 해당된다면 해당 명령을 무시, 다음 명령 실행

