/*
 * 단어 변환
 * https://programmers.co.kr/learn/courses/30/lessons/43163
 * # BFS
 * */
package dfsbfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ChangeWord {

    private static class Element {
        private final String word;
        private final int changeCount;
        private final int stage;

        public Element(String word, int changeCount, int stage) {
            this.word = word;
            this.changeCount = changeCount;
            this.stage = stage;
        }

        public String getWord() {
            return word;
        }

        public int getChangeCount() {
            return changeCount;
        }

        public int getStage() {
            return stage;
        }
    }

    public static int solution(String begin, String target, String[] words) {
        Queue<Element> queue = new LinkedList<>();
        queue.add(new Element(begin, 0, 0));

        ArrayList<Integer> answers = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            while (!queue.isEmpty()) {
                if (queue.peek().getStage() != i) {
                    break;
                }

                Element element = queue.poll();
                if (isDifferentOneChar(element.getWord(), words[i])) {
                    if (words[i].equals(target)) {
                        answers.add(element.getChangeCount() + 1);
                    }
                    queue.add(new Element(words[i], element.getChangeCount() + 1, element.getStage() + 1));
                }
                queue.add(new Element(element.getWord(), element.getChangeCount(), element.getStage() + 1));
            }

            if (answers.size() > 0) {
                return answers.stream().mapToInt(it -> it).min().orElse(0);
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
