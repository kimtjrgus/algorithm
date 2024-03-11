import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int[][] answer = new int[][]{};
        
        // 필터링된 데이터
        int[][] filteredData = filteredData(data, ext, val_ext);
        int[][] sortedData = sortedData(filteredData, sort_by);
        answer = sortedData;
        
        return answer;
    }
    // 1. data 컬럼별 filter 메서드
    private int[][] filteredData(int[][] data, String ext, int val_ext){
        return Arrays.stream(data)
                .filter(d -> {
                    if(ext.equals("code")){
                        return d[0] < val_ext;
                    } else if(ext.equals("date")){
                        return d[1] < val_ext;
                    } else if(ext.equals("maximum")){
                        return d[2] < val_ext;
                    } else if(ext.equals("remain")){
                        return d[3] < val_ext;
                    }
                    return false;
                })
                .toArray(int[][]::new);
    }
    // 2. data sort_by기준 오름차순 정렬 메서드
    private int[][] sortedData(int[][] data, String sort_by){
        // Comparator를 사용하여 sort_by 기준에 따라 정렬
        Arrays.sort(data, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                switch (sort_by) {
                    case "code":
                        return Integer.compare(o1[0], o2[0]);
                    case "date":
                        return Integer.compare(o1[1], o2[1]);
                    case "maximum":
                        return Integer.compare(o1[2], o2[2]);
                    case "remain":
                        return Integer.compare(o1[3], o2[3]);
                    default:
                        throw new IllegalArgumentException("Invalid sort_by value");
                }
            }
        });
        return data;
    }
}