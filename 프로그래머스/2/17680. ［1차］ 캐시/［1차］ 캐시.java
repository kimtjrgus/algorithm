import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        // LRU 캐시 알고리즘 사용
        // 캐시크기에 따른 실행시간 측정 프로그램을 작성하시오.
        int runTime = 0;
 
        // 1. 캐시크기가 0일 경우
        if (cacheSize == 0) {
            return cities.length * 5;
        }
        
        List<String> caches = new LinkedList<>();
        for (int i = 0; i < cities.length; i++) {
            // 대소문자 구분X, 소문자로 통일
            String city = cities[i].toLowerCase(); 
            // 2. cache miss
            if (!caches.contains(city)) {
                runTime += 5;
                if (caches.size() >= cacheSize) {
                    // 2-1. 오래된 캐시 제거
                    caches.remove(0);
                }
                caches.add(city);
                continue;
            }
 
            // 3. cache hit
            if (caches.contains(city)) {
                caches.remove(city);
                caches.add(city);
                runTime += 1;
            }
        }
        return runTime;
        
    }
}