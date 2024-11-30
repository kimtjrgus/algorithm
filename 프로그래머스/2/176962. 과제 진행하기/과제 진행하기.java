import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        // 1. 시작시간을 분 단위로 변환하고 정렬
        Arrays.sort(plans, (a, b) -> timeToMinutes(a[1]) - timeToMinutes(b[1]));

        List<String> answer = new ArrayList<>();
        Stack<String[]> stack = new Stack<>(); // 변수명 추가
        int current_time = 0; // 현재 시간 (분 단위)

        // 2. 과제 진행
        for (String[] plan : plans) {
            String name = plan[0];
            int start_time = timeToMinutes(plan[1]);
            int playtime = Integer.parseInt(plan[2]);

            // 3. 새 과제가 들어올 경우
            while (!stack.isEmpty() && current_time < start_time) {
                String[] task = stack.pop();
                String task_name = task[0];
                int remaining_time = Integer.parseInt(task[1]);

                if (current_time + remaining_time <= start_time) {
                    // 과제를 끝낼 수 있음
                    current_time += remaining_time;
                    answer.add(task_name);
                } else {
                    // 과제를 끝내지 못하고 다시 멈춤
                    remaining_time -= (start_time - current_time);
                    stack.push(new String[] { task_name, String.valueOf(remaining_time) });
                    break;
                }
            }

            // 새로운 과제 시작
            stack.push(new String[] { name, String.valueOf(playtime) });
            current_time = start_time;
        }

        // 4. 스택에 남은 과제들 처리
        while (!stack.isEmpty()) {
            String[] task = stack.pop();
            answer.add(task[0]);
        }

        return answer.toArray(new String[0]);
    }

    // 시간을 분으로 변환하는 메서드
    private int timeToMinutes(String time){
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 60 
            + Integer.parseInt(parts[1]);
    }
}
