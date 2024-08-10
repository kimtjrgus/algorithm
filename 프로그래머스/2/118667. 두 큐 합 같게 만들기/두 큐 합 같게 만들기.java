import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        // 큐 생성 후 초기 셋팅
        Queue<Integer> que1 = new LinkedList<>();
        Queue<Integer> que2 = new LinkedList<>();
        
        // 큐에 원소 추가 및 합 계산
        long sum1 = initializeQueueAndGetSum(queue1, que1);
        long sum2 = initializeQueueAndGetSum(queue2, que2);
        
        
        // 두 큐의 합이 같아질 때까지 원소 이동 // 가능한 최대 연산 횟수
        int maxAct = (queue1.length + queue2.length) * 2; 
        int answer = 0;
        
        while (sum1 != sum2 && answer < maxAct) {
            if (sum1 > sum2) {
                int element = que1.poll();
                que2.add(element);
                sum1 -= element;
                sum2 += element;
            } else {
                int element = que2.poll();
                que1.add(element);
                sum2 -= element;
                sum1 += element;
            }
            answer++;
        }
        
        // 연산 종료 후 두 큐의 합이 같으면 연산 횟수를 반환, 아니면 -1 반환
        return sum1 == sum2 ? answer : -1;
    }
    
    // 큐 초기화 및 합 계산 메서드
    private long initializeQueueAndGetSum(int[] array, Queue<Integer> queue) {
        long sum = 0;
        for (int num : array) {
            queue.add(num);
            sum += num;
        }
        return sum;
    }
}

/*
하나의 큐를 골라 원소 poll / 추출한 원소를 다른 큐에 add
하여 두 큐의 원소의 합이 같도록 만듬
이때 최소 작업 횟수

불가능할 시 return -1

--> 최적화
# 중복코드 제거 : 두 큐의 원소 합을 계산하는 로직이 반복 -> 추상화

*/