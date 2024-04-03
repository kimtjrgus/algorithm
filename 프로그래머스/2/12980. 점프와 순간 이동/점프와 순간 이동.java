import java.util.*;
/*
한 번에 K 칸을 앞으로 점프하거나, 
(현재까지 온 거리) x 2 에 해당하는 위치로 순간이동
순간이동시 건전지소모x / k칸 점프시 k만큼 소모

@param n : 가야할 거리 n (1~ 1,000,000,000 자연수)
@return : 건전지 최소 소모값
*/
public class Solution {
    public int solution(int n) {
        int answer = 0;
        
        while(n != 0){
            if(n % 2 == 0){
                n /= 2;
            } else {
                n--;
                answer++;
            }
        }
        
        
        return answer;
    }
}