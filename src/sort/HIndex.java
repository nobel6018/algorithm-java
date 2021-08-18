/*
 * H-Index
 * https://programmers.co.kr/learn/courses/30/lessons/42747
 * #Sort
 * */
package sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class HIndex {
    public static int solution(int[] citations) {
        List<Integer> integerList = Arrays.stream(citations)
            .boxed()
            .sorted(Comparator.reverseOrder())
            .collect(Collectors.toList());

        int h = 0;
        for (int i = 0; i < integerList.size(); i++) {
            if (i + 1 <= integerList.get(i)) {
                h = i + 1;
                continue;
            }
            break;
        }

        return h;
    }


    public static void main(String[] args) {
        int solution = solution(new int[]{6, 5, 4, 2, 2, 0});
        System.out.println(solution == 3);

        int solution1 = solution(new int[]{6, 5, 4, 4, 2, 1});
        System.out.println(solution1 == 4);
    }
}
