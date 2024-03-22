class Solution {
    public String solution(String s) {
        // s.split 후 최대값 최소값 구하기
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        String[] arr = s.split(" ");
        
        for(String a : arr){
            int num = Integer.parseInt(a);
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        
        return min + " " + max;
    }
}