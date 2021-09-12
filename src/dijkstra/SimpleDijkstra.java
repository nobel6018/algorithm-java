/*
 * 다익스트라 O(N^2)
 * 동빈나 알고리즘 p.237
 * ref: https://github.com/ndb796/python-for-coding-test/blob/master/9/1.java
 * */
package dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Node {
    private int index;
    private int distance;

    public Node(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    public int getIndex() {
        return index;
    }

    public int getDistance() {
        return distance;
    }
}

public class SimpleDijkstra {

    public static final int INF = (int) 1e9;

    // n: number of node
    // m: number of edge
    // start: start node number
    public static int n, m, start;

    // 각 노드에 연결되어 있는 노드에 대한 정보를 담는 배열
    public static ArrayList<ArrayList<Node>> graph = new ArrayList<>();

    // 방문한 적이 있는지 체크하는 목적의 배열 만들기
    public static boolean[] visited = new boolean[100001];

    // 최던 거리 테이블 만들기
    public static int[] d = new int[100001];

    // 방문하지 않은 노드 중에서 가장 최단 거리가 짧은 노드의 번호를 반환
    public static int getSmallestNode() {
        int minValue = INF;
        int index = 0; // 가장 최단 거리가 짧은 노드(인덱스)
        for (int i = 1; i <= n; i++) {
            if (d[i] < minValue && !visited[i]) {
                minValue = d[i];
                index = i;
            }
        }
        return index;
    }

    // O(n^2)
    public static void dijkstra(int start) {
        // 시작 노드에 대해서 초기화
        d[start] = 0;
        visited[start] = true;
        for (int i = 0; i < graph.get(start).size(); i++) {
            Node node = graph.get(start).get(i);
            d[node.getIndex()] = node.getDistance();
        }

        // 시작 노드를 제외한 전체 n-1개의 노드에 대해 반복
        for (int i = 0; i < n - 1; i++) {
            int now = getSmallestNode();
            visited[now] = true;

            for (int j = 0; j < graph.get(now).size(); j++) {
                Node node = graph.get(now).get(i);
                int cost = d[now] + node.getDistance();

                // 새로운 경로의 비용이 더 적으면 업데이트
                if (cost < d[node.getIndex()]) {
                    d[node.getIndex()] = cost;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        start = sc.nextInt();

        // initialize graph
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // input all edge information
        for (int i = 0; i < m; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int cost = sc.nextInt();

            graph.get(from).add(new Node(to, cost));
        }

        Arrays.fill(d, INF);

        dijkstra(start);

        for (int i = 1; i <= n; i++) {
            // 도달할 수 없는 경우, 무한(INF)이라고 출력
            if (d[i] == INF) {
                System.out.println("INF");
            } else {
                System.out.println(d[i]);
            }
        }
    }
}
