import java.util.*;

class Solution {
    static Map<String,List<Integer>> map;
    
    public int[] solution(String[] info, String[] query) {
        map = new HashMap<>();
        for(String i : info){
            String[] arr = i.split(" ");
            comb(arr,0,"");
        }

        for(String k : map.keySet())Collections.sort(map.get(k));


        int[] answer = new int[query.length];
        for(int i = 0; i < query.length; i++){
            String[] q = query[i].replace(" and ","").split(" ");
            int index = 0;
            if(map.containsKey(q[0]))index =binary(map.get(q[0]),Integer.parseInt(q[1]));
            answer[i] = index;
        }
        return answer;
    }

    public int binary(List<Integer> list, int value){
        int start = 0;
        int end = list.size()-1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (list.get(mid) < value)
                start = mid + 1;
            else
                end = mid - 1;
        }
        return list.size() - start;
    }

    public void comb(String[] info, int index, String result){
        if(index == 4){
            if(!map.containsKey(result)){
                List<Integer> list = new ArrayList<>();
                map.put(result,list);
            }
            map.get(result).add(Integer.parseInt(info[4]));
            return;
        }

        comb(info,index+1, result+"-");
        comb(info,index+1,result+info[index]);
    }
}


/* 문제 풀이
지원자가 입력한 4가지 정보와 테스트 점수를 하나의 문자열로 구성한 1차원 배열 info
개발팀의 문의조건 1차원 배열 query
-> 각 문의 조건에 해당하는 사람 수를 순서대로 배열에 담아 return.

지원자 정보를 배열화하는 메서드
문의 조건을 배열화하는 메서드를 각각 구해

1차원 배열을 split하여 2차원배열로 저장하는 방법
정보와 문의 조건을 매치하여 count할 것
조건 정보 중 "-" 는 해당 조건은 고려않고 모두 포함시킨다는 의미.
*/