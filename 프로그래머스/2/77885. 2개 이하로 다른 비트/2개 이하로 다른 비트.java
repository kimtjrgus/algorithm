class Solution {
    public long[] solution(long[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            long num = numbers[i];

            // 비트의 가장 오른쪽에 있는 0이 있는지 체크
            if ((num & 1L) == 0 || (num & 2L) == 0) {
                // 비트가 1이 아닌 가장 오른쪽 비트를 1로 설정
                numbers[i] = num + 1;
                continue;
            }

            // 가장 오른쪽 비트가 1인 부분의 위치를 찾기
            int index = 2;
            while (((1L << index) & num) != 0) {
                index++;
            }

            // 해당 비트를 1로 설정하고 그 오른쪽의 비트들을 조정
            numbers[i] = (num | (1L << index)) - (1L << (index - 1));
        }

        return numbers;
    }
}