import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        // 파일 목록을 정렬
        Arrays.sort(files, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String[] file1 = splitFileName(o1);
                String[] file2 = splitFileName(o2);

                int headCompare = file1[0].compareToIgnoreCase(file2[0]);
                if (headCompare != 0) {
                    return headCompare;
                }

                int numberCompare = Integer.compare(Integer.parseInt(file1[1]), Integer.parseInt(file2[1]));
                if (numberCompare != 0) {
                    return numberCompare;
                }

                return 0;
            }
        });

        return files;
    }
    
    // 파일명을 HEAD, NUMBER, TAIL로 분리합니다.
    private static String[] splitFileName(String file) {
        String head = "";
        String number = "";
        String tail = "";

        int i = 0;
        // Extract head
        while (i < file.length() && !Character.isDigit(file.charAt(i))) {
            head += file.charAt(i);
            i++;
        }
        // Extract number
        while (i < file.length() && Character.isDigit(file.charAt(i))) {
            number += file.charAt(i);
            i++;
        }
        // Extract tail
        if (i < file.length()) {
            tail = file.substring(i);
        }

        return new String[]{head, number, tail};
    }
}