import java.util.*;

class Solution {
    public double[] solution(int k, int[][] ranges) {
        // 1. 우박수열 선언, 길이를 모르니 list
        List<Integer> collatz = new ArrayList<>();
        collatz.add(k);
        while(k != 1){
            k = (k%2 == 0) ? k/2 : k*3+1;
            collatz.add(k);
        }
        
        // 2. 구간별 면적 미리 계산
        int n = collatz.size() -1; // 우박수열의 길이
        double[] areas = new double[n]; // 구간 사다리꼴 넓이 배열
        for(int i=0; i<n; i++){
            areas[i] = (collatz.get(i) + collatz.get(i+1)) /2.0;
        }
        
        // 누적합 계산 (prefix sum)
        double[] prefixSum = new double[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + areas[i];
        }
        
        // 3. 주어진 ranges에 대해 결과 계산
        double[] answer = new double[ranges.length];
        for (int i = 0; i < ranges.length; i++) {
            int a = ranges[i][0];
            int b = n + ranges[i][1]; // 음수 b는 우박수열의 끝에서부터 계산
            
            // 유효성 검사
            if (a > b) {
                answer[i] = -1.0;
            } else {
                answer[i] = prefixSum[b] - prefixSum[a];
            }
        }
        
        // 4. return answer
        return answer;
    }
}

/*
모든 자연수k를 1로 만듬
1. if( 입력된 수가 k%2 ==0 ) a = k/2
2. else a = k*3 +1
-> if(a > 1) 1번으로 

정적분한 면적을 구하고, 범위를 벗어날 경우 -1
*/