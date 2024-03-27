import java.util.Arrays;
/*
@param 길이가 같은 배열 A,B (자연수, 1 이상)
@return 배열길이만큼 반복하여, 누적하여 더함, 이때 최소값
*/ 
class Solution{
    public int solution(int []A, int []B){
        Arrays.sort(A);
        Arrays.sort(B);
        
        int answer = 0; // 정답을 저장할 변수
        
        // 작은값과 큰값의 곱의 합이 제일 최소값
        for(int i=0; i<A.length; i++){
            answer += A[i] * B[A.length-1 -i];
            
        }
        
        return answer;
    }
}