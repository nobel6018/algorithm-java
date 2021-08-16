package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MaxSession {

    private static class Session {
        private Integer startTime;
        private Integer endTime;

        public Session(Integer startTime, Integer endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        public Integer getStartTime() {
            return startTime;
        }

        public Integer getEndTime() {
            return endTime;
        }
    }

    public static int solution(List<Integer> startTime, List<Integer> runTime) {
        List<Session> sessions = new ArrayList<>();
        for (int i = 0; i < startTime.size(); i++) {
            sessions.add(new Session(startTime.get(i), startTime.get(i) + runTime.get(i)));
        }

        List<Session> sortedSessions = sessions.stream()
            .sorted(Comparator.comparing(Session::getEndTime))
            .collect(Collectors.toList());

        int answer = 0;
        int last = 0;
        for (Session session : sortedSessions) {
            if (last <= session.getStartTime()) {
                last = session.getEndTime();
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int solution = solution(Arrays.asList(1, 3, 5), Arrays.asList(3, 2, 2));
        System.out.println(solution);
    }
}

