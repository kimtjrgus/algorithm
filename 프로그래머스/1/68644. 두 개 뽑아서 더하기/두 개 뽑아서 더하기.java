import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] numbers) {
        // 서로 다른 인덱스의 두수를 더해 만들 수 있는 모든 수
        // 1. 인덱스0 부터 모든 수와 더한 후 리스트에 추가.
        // 2. 중복제거, 반복 이중for문
        List<Integer> sumList = new ArrayList<Integer>(); 
        
        for(int i=0; i<numbers.length; i++){
            for(int j=i+1; j<numbers.length; j++){
                int sum = numbers[i] + numbers[j];
                sumList.add(sum);
            }
        }
        // sumList 중복제거
        List<Integer> answerList = sumList.stream()
                                .distinct().collect(Collectors.toList());
        // list -> array /정렬
        int[] answer = answerList.stream().mapToInt(i->i).toArray();
        Arrays.sort(answer);
        
        return answer;
    }
}