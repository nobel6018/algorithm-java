// 동빈나 p.92
// 큰 수의 법칙
// #greedy
package greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class BigNumberPrincipal2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr, Comparator.reverseOrder());
        int firstMax = arr[0];
        int secondMax = arr[1];

        int secondMaxTimes = m / (k + 1);
        int firstMaxTimes = m - secondMaxTimes;

        int answer = firstMaxTimes * firstMax + secondMaxTimes * secondMax;

        System.out.println(answer);
    }
}
/*
5 8 3
2 4 5 4 6
* */
// expecting: 46