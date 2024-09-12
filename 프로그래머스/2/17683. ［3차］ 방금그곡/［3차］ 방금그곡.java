class Solution {
    public static String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int maxPlayTime = -1;
        
        // 입력된 기억한 멜로디도 변환해줍니다.
        m = convertMelody(m);
        
        for (String info : musicinfos) {
            String[] parts = info.split(",");
            String start = parts[0];
            String end = parts[1];
            String title = parts[2];
            String melody = convertMelody(parts[3]);
            
            int playTime = calculateTime(start, end);
            String playedMelody = getPlayedMelody(melody, playTime);
            
            // 멜로디가 재생된 악보에 포함되는지 확인
            if (playedMelody.contains(m) && playTime > maxPlayTime) {
                maxPlayTime = playTime;
                answer = title;
            }
        }
        
        return answer;
    }
    
    // #을 포함한 음을 변환하는 함수,  구분하기 쉽도록
    private static String convertMelody(String melody) {
        return melody.replaceAll("C#", "H")
                     .replaceAll("D#", "I")
                     .replaceAll("F#", "J")
                     .replaceAll("G#", "K")
                     .replaceAll("A#", "L")
                     .replaceAll("B#", "M");
    }
    
    // 재생된 시간(분)을 계산하는 함수
    private static int calculateTime(String start, String end) {
        String[] startParts = start.split(":");
        String[] endParts = end.split(":");
        
        int startHour = Integer.parseInt(startParts[0]);
        int startMinute = Integer.parseInt(startParts[1]);
        int endHour = Integer.parseInt(endParts[0]);
        int endMinute = Integer.parseInt(endParts[1]);
        
        return (endHour * 60 + endMinute) - (startHour * 60 + startMinute);
    }
    
    // 실제 재생된 악보를 생성하는 함수
    private static String getPlayedMelody(String melody, int playTime) {
        StringBuilder playedMelody = new StringBuilder();
        int melodyLength = melody.length();
        
        for (int i = 0; i < playTime; i++) {
            playedMelody.append(melody.charAt(i % melodyLength));
        }
        
        return playedMelody.toString();
    }
}

/*

*/