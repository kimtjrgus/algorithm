class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        // card1,2로 goal 만들기 yes or no
        // card1,2 내 순서변경x 
        // 1. goal의 원소를 검사하고 card1,2 를 검사 둘중하나가 해당되면 
        // card.idx +1 / else false
        int idx1 =0; // cards1의 idx
        int idx2 =0; // cards2의 idx
        
        for(String curStr : goal){
            if (idx1 < cards1.length 
                    &&  curStr.equals(cards1[idx1])) {
                idx1++; // cards1[idx1]에 포함하는 경우 idx1 증가
            } 
            else if (idx2 < cards2.length 
                     && curStr.equals(cards2[idx2])) {
                idx2++; // cards2[idx2]에 포함하는 경우 idx2 증가
            }
            else return "No";
        }
        
        return "Yes";
    }
}