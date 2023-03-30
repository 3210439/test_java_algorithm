package programmers.level2.hash;

import java.util.HashMap;
import java.util.Map;

public class 위장 {

    static class Solution {
        public int solution(String[][] clothes) {
            int answer = 1;
            Map<String, Integer> map = new HashMap();

            for(String clothe[]: clothes){
                if(map.containsKey(clothe[1]))
                    map.put(clothe[1], map.get(clothe[1])+1);
                else
                    map.put(clothe[1], 1);
            }

            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                answer *= (entry.getValue()+1);
            }
            answer -= 1;


            return answer;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new String[][]{{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}}));
    }
}
