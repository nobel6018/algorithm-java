/*
 * https://programmers.co.kr/learn/courses/30/lessons/43165
 * 타겟 넘버
 * #DFS
 * */
package dfsbfs;

public class TheTargetNumber {

    private static int answer = 0;

    private static int[] myNumberList;
    private static int myTarget;

    private static void dfs(int stage, int result) {
        if (stage == myNumberList.length) {
            if (myTarget == result) {
                answer++;
            }
            return;
        }

        dfs(stage + 1, result + myNumberList[stage]);
        dfs(stage + 1, result - myNumberList[stage]);
    }

    public static int solution(int[] numbers, int target) {
        myNumberList = numbers;
        myTarget = target;

        dfs(0, 0);

        return answer;
    }

    public static void main(String[] args) {
        int solution = solution(new int[]{1, 1, 1, 1, 1}, 3);
        System.out.println(solution == 5);
    }
}
