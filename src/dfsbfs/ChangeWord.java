/*
 * 단어 변환
 * https://programmers.co.kr/learn/courses/30/lessons/43163
 * # BFS
 * */
package dfsbfs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ChangeWord {

    private static class Element {
        private final String word;
        private final int changeCount;
        private final LinkedList<String> availableWords;

        public Element(String word, int changeCount, LinkedList<String> words) {
            this.word = word;
            this.changeCount = changeCount;
            this.availableWords = words;
        }

        public String getWord() {
            return word;
        }

        public int getChangeCount() {
            return changeCount;
        }

        public LinkedList<String> getAvailableWords() {
            return availableWords;
        }
    }

    public static int solution(String begin, String target, String[] words) {
        Queue<Element> queue = new LinkedList<>();
        queue.add(new Element(begin, 0, new LinkedList<>(List.of(words))));

        while (!queue.isEmpty()) {
            Element element = queue.poll();

            for (String candidate : element.getAvailableWords()) {
                if (isDifferentOneChar(element.getWord(), candidate)) {
                    if (candidate.equals(target)) {
                        return element.getChangeCount() + 1;
                    }

                    LinkedList<String> linkedList = new LinkedList<>(element.getAvailableWords());
                    linkedList.remove(candidate);

                    queue.add(new Element(candidate, element.getChangeCount() + 1, linkedList));
                }
            }
        }

        return 0;
    }

    public static boolean isDifferentOneChar(String one, String theOther) {
        int differentCount = 0;

        for (int i = 0; i < one.length(); i++) {
            if (differentCount > 1) {
                return false;
            }
            if (one.charAt(i) != theOther.charAt(i)) {
                differentCount++;
            }
        }

        return differentCount == 1;
    }

    public static void main(String[] args) {
        int solution = solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"});
        System.out.println(solution);
        System.out.println(solution == 4);

        int solution1 = solution("hit", "hot", new String[]{"hot", "dot", "dog", "lot", "log"});
        System.out.println(solution1);
        System.out.println(solution1 == 1);

        int solution2 = solution("1234567000", "1234567899", new String[]{"1234567800", "1234567890", "1234567899"});
        System.out.println(solution2);
        System.out.println(solution2 == 3);

        int solution3 = solution("hit", "cog", new String[]{"cog", "log", "lot", "dog", "hot"});
        System.out.println(solution3);
        System.out.println(solution3 == 4);

    }
}
