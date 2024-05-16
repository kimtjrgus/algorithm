import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people); // 사람들의 몸무게를 오름차순으로 정렬
        int minBoats = 0; // 필요한 구명보트의 최솟값을 저장할 변수

        int left = 0; // 가장 가벼운 사람의 인덱스
        int right = people.length - 1; // 가장 무거운 사람의 인덱스

        while (left <= right) {
            if (people[left] + people[right] <= limit) {
                // 가장 가벼운 사람과 가장 무거운 사람이 같이 탈 수 있는 경우
                left++; // 다음 가벼운 사람으로 이동
            }
            right--; // 가장 무거운 사람은 보트에 탔으므로 다음으로 이동
            minBoats++; // 구명보트 개수 증가
        }

        return minBoats;
    }
}