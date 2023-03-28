package programmers.level1;

import java.util.HashMap;
import java.util.Map;

public class 폰켓몬 {

    static class Solution {
        public int solution(int[] nums) {

            int answer = 0;
            Map<Integer, Integer> map = new HashMap<>();

            for(int num: nums){
                if(map.containsKey(num)) map.put(num, map.get(num) + 1);
                else {
                    System.out.println(num);
                    answer += 1;
                    map.put(num, 1);
                }
            }

            answer = Integer.min(answer, nums.length/2);

            return answer;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[] {3, 1, 2, 3}));
    }
}
