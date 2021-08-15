// 동빈나 p.152
// 미로 탈출
// #BFS
package dfsbfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node {
    private int x;
    private int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

public class MazeRunner {

    private static int n, m;
    private static int[][] map = new int[n][m];

    // (상 좌 하 우) 반시계 90도 씩 회전
    // x: 행, y: 열
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, -1, 0, 1};

    public static int bfs(int startX, int startY) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(startX, startY));

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int x = node.getX();
            int y = node.getY();
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 미로 공간을 벗어남
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }
                // 벽
                if (map[nx][ny] == 0) {
                    continue;
                }
                if (map[nx][ny] == 1) {
                    map[nx][ny] = map[x][y] + 1;
                    queue.offer(new Node(nx, ny));
                }
            }
        }

        return map[n - 1][m - 1];
    }

    public static void main(String[] args) {
        // input bug
        /*Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }*/
        n = 3;
        m = 3;
        map = new int[][]{
            {1, 1, 1},
            {0, 1, 0},
            {0, 1, 1}
        };

        System.out.println(bfs(0, 0));
    }

}
/*
3 3
110
010
011
* */
// expecting: 5
