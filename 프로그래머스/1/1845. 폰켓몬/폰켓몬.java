import java.util.HashSet;

class Solution {
    public int solution(int[] nums) {
        // nums.length 가지중 (n/2 가지 && 종류가 달라야함) 이 때 최대 가짓수
        int n = nums.length/2;
        
        // 중복 제거
        HashSet<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        
        // 중복을 제거한 셋의 크기가 n보다 크면 n를,
        // 작으면 numSet의 size를 리턴
        if (numSet.size() > n) return n;
        else return numSet.size();
    }
}