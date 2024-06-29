import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // 모든 스코빌 지수를 최소 힙에 추가 (수정된 부분)
        for (int scov : scoville) {
            minHeap.add(scov);
        }

        int mixCount = 0;

        // 최소 힙의 최솟값이 K 이상이 될 때까지 반복
        while (minHeap.size() > 1 && minHeap.peek() < K) {
            int first = minHeap.poll(); // 가장 낮은 스코빌 지수
            int second = minHeap.poll(); // 두 번째로 낮은 스코빌 지수

            int newScoville = first + (second * 2); // 새로운 스코빌 지수
            minHeap.add(newScoville); 
            mixCount++; // 섞은 횟수 증가
        }

        // 스코빌 지수가 K 이상 여부
        if (minHeap.peek() < K) { 
            return -1; // 불가능할 경우
        }

        return mixCount; 
    }
}
/*
레오는 스코빌 K이상
섞은 음식의 스코빌 = min스코빌 + (min2스코빌 *2)
모든 음식의 스코빌이 k이상 안될시 return -1;

answer = 모든 음식이 K이상이 될때, 섞어야하는 최소횟수
*/