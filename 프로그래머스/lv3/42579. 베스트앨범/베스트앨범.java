import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genreTotalPlays = new HashMap<>();
        Map<String, PriorityQueue<Song>> genreTopSongs = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int playCount = plays[i];
            
            // 각 장르의 총 재생 횟수를 누적 계산
            genreTotalPlays.put(genre, genreTotalPlays.getOrDefault(genre, 0) + playCount);
            
            // 각 장르의 최상위 노래 2개를 유지하는 PriorityQueue를 생성
            if (!genreTopSongs.containsKey(genre)) {
                genreTopSongs.put(genre, new PriorityQueue<>());
            }
            genreTopSongs.get(genre).offer(new Song(i, playCount));
        }
        
        // 재생 횟수가 많은 순으로 장르 정렬
        List<String> sortedGenres = new ArrayList<>(genreTotalPlays.keySet());
        sortedGenres.sort((a, b) -> genreTotalPlays.get(b) - genreTotalPlays.get(a));
        
        // 결과 리스트에 최상위 노래 2개씩 추가
        List<Integer> result = new ArrayList<>();
        for (String genre : sortedGenres) {
            PriorityQueue<Song> topSongs = genreTopSongs.get(genre);
            int count = 0;
            while (!topSongs.isEmpty() && count < 2) {
                result.add(topSongs.poll().index);
                count++;
            }
        }
        
        // 결과를 배열로 변환
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        
        return answer;
    }
}

class Song implements Comparable<Song> {
    int index;
    int plays;

    public Song(int index, int plays) {
        this.index = index;
        this.plays = plays;
    }

    @Override
    public int compareTo(Song other) {
        if (this.plays != other.plays) {
            return other.plays - this.plays;
        } else {
            return this.index - other.index;
        }
    }
}