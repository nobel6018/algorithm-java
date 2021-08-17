/*
 * 베스트앨범
 * https://programmers.co.kr/learn/courses/30/lessons/42579
 * #hash #priority queue #comparable
 * */
package hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class BestAlbum {

    static class Genre implements Comparable<Genre> {
        private final String name;
        private final Integer playCount;

        public Genre(String name, Integer playCount) {
            this.name = name;
            this.playCount = playCount;
        }

        public String getName() {
            return name;
        }

        public Integer getPlayCount() {
            return playCount;
        }

        @Override
        public int compareTo(Genre o) {
            return o.getPlayCount() - this.playCount;
        }
    }

    static class Music implements Comparable<Music> {
        private final Integer id;
        private final Integer playCount;

        public Music(Integer id, Integer playCount) {
            this.id = id;
            this.playCount = playCount;
        }

        public Integer getId() {
            return id;
        }

        public Integer getPlayCount() {
            return playCount;
        }

        @Override
        public int compareTo(Music o) {
            if (o.getPlayCount() - this.playCount != 0) {
                return o.getPlayCount() - this.playCount;
            }
            return this.id - o.getId();
        }
    }

    public static int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> genrePopularity = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            Integer count = genrePopularity.getOrDefault(genres[i], 0);
            genrePopularity.put(genres[i], count + plays[i]);
        }

        PriorityQueue<Genre> genrePriorityQueue = new PriorityQueue<>();
        for (String s : genrePopularity.keySet()) {
            genrePriorityQueue.add(new Genre(s, genrePopularity.get(s)));
        }

        HashMap<String, PriorityQueue<Music>> musicOfGenrePopularity = new HashMap<>();
        for (int i = 0; i < plays.length; i++) {
            PriorityQueue<Music> queue = musicOfGenrePopularity.getOrDefault(genres[i], new PriorityQueue<>());
            queue.add(new Music(i, plays[i]));

            musicOfGenrePopularity.put(genres[i], queue);
        }

        ArrayList<Integer> result = new ArrayList<>();
        while (!genrePriorityQueue.isEmpty()) {
            Genre genre = genrePriorityQueue.poll();
            PriorityQueue<Music> musicPriorityQueue = musicOfGenrePopularity.get(genre.getName());
            Music first = musicPriorityQueue.poll();
            if (first != null) {
                result.add(first.getId());
            }
            Music second = musicPriorityQueue.poll();
            if (second != null) {
                result.add(second.getId());
            }
        }

        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        int[] solution = solution(genres, plays);
        System.out.println(Arrays.equals(solution, new int[]{4, 1, 3, 0}));

        String[] genres2 = {"classic", "pop", "classic", "classic"};
        int[] plays2 = {500, 600, 150, 800};
        int[] solution2 = solution(genres2, plays2);
        System.out.println(Arrays.equals(solution2, new int[]{3, 0, 1}));


        String[] genres3 = {"classic", "pop", "classic", "classic"};
        int[] plays3 = {500, 10000, 150, 800};
        int[] solution3 = solution(genres3, plays3);
        System.out.println(Arrays.equals(solution3, new int[]{1, 3, 0}));

        // for TestCase2
        String[] genres4 = {"classic", "pop", "classic", "pop", "classic", "classic"};
        int[] plays4 = {400, 600, 150, 600, 500, 500};
        int[] solution4 = solution(genres4, plays4);
        System.out.println(Arrays.equals(solution4, new int[]{4, 5, 1, 3}));
    }

}
