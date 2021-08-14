package dynamicprogramming;

import java.util.Scanner;

public class MoneyCombination {

    private static int[] d = new int[10001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int target = sc.nextInt();

        int[] moneys = new int[n];
        for (int i = 0; i < n; i++) {
            int money = sc.nextInt();
            moneys[i] = money;
            d[money] = 1;
        }

        for (int i = 1; i < target - 1; i++) {
            if (d[i] == 0) {
                continue;
            }
            for (int j = 0; j < n; j++) {
                if (d[i + moneys[j]] == 0 || d[i + moneys[j]] > d[i] + 1) {
                    d[i + moneys[j]] = d[i] + 1;
                }
            }
        }

        System.out.println(d[target] == 0 ? -1 : d[target]);
    }
}
/*
2 15
2
3
*/
// expecting: 5

/*
3 4
3
5
7
*/
// expecting: -1