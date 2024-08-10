import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        // 큐 생성 후 초기 셋팅
        Queue<Integer> que1 = new LinkedList<Integer>();
        Queue<Integer> que2 = new LinkedList<Integer>();
        long sum1 = 0, sum2 = 0;
        
        // 큐에 원소 추가 및 합 계산
        for (int i = 0; i < queue1.length; i++) {
            que1.add(queue1[i]);
            sum1 += queue1[i];
        }
        
        for (int i = 0; i < queue2.length; i++) {
            que2.add(queue2[i]);
            sum2 += queue2[i];
        }
        
        // 두 큐의 합이 같아질 때까지 원소 이동 // 가능한 최대 연산 횟수
        int maxAct = (queue1.length + queue2.length) * 2; 
        int answer = 0;
        
        while (sum1 != sum2 && answer < maxAct) {
            if (sum1 > sum2) {
                int element = que1.poll();
                que2.add(element);
                sum1 -= element;
                sum2 += element;
            } 
            else {
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
}

/*
하나의 큐를 골라 원소 poll / 추출한 원소를 다른 큐에 add
하여 두 큐의 원소의 합이 같도록 만듬
이때 최소 작업 횟수

불가능할 시 return -1
*/