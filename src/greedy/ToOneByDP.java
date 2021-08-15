// 동빈나 p.99
// 1이 될 때까지
// #greedy #DP
package greedy;

import java.util.Scanner;

public class ToOneByDP {
    private static int[] d = new int[100001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        // for more clearly even though default value is 0
        d[1] = 0;
        for (int i = 1; i < n; i++) {
            if (d[i + 1] == 0 || d[i + 1] > d[i] + 1) {
                d[i + 1] = d[i] + 1;
            }

            if (i * k <= n) {
                if (d[i * k] == 0 || d[i * k] > d[i] + 1) {
                    d[i * k] = d[i] + 1;
                }
            }
        }

        System.out.println(d[n]);
    }
}
/*
25 5
* */
// expecting: 2

/*
12 5
* */
// expecting: 4

/*
39 4
* */
// expecting: 7