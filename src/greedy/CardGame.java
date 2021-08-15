// 동빈나 p.96
// 숫자 카드 게임
// #greedy
package greedy;

import java.util.Arrays;

public class CardGame {
    public static void main(String[] args) {
        int[][] arr = {
            {7, 3, 1, 8},
            {3, 3, 3, 4},
            {5, 1, 2, 4}
        };

        int answer = 0;
        for (int[] numbers : arr) {
            int min = Arrays.stream(numbers).min().getAsInt();
            answer = Math.max(answer, min);
        }

        System.out.println(answer);
    }
}
