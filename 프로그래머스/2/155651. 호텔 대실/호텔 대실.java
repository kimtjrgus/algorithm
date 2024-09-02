import java.util.*;


class Solution {  
    public int solution(String[][] book_time){
        int answer = 0; // 필요한 최소 객실 수
        
        // 이벤트 리스트 생성
        List<int[]> events = new ArrayList<>();
        for (String[] time : book_time) {
            int checkIn = convertToMinutes(time[0]);
            int checkOut = convertToMinutes(time[1]) + 10; // 청소 시간 포함
            events.add(new int[]{checkIn, 1}); // 체크인
            events.add(new int[]{checkOut, -1}); // 체크아웃 
        }
        
        // 이벤트 정렬
        Collections.sort(events, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1]; // 같은 시간일 경우 체크아웃을 먼저 처리
            }
            return a[0] - b[0];
        });
        
        // 최소 객실 수 계산
        int currentRooms = 0;
        for (int[] event : events) {
            currentRooms += event[1];
            answer = Math.max(answer, currentRooms);
        }
        
        return answer;
    }

    // 시간 변환 함수
    int convertToMinutes(String time) {
        String[] parts = time.split(":");
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);
        return hours * 60 + minutes;
    }
}

// book_time[i]는
// ["HH:MM", "HH:MM"] -> [대실 시작 시각, 대실 종료 시각]