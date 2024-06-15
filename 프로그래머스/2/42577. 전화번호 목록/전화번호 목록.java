import java.util.HashMap;
import java.util.Map;

class Solution {
    // 시간복잡도 O(n * m)
    public boolean solution(String[] phone_book) {
        // 1. 전화번호를 저장할 해시맵 선언
        Map<String, Boolean> map = new HashMap<>();
        
        // 2. 모든 전화번호를 해시맵에 저장
        for (String phone : phone_book) {
            map.put(phone, true);
        }
        
        // 3. 모든 전화번호의 각 접두사를 해시맵에서 확인
        for (String phone : phone_book) {
            for (int i = 1; i < phone.length(); i++) {
                if (map.containsKey(phone.substring(0, i))) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    
// 시간초과 효율성 실패, 시간복잡도 O(n^2)
//     public boolean solution(String[] phone_book) {
//         boolean answer = true;
        
//         // 1. 배열중 문자열의 길이가 가장 짧은 순으로 정렬
//         Arrays.sort(phone_book, 
//                     (a, b) -> Integer.compare(a.length(), b.length()));
        
//         // 2. 접두사 변수 선언 phone_book[0] 초기화
//         String prefix = phone_book[0];
        
//         // 3. phone_book을 순회하며 접두사 체크 반복
//         for (int i = 0; i < phone_book.length; i++) {
//             for (int j = i + 1; j < phone_book.length; j++) {
//                 // 4. 현재 문자열이 다음 문자열의 접두사인지 체크
//                 if (phone_book[j].startsWith(phone_book[i])) {
//                     // 5. 접두사 있을 시 answer = false; break;
//                     answer = false;
//                     break;
//                 }
//             }
            
//             if (!answer) break;
//         }
        
//         return answer;
//     }
}