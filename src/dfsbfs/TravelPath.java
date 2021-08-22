/*
 * https://programmers.co.kr/learn/courses/30/lessons/43164
 * 여행 경로
 * #DFS
 * */
package dfsbfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TravelPath {

    private static String[][] myTickets;
    private static boolean[] visited;

    private static List<String> answers;

    private static void dfs(String position, int visitCount, String path) {
        if (visitCount == myTickets.length) {
            answers.add(path);
        }

        for (int i = 0; i < myTickets.length; i++) {
            if (myTickets[i][0].equals(position) && !visited[i]) {
                visited[i] = true;
                dfs(myTickets[i][1], visitCount + 1, path.concat(" " + myTickets[i][1]));
                visited[i] = false;
            }
        }
    }

    public static String[] solution(String[][] tickets) {
        myTickets = tickets;
        visited = new boolean[myTickets.length];
        answers = new ArrayList<>();

        dfs("ICN", 0, "ICN");

        Collections.sort(answers);
        return answers.get(0).split(" ");
    }

    public static void main(String[] args) {
        String[] solution = solution(new String[][]{{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}});
        System.out.println(Arrays.equals(solution, new String[]{"ICN", "JFK", "HND", "IAD"}));

        String[] solution1 = solution(new String[][]{{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}});
        System.out.println(Arrays.equals(solution1, new String[]{"ICN", "ATL", "ICN", "SFO", "ATL", "SFO"}));
    }
}
