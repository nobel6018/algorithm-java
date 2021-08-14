// 동빈나 p.220
// 개미 전사
// #DP
package dynamicprogramming;

import java.util.Scanner;

public class AntWarriors {

    // *점화식*
    // 나(i 번째 인덱스)를 선택하면 arr[i-2] + arr[i]
    // 나를 선택하지 않으면 arr[i-1]
    // 이 둘 중에 더 큰 것을 선택하면 됨 arr[i] = max(arr[i-2] + arr[i], arr[i-1])

    private static int[] d = new int[100];

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] stores = new int[n];
        for (int i = 0; i < n; i++) {
            stores[i] = sc.nextInt();
        }

        d[0] = stores[0];
        d[1] = stores[1];
        for (int i = 2; i < n; i++) {
            // when chosen myself
            int chosenCase = stores[i] + d[i - 2];

            // when doesn't chosen myself
            int notChosenCase = d[i - 1];

            d[i] = Math.max(chosenCase, notChosenCase);
        }

        System.out.println(d[n - 1]);
    }
}
/*
4
1 3 1 5
*/
// expecting: 8
