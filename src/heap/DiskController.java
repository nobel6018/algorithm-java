/*
 * https://programmers.co.kr/learn/courses/30/lessons/42627
 * 디스크 컨트롤러
 * #heap
 * SJF(Shortest Job First)
 * : 가장 실행시간이 짧은 job을 먼저 처리하는 방법
 * : 문제점: starvation. running time이 긴 프로세스는 cpu 자원을 못 받을 수 있다
 * */
package heap;

import java.util.PriorityQueue;

public class DiskController {
    static class Work implements Comparable<Work> {
        @Override
        public int compareTo(Work o) {
            if (this.start != o.start) {
                return this.start - o.start;
            }
            return this.running - o.running;
        }

        private final int start;
        private final int running;

        public Work(int start, int end) {
            this.start = start;
            this.running = end;
        }

        public int getStart() {
            return start;
        }

        public int getRunning() {
            return running;
        }
    }

    static class CandidateWork extends Work {
        public CandidateWork(int start, int end) {
            super(start, end);
        }

        @Override
        public int compareTo(Work o) {
            return this.getRunning() - o.getRunning();
        }
    }

    public static int solution(int[][] jobs) {
        PriorityQueue<Work> works = new PriorityQueue<>();
        PriorityQueue<CandidateWork> candidateWorks = new PriorityQueue<>();

        for (int[] job : jobs) {
            works.offer(new Work(job[0], job[1]));
        }

        int totalTime = 0;
        int currentTime = 0;
        while (!works.isEmpty() || !candidateWorks.isEmpty()) {
            while (!works.isEmpty() && works.peek().getStart() <= currentTime) {
                Work work = works.poll();
                candidateWorks.offer(new CandidateWork(work.getStart(), work.getRunning()));
            }

            if (candidateWorks.isEmpty()) {
                currentTime++;
                continue;
            }

            CandidateWork candidateWork = candidateWorks.poll();
            totalTime += (currentTime - candidateWork.getStart() + candidateWork.getRunning());
            currentTime += candidateWork.getRunning();
        }

        return totalTime / jobs.length;
    }

    public static void main(String[] args) {
        int solution = solution(new int[][]{{0, 3}, {1, 9}, {2, 6}});
        System.out.println(solution);
        System.out.println(solution == 9);
    }
}
