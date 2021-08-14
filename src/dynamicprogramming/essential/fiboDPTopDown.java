package dynamicprogramming.essential;

public class fiboDPTopDown {

    public static long[] memo = new long[100];

    public static long fibo(int x) {
        if (x == 1 || x == 2) {
            return 1;
        }

        if (memo[x] != 0) {
            return memo[x];
        }

        memo[x] = fibo(x - 1) + fibo(x - 2);
        return memo[x];
    }

    public static void main(String[] args) {
        System.out.println(fibo(80));
    }
}
