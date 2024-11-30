import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        // 1. 시작시간을 분 단위로 변환하고 정렬
        Arrays.sort(plans, (a, b) -> 
                    timeToMinutes(a[1]) - timeToMinutes(b[1]));

        List<String> answer = new ArrayList<>();
        Stack<String[]> stack = new Stack<>();
        int curTime = 0; // 현재 시간 (분 단위)

        // 2. 과제 진행
        for (String[] plan : plans) {
            String name = plan[0];
            int startTime = timeToMinutes(plan[1]);
            int playTime = Integer.parseInt(plan[2]);

            // 3. 새 과제가 들어올 경우
            while (!stack.isEmpty() && curTime < startTime) {
                String[] task = stack.pop();
                String taskName = task[0];
                int remainTime = Integer.parseInt(task[1]);

                if (curTime + remainTime <= startTime){
                    // 과제를 끝낼 수 있음
                    curTime += remainTime;
                    answer.add(taskName);
                } 
                else{
                    // 과제를 끝내지 못하고 다시 멈춤
                    remainTime -= (startTime - curTime);
                    stack.push(new String[]{taskName, String.valueOf(remainTime)});
                    break;
                }
            }

            // 새로운 과제 시작
            stack.push(new String[]{name, String.valueOf(playTime)});
            curTime = startTime;
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
