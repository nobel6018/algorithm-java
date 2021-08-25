/*
 * https://programmers.co.kr/learn/courses/30/lessons/42626
 * 더 맵게
 * #heap
 * */

package heap;

import java.util.PriorityQueue;

public class Hotter {

    public static int solution(int[] scoville, int K) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i : scoville) {
            queue.add(i);
        }

        int count = 0;
        while (queue.peek() < K) {
            Integer min1 = queue.poll();
            if (min1 < K) {
                Integer min2 = queue.poll();
                if (min2 == null) {
                    return -1;
                }
                Integer newScoville = min1 + (min2 * 2);
                queue.add(newScoville);

                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int solution = solution(new int[]{1, 2, 3, 9, 10, 12}, 7);
        System.out.println(solution == 2);

        int solution1 = solution(new int[]{1, 2, 3, 4, 5}, 10000);
        System.out.println(solution1 == -1);
    }
}
