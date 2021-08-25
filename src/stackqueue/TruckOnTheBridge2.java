/*
 * https://programmers.co.kr/learn/courses/30/lessons/42583
 * 다리를 지나는 트럭
 * #Queue
 * * Good Reference: https://programmers.co.kr/learn/courses/30/lessons/42583/solution_groups?language=java
 * */
package stackqueue;

import java.util.LinkedList;
import java.util.Queue;


public class TruckOnTheBridge2 {
    static class Truck {
        private int weight;
        private int move;

        public Truck(int weight) {
            this.weight = weight;
            this.move = 1;
        }

        public void moving() {
            move++;
        }
    }

    public static int solution(int bridgeLength, int weight, int[] truckWeights) {
        Queue<Truck> waitQ = new LinkedList<>();
        Queue<Truck> moveQ = new LinkedList<>();

        for (int truckWeight : truckWeights) {
            waitQ.offer(new Truck(truckWeight));
        }

        int answer = 0;
        int curWeight = 0;

        while (!waitQ.isEmpty() || !moveQ.isEmpty()) {
            answer++;

            if (moveQ.isEmpty()) {
                Truck truck = waitQ.poll();
                curWeight += truck.weight;
                moveQ.offer(truck);
                continue;
            }

            for (Truck truck : moveQ) {
                truck.moving();
            }

            if (moveQ.peek().move > bridgeLength) {
                Truck truck = moveQ.poll();
                curWeight -= truck.weight;
            }

            if (!waitQ.isEmpty() && curWeight + waitQ.peek().weight <= weight) {
                Truck truck = waitQ.poll();
                curWeight += truck.weight;
                moveQ.offer(truck);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int solution = solution(2, 10, new int[]{7, 4, 5, 6});
        System.out.println(solution == 8);

        int solution1 = solution(100, 100, new int[]{10});
        System.out.println(solution1 == 101);

        int solution2 = solution(100, 100, new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10});
        System.out.println(solution2 == 110);
    }
}
