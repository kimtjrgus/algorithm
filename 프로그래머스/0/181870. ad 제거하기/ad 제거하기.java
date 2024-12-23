import java.util.*;

class Solution {
    public String[] solution(String[] strArr) {
        List<String> resultList = new ArrayList<>();
        
        // 1. if(부분문자열중 ad를 포함하면) list.remove
        for(String str : strArr){
            if(!str.contains("ad")) resultList.add(str);
        }
        
        return resultList.toArray(new String[0]);
    }
}