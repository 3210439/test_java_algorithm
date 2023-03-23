package programmers.level1;

import java.util.HashMap;
import java.util.Map;

public class 영어가_싫어요 {
    static class Solution {
        public long solution(String numbers) {
            String num = "";
            String temp = "";
            Map<String, Integer> map = new HashMap<>();
            map.put("zero", 0);
            map.put("one", 1);
            map.put("two", 2);
            map.put("three", 3);
            map.put("four", 4);
            map.put("five", 5);
            map.put("six", 6);
            map.put("seven", 7);
            map.put("eight", 8);
            map.put("nine", 9);

            for(int i=0; i<numbers.length(); i++) {
                temp += numbers.charAt(i);
                if (map.containsKey(temp)) {
                    num += map.get(temp);
                    temp = "";
                }
            }
            return Long.parseLong(num);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("onetwothreefourfivesixseveneightnine"));
    }

}
