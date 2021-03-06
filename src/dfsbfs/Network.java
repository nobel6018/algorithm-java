/*
 * 네트워크
 * https://programmers.co.kr/learn/courses/30/lessons/43162
 * #BFS
 * */
package dfsbfs;

import java.util.LinkedList;
import java.util.Queue;

public class Network {
    public static int solution(int n, int[][] computers) {
        int answer = 0;

        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }

            visited[i] = true;

            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);

            while (!queue.isEmpty()) {
                Integer node = queue.poll();
                for (int j = 0; j < n; j++) {
                    int isConnected = computers[node][j];
                    if (isConnected == 1 && !visited[j]) {
                        visited[j] = true;
                        queue.add(j);
                    }
                }
            }

            answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        int solution = solution(3, new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}});
        System.out.println(solution == 2);

        int solution1 = solution(3, new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 0, 1}});
        System.out.println(solution1 == 1);
    }
}
