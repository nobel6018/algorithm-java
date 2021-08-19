/*
 * https://programmers.co.kr/learn/courses/30/lessons/43165
 * 타겟 넘버
 * #DFS
 * */
package dfsbfs;

public class TheTargetNumber {

    private static int answer = 0;

    private static void dfs(int[] numbers, int target, int stage, int result) {
        if (stage == numbers.length) {
            if (target == result) {
                answer++;
            }
            return;
        }

        dfs(numbers, target, stage + 1, result + numbers[stage]);
        dfs(numbers, target, stage + 1, result - numbers[stage]);
    }

    public static int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);

        return answer;
    }

    public static void main(String[] args) {
        int solution = solution(new int[]{1, 1, 1, 1, 1}, 3);
        System.out.println(solution == 5);
    }
}
