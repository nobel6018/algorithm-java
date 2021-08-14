package dynamicprogramming.essential;

public class fibonacci {
    public static int fibo(int x) {
        if (x == 1 || x == 2) {
            return 1;
        }
        return fibo(x - 1) + fibo(x - 2);
    }

    public static void main(String[] args) {
        int result = fibo(10);
        System.out.println(result);
    }
}
