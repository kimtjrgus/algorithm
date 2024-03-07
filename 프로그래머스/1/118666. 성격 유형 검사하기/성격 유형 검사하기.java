class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        int RT = 0; int CF = 0; int JM = 0; int AN = 0;
        int[] points = {3,2,1,0,-1,-2,-3};  // choices의 점수
        
        for(int i =0; i<survey.length; i++){
            String curStr = survey[i];
            if(curStr.equals("RT") || curStr.equals("TR")){
                if(curStr.equals("RT")) 
                    RT += points[choices[i] - 1]; 
                else 
                    RT -= points[choices[i] - 1];
            }
            else if(curStr.equals("CF") || curStr.equals("FC")){
                if(curStr.equals("CF"))
                    CF += points[choices[i] - 1];
                else 
                    CF -= points[choices[i] - 1];
            }
            else if(curStr.equals("JM") || curStr.equals("MJ")){
                if(curStr.equals("JM"))
                    JM += points[choices[i] - 1];
                else 
                    JM -= points[choices[i] - 1];
            }
            else if(curStr.equals("AN") || curStr.equals("NA")){
                if(curStr.equals("AN"))
                    AN += points[choices[i] - 1];
                else 
                    AN -= points[choices[i] - 1];
            }
        }
        
        StringBuilder sb = new StringBuilder();
        if(RT >= 0)
            sb.append("R");
        else
            sb.append("T");
        if(CF >= 0)
            sb.append("C");
        else
            sb.append("F");
        if(JM >= 0)
            sb.append("J");
        else
            sb.append("M");
        if(AN >= 0)
            sb.append("A");
        else
            sb.append("N");
        answer = sb.toString();
        
        return answer;
    }
}

// 1. n개의 질문이 있음
// 2. 각 질문은 1개의 지표로 판단하는데 : 총 4개의 지표 RT, CF, JM, AN
// 3. 하나의 지표에서 점수가 같으면 사전순. RT 점수 0 이면 R 
