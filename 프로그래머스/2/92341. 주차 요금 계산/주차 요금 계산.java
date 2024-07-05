import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        // 기본 시간, 기본 요금, 단위 시간, 단위 요금
        int baseTime = fees[0];
        int baseFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];
        
        // 차량번호, 입차시간을 저장할 맵
        Map<String, Integer> inTimeMap = new HashMap<>();
        // 차량번호, 누적 주차 시간을 저장할 맵
        Map<String, Integer> parkingTimeMap = new HashMap<>();
        
        // 2. 주차 기록 처리
        for (String record : records) {
            String[] parts = record.split(" ");
            int time = convertToMinutes(parts[0]);
            String carNumber = parts[1];
            String action = parts[2];
            
            if (action.equals("IN")) {
                inTimeMap.put(carNumber, time);
            } else { // action.equals("OUT")
                int inTime = inTimeMap.remove(carNumber);
                int parkedTime = time - inTime;
                parkingTimeMap.put(
                    carNumber, parkingTimeMap.getOrDefault(carNumber, 0) + parkedTime);
            }
        }
        
        // 23:59까지 출차되지 않은 차량 처리
        for (String carNumber : inTimeMap.keySet()) {
            int inTime = inTimeMap.get(carNumber);
            int parkedTime = convertToMinutes("23:59") - inTime;
            parkingTimeMap.put(carNumber, parkingTimeMap.getOrDefault(carNumber, 0) + parkedTime);
        }
        
        // 차량번호 순으로 정렬
        List<String> carNumbers = new ArrayList<>(parkingTimeMap.keySet());
        Collections.sort(carNumbers);
        
        // 최종 요금 계산
        int[] answer = new int[carNumbers.size()];
        for (int i = 0; i < carNumbers.size(); i++) {
            String carNumber = carNumbers.get(i);
            int totalTime = parkingTimeMap.get(carNumber);
            int totalFee = calculateFee(totalTime, baseTime, baseFee, unitTime, unitFee);
            answer[i] = totalFee;
        }
        
        return answer;
    }
    
    // 시간을 "HH:MM" 형식에서 분으로 변환하는 함수
    private int convertToMinutes(String time) {
        String[] parts = time.split(":");
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);
        return hours * 60 + minutes;
    }
    
    // 주차 요금을 계산하는 함수
    private int calculateFee(int totalTime, int baseTime, int baseFee, int unitTime, int unitFee) {
        if (totalTime <= baseTime) {
            return baseFee;
        } else {
            return baseFee + (int)Math.ceil((double)(totalTime - baseTime) / unitTime) * unitFee;
        }
    }
}

