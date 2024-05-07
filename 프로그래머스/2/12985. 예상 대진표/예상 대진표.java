/*
n명참가하는 게임대회(경기는 번호순) n은 2의 지수승으로 부전승x
a번과 b번이 항상 승리할 때 몇번째 라운드에서 만나는가

*/

class Solution{
    public int solution(int n, int a, int b){
        int round = 0;
        
        while(a != b) {
            a = (a + 1) / 2;
            b = (b + 1) / 2;
            round++;
        }
        return round;
    }
}