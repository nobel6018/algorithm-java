package binarysearch;

import java.util.Arrays;
import java.util.Scanner;

public class FindElement {
    public static int binarySearch(Integer[] arr, int target, int start, int end) {
        if (start > end) {
            return -1;
        }

        int mid = (start + end) / 2;
        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] < target) {
            return binarySearch(arr, target, mid + 1, end);
        } else {
            return binarySearch(arr, target, start, mid - 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int m = sc.nextInt();
        int[] targets = new int[m];
        for (int i = 0; i < m; i++) {
            int position = binarySearch(arr, sc.nextInt(), 0, n - 1);
            if (position != -1) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }

/*
5
8 3 7 9 2
3
5 7 9
*/
}
