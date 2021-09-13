package dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class Node2 implements Comparable<Node2> {

    private int index;
    private int distance;

    public Node2(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    public int getIndex() {
        return index;
    }

    public int getDistance() {
        return distance;
    }

    // 거리(비용)가 짧은 것이 높은 우선순위를 가지도록 설정
    @Override
    public int compareTo(Node2 o) {
        return this.distance - o.getDistance();
    }
}

public class BetterDijkstra {

    private static final int INF = (int) 1e9;

    // n: number of nodes
    // m: number of edges
    // start: index of start node
    public static int n, m, start;

    public static ArrayList<ArrayList<Node2>> graph = new ArrayList<>();
    
    public static int[] d = new int [100001];
    
    public static void dijkstra(int start) {
        PriorityQueue<Node2> queue = new PriorityQueue<>();
        
        queue.offer(new Node2(start, 0));
        
        while (!queue.isEmpty()) {
            Node2 node = queue.poll();
            int distance = node.getDistance();
            int now = node.getIndex();
            
            if (d[now] < distance) {
                continue;
            }

            // 현재 노드와 연결된 인접한 노드들을 확인
            for (int i = 0; i < graph.get(now).size(); i++) {
                Node2 connectedNode = graph.get(now).get(i);
                int cost = d[now] + connectedNode.getDistance();

                if (cost < d[connectedNode.getIndex()]) {
                    d[connectedNode.getIndex()] = cost;
                    queue.offer(new Node2(connectedNode.getIndex(), cost));
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        start = sc.nextInt();

        // 그래프 초기화
        for (int i = 0; i <= n ; i++) {
            graph.add(new ArrayList<>());
        }

        // 모든 간선 정보를 입력받기
        for (int i = 0; i < m; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int cost = sc.nextInt();
            graph.get(from).add(new Node2(to, cost));
        }

        Arrays.fill(d, INF);

        dijkstra(start);

        for (int i = 0; i <= n; i++) {
            // 도달할 수 없는 경우, INF로 출력
            if (d[i] == INF) {
                System.out.println("INF");
            } else {
                System.out.println(d[i]);
            }

        }
    }
}
