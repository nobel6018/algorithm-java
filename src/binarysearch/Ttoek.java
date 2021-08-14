package binarysearch;

import java.util.Scanner;

public class Ttoek {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int request = sc.nextInt();

        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }

        int start = 0;
        int end = (int) 1e9;

        int answer = 0;
        while (start <= end) {
            long total = 0;
            int mid = (start + end) / 2;

            for (int i = 0; i < n; i++) {
                if (array[i] > mid) {
                    total += array[i] - mid;
                }
            }

            if (total == request) {
                answer = mid;
                System.out.println(answer);
                return;
            } else if (total < request) { // 떡이 더 많이 남는 경우. 절단기 더 길게 해야함
                answer = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(answer);
    }
}
