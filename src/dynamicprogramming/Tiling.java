package dynamicprogramming;

import java.util.Scanner;

public class Tiling {


    private static int[] d = new int[1001];

    public static void main(String[] args) {

        // *점화식*
        // a(n) = a(n-1) + 2*a(n-2)
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        d[1] = 1;
        d[2] = 3;

        for (int i = 3; i <= n; i++) {
            d[i] = (d[i - 1] + 2 * d[i - 2]) % 796796;
        }

        System.out.println(d[n]);
    }
}
