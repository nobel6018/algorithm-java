/*
 * 완주하지 못한 선수
 * https://programmers.co.kr/learn/courses/30/lessons/42576
 * #hash
 * */
package hash;

import java.util.HashMap;

public class ShouldHaveRun {
    public static String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> hashMap = new HashMap<>();

        for (String s : participant) {
            Integer count = hashMap.getOrDefault(s, 0);
            hashMap.put(s, count + 1);
        }

        for (String s : completion) {
            Integer count = hashMap.get(s);
            if (count == 1) {
                hashMap.remove(s);
            } else {
                hashMap.put(s, count - 1);
            }
        }

        return hashMap.keySet().iterator().next();
    }

    public static void main(String[] args) {
        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};

        String solution = solution(participant, completion);
        System.out.println(solution.equals("mislav"));
    }
}
