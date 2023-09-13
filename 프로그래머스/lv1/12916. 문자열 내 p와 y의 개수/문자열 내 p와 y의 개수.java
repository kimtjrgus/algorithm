class Solution {
    boolean solution(String s) {
        int pcount = 0;
        int ycount = 0;
        
        // p, y 개수를 카운트
        
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c == 'p' || c == 'P'){
                pcount++;
            }
            if(c == 'y' || c == 'Y'){
                ycount++;
            }
        }
        
        // 갯수가 같으면 true, 다르면 false
        return pcount == ycount;
    }
}