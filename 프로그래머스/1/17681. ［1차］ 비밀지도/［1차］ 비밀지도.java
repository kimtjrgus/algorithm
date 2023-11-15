class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for (int i = 0; i < n; i++) {
            // arr1, arr2 각 숫자를 2진법으로 변환하여 OR 연산을 수행
            int combined = arr1[i] | arr2[i];

            // 2진법으로 변환한 숫자를 비밀지도 형식으로 변환
            String binaryString = Integer.toBinaryString(combined);

            // 길이가 n이 될 때까지 앞에 0을 채워줌
            binaryString = String.format("%" + n + "s", binaryString);
            
            // 1을 '#', 0을 ' '로 변환
            binaryString = binaryString.replaceAll("1", "#");
            binaryString = binaryString.replaceAll("0", " ");

            // 결과 배열에 저장
            answer[i] = binaryString;
        }

        return answer;
    }
}