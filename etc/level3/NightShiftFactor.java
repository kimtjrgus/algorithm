package etc.level3;

import java.util.Collections;
import java.util.PriorityQueue;

public class NightShiftFactor {
    public static void main(String[] args) {

        System.out.println(solution(4,new int[]{4,3,3}));
        System.out.println(solution(1,new int[]{2,1,2}));
        System.out.println(solution(3,new int[]{1,1}));
        // 출력예시  12, 6, 0
    }

    private static long solution(int n, int[] works) {
        PriorityQueue<Integer> time = new PriorityQueue<>(Collections.reverseOrder());

        // 큐 값 삽입
        for (int work : works) {
            time.offer(work);
        }

        for (int i = 0; i < n; i++) {
            int max = time.poll();
            if (max <= 0) break;
            time.offer(max - 1);
        }

        return sumPow(time);
    }

    private static long sumPow(PriorityQueue<Integer> works) {
        long sum = 0;
        while (!works.isEmpty())
            sum += Math.pow(works.poll(), 2);

        return sum;
    }
}

/*
* 문제 설명
* 회사원 Demi는 가끔은 야근을 하는데요, 야근을 하면 야근 피로도가 쌓입니다.
* 야근 피로도는 야근을 시작한 시점에서 남은 일의 작업량을 제곱하여 더한 값입니다.
* Demi는 N시간 동안 야근 피로도를 최소화하도록 일할 겁니다.
* Demi가 1시간 동안 작업량 1만큼을 처리할 수 있다고 할 때,
* 퇴근까지 남은 N 시간과 각 일에 대한 작업량 works에 대해
* 야근 피로도를 최소화한 값을 리턴하는 함수 solution을 완성해주세요.
*
입출력 예 설명
입출력 예 #1
n=4 일 때, 남은 일의 작업량이 [4, 3, 3] 이라면 야근 지수를 최소화하기 위해 4시간동안 일을 한 결과는 [2, 2, 2]입니다. 이 때 야근 지수는 22 + 22 + 22 = 12 입니다.

입출력 예 #2
n=1일 때, 남은 일의 작업량이 [2,1,2]라면 야근 지수를 최소화하기 위해 1시간동안 일을 한 결과는 [1,1,2]입니다. 야근지수는 12 + 12 + 22 = 6입니다.

입출력 예 #3

남은 작업량이 없으므로 피로도는 0입니다.
* */