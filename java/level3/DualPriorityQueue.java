package level3;

import java.util.Collections;
import java.util.PriorityQueue;

public class DualPriorityQueue {
    public static void main(String[] args) {
        // 입출력 예시
        // 1. ["I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"]
        // 2. ["I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"]


        // 1. [0,0]
        // 2. [333, -45]
    }

    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minQ = new PriorityQueue<>();
        PriorityQueue<Integer> maxQ = new PriorityQueue<Integer>(Collections.reverseOrder());

        for (int i = 0; i < operations.length; i++) {
            String[] arr = operations[i].split(" ");
            if (arr[0].equals("I")) {
                int num = Integer.parseInt(arr[1]);
                minQ.add(num);
                maxQ.add(num);
            } else if (arr[0].equals("D")) {
                if (arr[1].equals("1")) {
                    if (!minQ.isEmpty()) {
                        int num = maxQ.poll();
                        minQ.remove(num);
                    }
                } else if (arr[1].equals("-1")) {
                    if (!minQ.isEmpty()) {
                        int num = minQ.poll();
                        maxQ.remove(num);
                    }
                }
            }
        }

        if (minQ.isEmpty() && maxQ.isEmpty()) {
            return new int[]{0, 0};
        } else {
            int max = maxQ.isEmpty() ? 0 : maxQ.poll();
            int min = minQ.isEmpty() ? 0 : minQ.poll();
            return new int[]{max, min};
        }
    }
}

/*
*
입출력 예 #1

16과 -5643을 삽입합니다.
최솟값을 삭제합니다. -5643이 삭제되고 16이 남아있습니다.
최댓값을 삭제합니다. 16이 삭제되고 이중 우선순위 큐는 비어있습니다.
우선순위 큐가 비어있으므로 최댓값 삭제 연산이 무시됩니다.
123을 삽입합니다.
최솟값을 삭제합니다. 123이 삭제되고 이중 우선순위 큐는 비어있습니다.
따라서 [0, 0]을 반환합니다.

입출력 예 #2

-45와 653을 삽입후 최댓값(653)을 삭제합니다. -45가 남아있습니다.
-642, 45, 97을 삽입 후 최댓값(97), 최솟값(-642)을 삭제합니다. -45와 45가 남아있습니다.
333을 삽입합니다.
이중 우선순위 큐에 -45, 45, 333이 남아있으므로, [333, -45]를 반환합니다.
* */