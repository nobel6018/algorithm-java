// 동빈나 p.87
// 거스름돈 문제
// #greedy

/*
 * 그리디 알고리즘은 '사전에 외우고 있지 않아도 풀 수 있을 가능성이 높은 문제 유형'
 * 정렬, 최단 경로 등은 미리 해당 알고리즘을 알고 있어야 한다
 * 최단 경로 중에서 플로이드 워셜, 다익스트라 알고리즘과 같은 특정 알고리즘은 미리 알고 있거나
 * 팀 노트를 통해 준비해야 풀 수 있다
 * */

package greedy.essential;

public class ChangeMoney {

    public static void main(String[] args) {
        int n = 1260;
        int count = 0;

        int[] moneys = {500, 100, 50, 10};
        for (int money : moneys) {
            count += n / money;
            n = n % money;

        }
        System.out.println(count);
    }
}
