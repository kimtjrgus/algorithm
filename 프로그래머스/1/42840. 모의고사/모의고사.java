import java.util.ArrayList;
import java.util.List;
class Solution {
    public int[] solution(int[] answers) {
        // 수포자 3명, 5지선다
        // 삼인방의 패턴
        int[] trio1 = {1,2,3,4,5};
        int[] trio2 = {2,1,2,3,2,4,2,5};
        int[] trio3 = {3,3,1,1,2,2,4,4,5,5};
        
        int[] score = {0,0,0}; // trio의 점수
        // 1. 삼인방 점수 for(answers[i] == trio[i%trio.length]) 일 때 cnt +1
        for(int i=0; i<answers.length; i++){
            if(answers[i] == trio1[i % trio1.length]) score[0]++;
            if(answers[i] == trio2[i % trio2.length]) score[1]++;
            if(answers[i] == trio3[i % trio3.length]) score[2]++;
            
        }
        // 2. trio의 점수 비교
        List<Integer> resultList = new ArrayList<>();
        int max = Math.max(score[0], Math.max(score[1], score[2]));

        for (int i = 0; i < score.length; i++) {
            if (max == score[i]) {
                resultList.add(i + 1);
            }
        }

        // 3. List to Array
        int[] result = new int[resultList.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = resultList.get(i);
        }
        
        return result;
    }
}