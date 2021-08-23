/*
 * https://programmers.co.kr/learn/courses/30/lessons/42583
 * 다리를 지나는 트럭
 * #Queue
 * */
package stackqueue;

import java.util.LinkedList;
import java.util.Queue;


public class TruckOnTheBridge {
    static class Truck {
        private int weight;
        private int onBoardTime;

        public Truck(int weight, int onBoardTime) {
            this.weight = weight;
            this.onBoardTime = onBoardTime;
        }

        public int getWeight() {
            return weight;
        }

        public int getOnBoardTime() {
            return onBoardTime;
        }
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Truck> bridge = new LinkedList<>();

        int elapsedTime = 0;

        int truckIndex = 0;

        int onWeight = 0;
        int onTruckCount = 0;

        // initialize
        int truckWeight = truck_weights[truckIndex++];
        bridge.add(new Truck(truckWeight, elapsedTime++));
        onWeight += truckWeight;
        onTruckCount++;

        while (!bridge.isEmpty()) {
            if (bridge.peek() != null && elapsedTime - bridge.peek().getOnBoardTime() >= bridge_length) {
                Truck truck = bridge.poll();
                onWeight -= truck.getWeight();
                onTruckCount--;
            }

            if (truckIndex < truck_weights.length) {
                truckWeight = truck_weights[truckIndex];
                if (onWeight + truckWeight <= weight && onTruckCount + 1 <= bridge_length) {
                    bridge.add(new Truck(truckWeight, elapsedTime));
                    onWeight += truckWeight;
                    onTruckCount++;
                    truckIndex++;
                }
            }

            elapsedTime++;
        }

        return elapsedTime;
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
