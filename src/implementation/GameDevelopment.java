package implementation;

import java.util.Scanner;

public class GameDevelopment {

    private static int n, m, x, y, direction;

    private static int[][] d = new int[50][50];

    private static int[][] map = new int[50][50];

    private static int dx[] = {-1, 0, 1, 0};
    private static int dy[] = {0, 1, 0, -1};

    private static void turnLeft() {
        direction -= 1;
        if (direction == -1) {
            direction = 3;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        x = sc.nextInt();
        y = sc.nextInt();
        direction = sc.nextInt();
        d[x][y] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        int count = 1;
        int turnTime = 0;
        while (true) {
            // 왼쪽으로 회전
            turnLeft();
            int nx = x + dx[direction];
            int ny = y + dx[direction];

            // 회전한 이후 정면에 가보지 않은 칸이 존재하는 경우 이동
            if (d[nx][ny] == 0 && map[nx][ny] == 0) {
                d[nx][ny] = 1;
                x = nx;
                y = ny;
                count++;
                turnTime = 0;
                continue;
            } else {
                // 가본 곳이거나 바다인 경우
                turnTime++;
            }

            // 네 방향 모두 갈 수 없는 경우
            if (turnTime == 4) {
                nx = x - dx[direction];
                ny = x - dy[direction];

                // 뒤로 갈 수 있으면 이동하기
                if (map[nx][ny] == 0) {
                    x = nx;
                    y = ny;
                } else {
                    break;
                }
                turnTime = 0;
            }
        }

        System.out.println(count);
    }
}

/*
4 4
1 1 0
1 1 1 1
1 0 0 1
1 1 0 1
1 1 1 1
* */
// expecting: 3