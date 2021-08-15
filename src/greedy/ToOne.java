// 동빈나 p.99
// 1이 될 때까지
// #greedy #DP
package greedy;

import java.util.Scanner;

public class ToOne {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int count = 0;

        while (n != 1) {
            if (n % k == 0) {
                n /= k;
            } else {
                n -= 1;
            }
            ++count;
        }

        System.out.println(count);
    }
}
/*
25 5
* */
// expecting: 2
