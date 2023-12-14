import java.util.Arrays;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] students = new int[n+2]; // 앞뒷자리 학생인덱스를 고려하기 위함
        Arrays.fill(students, 1); // 체육복 갯수 초기화
        
        // 1. 도난학생 체육복 감소 lost
        for(int l : lost){
            students[l]--;
        }
        
        // 2. 여벌 체육복 카운트
        for(int r : reserve){
            students[r]++;
        }
        
        for (int i = 1; i <= n; i++) {
            if (students[i] == 0) {
                // 3. 체육복이 없을 경우 앞자리 학생에게 빌릴 경우
                if (students[i - 1] == 2) { 
                    students[i - 1]--;
                    students[i]++;
                } else if (students[i + 1] == 2) {
                    // 4. 뒷자리 학생에게 빌릴 경우
                    students[i + 1]--;
                    students[i]++;
                }
            }
        }
        
        // 5. 학생수 count
        int answer = 0;
        for (int i = 1; i <= n; i++){
            if(students[i] > 0) answer++;
        }
        
        return answer;
    }
}