package graph;

import java.util.Scanner;

public class UnionAndFind2 {

    // V: 노드 갯수
    // E: 간선(union 연산) 개수
    // 노드의 최대 개수는 100,000
    public static int v, e;
    public static int[] parent = new int[100001];

    // 특정 원소가 속한 집합을 찾기
    public static int findParent(int x) {
        // 루트 노드가 아니라면, 루트 노드를 찾을 때까지 재귀적으로 호출
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = findParent(parent[x]);
    }

    public static void unionParent(int a, int b) {
        a = findParent(a);
        b = findParent(b);
        if (a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        v = sc.nextInt();
        e = sc.nextInt();

        for (int i = 1; i <= v; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < e; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            unionParent(a, b);
        }

        System.out.println("각 원소가 속한 집합: ");
        for (int i = 1; i <= v; i++) {
            System.out.println(findParent(i) + " ");
        }
        System.out.println();

        // 부모 테이블 내용 출력하기
        System.out.println("부모 테이블: ");
        for (int i = 1; i <= v; i++) {
            System.out.println(parent[i] + " ");
        }
        System.out.println();
    }
}
