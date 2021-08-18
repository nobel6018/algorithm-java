/*
 * 가장 큰 수
 * https://programmers.co.kr/learn/courses/30/lessons/42746
 * #Sort
 * */
package sort;

import java.util.ArrayList;
import java.util.Comparator;

public class TheMaxNumber {

    static class Sorter implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            // 뒤쪽이 더 작은게 오니까 내림차순
            // 자바에서는 기본적으로 오름차순으로 정렬
            // String.compareTo(String another); 이 함수도 기본적으로 오름차순으로 동작
            return o2.repeat(3).compareTo(o1.repeat(3));
        }
    }

    public static String solution(int[] numbers) {
        ArrayList<String> nums = new ArrayList<>();
        for (int number : numbers) {
            nums.add(String.valueOf(number));
        }

        Sorter sorter = new Sorter();
        nums.sort(sorter);

        StringBuilder answer = new StringBuilder();
        for (String num : nums) {
            answer.append(num);
        }
        if (answer.toString().startsWith("0")) {
            return "0";
        }
        return answer.toString();
    }

    public static void main(String[] args) {
        String solution = solution(new int[]{3, 30, 34, 5, 9});
        System.out.println(solution.equals("9534330"));

        String solution2 = solution(new int[]{0,0,0});
        System.out.println(solution2.equals("0"));
    }
}
