// 동빈나 p.217
// 1로 만들기
// #DP
package dynamicprogramming;

public class ToOne {

    private static long[] d = new long[30001];

    public static void main(String[] args) {

        int target = 4;

        // for more clearly even though default value is 0
        d[1] = 0;

        for (int i = 1; i < target; i++) {
            d[i + 1] = d[i] + 1;
            if (d[i * 2] > d[i] + 1) {
                d[i * 2] = d[i] + 1;
            }
            if (d[i * 3] > d[i] + 1) {
                d[i * 3] = d[i] + 1;
            }
            if (d[i * 5] > d[i] + 1) {
                d[i * 5] = d[i] + 1;
            }
        }

        System.out.println(d[target]);
    }
}
