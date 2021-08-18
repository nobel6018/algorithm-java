/*
 * https://programmers.co.kr/learn/courses/30/lessons/42897
 * 도둑질
 * #DP
 * */
package dynamicprogramming;

public class Thief {
    private static int[] d = new int[1000001];

    public static int solution(int[] money) {
        int[] results = new int[2];

        // 0번째 집을 터는 경우 (마지막 집 털지 않음)
        d[0] = money[0];
        d[1] = money[0];

        for (int i = 2; i < money.length - 1; i++) {
            d[i] = Math.max(d[i - 1], money[i] + d[i - 2]);
        }
        results[0] = d[money.length - 2];

        // 0번째 집을 털지 않는 경우
        d[0] = 0;
        d[1] = money[1];
        for (int i = 2; i < money.length; i++) {
            d[i] = Math.max(d[i - 1], money[i] + d[i - 2]);
        }
        results[1] = d[money.length - 1];

        return Math.max(results[0], results[1]);
    }

    public static void main(String[] args) {
        int solution = solution(new int[]{1, 2, 3, 1});
        System.out.println(solution == 4);

        int solution1 = solution(new int[]{1, 1, 4, 1, 4});
        System.out.println(solution1 == 8);

        int solution2 = solution(new int[]{10, 1, 1, 10, 1});
        System.out.println(solution2 == 20);
    }
}
