package etc.level1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MemoryScoreCalculator {
    public static void main(String[] args) {
        String[] name = {"may", "kein", "kain", "radi"};
        int[] yearning = {5, 10, 1, 3};
        String[][] photo = {{"may", "kein", "kain", "radi"},
                {"may", "kein", "brin", "deny"},
                {"kon", "kain", "may", "coni"}};

        int[] answer = solution(name, yearning, photo);
        System.out.println(
                "answer: "+ Arrays.toString(answer));
    }

    public static int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];

        // 인물 이름과 그리움 점수를 매핑하는 HashMap 생성
        Map<String, Integer> yearningMap = new HashMap<>();
        for (int i = 0; i < name.length; i++) {
            yearningMap.put(name[i], yearning[i]);
        }

        // 각 사진의 추억 점수 계산
        for (int i = 0; i < photo.length; i++) {
            int photoScore = 0;
            for (String person : photo[i]) {
                if (yearningMap.containsKey(person)) {
                    photoScore += yearningMap.get(person);
                }
            }
            answer[i] = photoScore;
        }

        return answer;
    }
}

/*
사진들을 보며 추억에 젖어 있던 루는 사진별로 추억 점수를 매길려고 합니다.
사진 속에 나오는 인물의 그리움 점수를 모두 합산한 값이 해당 사진의 추억 점수가 됩니다.
 */

