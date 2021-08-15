// 동빈나 p.99
// 1이 될 때까지
// #greedy #DP
package greedy;

import java.util.Scanner;

public class ToOneOptimized {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int count = 0;

        // 배수가 될 때까지 한 번에 minus 친다
        while (n >= k) {
            int left = n % k;
            count += left;
            n = (n - left);

            n = (n / k);
            count++;
        }

        if (n != 1) {
            count += n - 1;
        }

        System.out.println(count);
    }
}
/*
25 5
* */
// expecting: 2
