/*
 * programmers > 해시 > 위장
 * https://programmers.co.kr/learn/courses/30/lessons/42578
 * #hash
 * */
package hash;

import java.util.HashMap;

public class Camouflage {
    public static int solution(String[][] clothes) {
        HashMap<String, Integer> hashMap = new HashMap<>();

        for (String[] clothe : clothes) {
            String name = clothe[1];
            Integer count = hashMap.getOrDefault(name, 0);
            hashMap.put(name, count + 1);
        }

        /*
         * 상의: 1,2,3,4
         * 하의: 1',2',3'
         * 조합 수 (X, 1,2,3,4) x (X, 1',2',3') - 1(== X,X 경우)
         * */
        int answer = 1;
        for (Integer value : hashMap.values()) {
            answer *= (value + 1);  // 옷을 안 입는 경우: +1
        }
        answer -= 1;  // 모든 옷을 안 입는 경우 제외

        return answer;
    }

    public static void main(String[] args) {
        String[][] testCase1 = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
        int t1 = solution(testCase1);
        System.out.println(t1 == 5);

        String[][] testCase2 = {{"crowmask", "face"}, {"bluesunglasses", "face"}, {"smoky_makeup", "face"}};
        int t2 = solution(testCase2);
        System.out.println(t2 == 3);
    }
}
