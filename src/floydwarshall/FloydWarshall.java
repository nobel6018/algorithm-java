/*
 * 플로이드 워셜 알고리즘
 * 동빈나 알고리즘 p.257
 * */
package floydwarshall;

import java.util.Arrays;
import java.util.Scanner;

public class FloydWarshall {

    public static final int INF = (int) 1e9;

    // n: number of nodes, assumes that max is 500
    // m: number of edges
    public static int n, m;

    // 2차원 배열 (그래프 표현)
    public static int[][] graph = new int[501][501];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        // 최단 거리 테이블을 모두 무한으로 초기화
        for (int i = 0; i < 501; i++) {
            Arrays.fill(graph[i], INF);
        }

        // 자기 자신에서 자기 자신으로 가는 비용은 0으로 초기화
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    graph[i][j] = 0;
                }
            }
        }

        // 각 간선에 대한 정보를 입력 받아 그 값으로 초기화
        for (int i = 0; i < m; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int cost = sc.nextInt();
            graph[from][to] = cost;
        }

        // 점화식에 따라 플로이드 워셜 알고리즘을 수행
        for (int by = 1; by <= n; by++) {
            for (int from = 1; from <= n; from++) {
                for (int to = 1; to <= n; to++) {
                    graph[from][to] = Math.min(graph[from][to], graph[from][by] + graph[by][to]);
                }
            }
        }

        // 수행된 결과를 출력
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                // 도달할 수 없는 경우, INF로 출력
                if (graph[i][j] == INF) {
                    System.out.println("INF");
                } else {
                    // 도달할 수 있는 경우 거리를 출력
                    System.out.println(graph[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}
