/*
 * 이중우선순위큐
 * https://programmers.co.kr/learn/courses/30/lessons/42628
 * #heap
 * */
package heap;

import java.util.*;

public class DualPriorityQueue {

    static class DoubleEndedPriorityQueue {
        Set<Integer> s;

        public DoubleEndedPriorityQueue() {
            this.s = new HashSet<>();
        }

        public int size() {
            return s.size();
        }

        public boolean isEmpty() {
            return s.size() == 0;
        }

        public void insert(int x) {
            s.add(x);
        }

        public Integer getMin() {
            try {
                return Collections.min(s, null);
            } catch (NoSuchElementException e) {
                return null;
            }
        }

        public Integer getMax() {
            try {
                return Collections.max(s, null);
            } catch (NoSuchElementException e) {
                return null;
            }
        }

        public Integer deleteMin() {
            if (s.size() == 0) {
                return null;
            }

            Integer min = getMin();
            if (min != null) {
                s.remove(min);
            }
            return min;
        }

        public Integer deleteMax() {
            if (s.size() == 0) {
                return null;
            }

            Integer max = getMax();
            if (max != null) {
                s.remove(max);
            }
            return max;
        }
    }

    public static int[] solution(String[] operations) {
        DoubleEndedPriorityQueue queue = new DoubleEndedPriorityQueue();

        for (String operation : operations) {
            if (operation.startsWith("I")) {
                queue.insert((Integer.parseInt(operation.split(" ")[1])));
            } else if (operation.equals("D 1")) {
                queue.deleteMax();
            } else {
                queue.deleteMin();
            }
        }

        int max = 0;
        int min = 0;
        if (queue.getMax() != null) {
            max = queue.getMax();
        }
        if (queue.getMin() != null) {
            min = queue.getMin();
        }
        return new int[]{max, min};
    }

    public static void main(String[] args) {
        int[] solution1 = solution(new String[]{"I 16", "D 1"});
        System.out.println(Arrays.equals(solution1, new int[]{0, 0}));

        int[] solution2 = solution(new String[]{"I 7", "I 5", "I -5", "D -1"});
        System.out.println(Arrays.equals(solution2, new int[]{7, 5}));
    }
}
