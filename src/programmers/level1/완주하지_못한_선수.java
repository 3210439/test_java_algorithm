package programmers.level1;

import java.util.HashMap;
import java.util.Map;

public class 완주하지_못한_선수 {

    static class Solution {
        public String solution(String[] participant, String[] completion) {
            String answer = "";

            Map<String, Integer> map = new HashMap<>();

            for(String c: completion){
                if(map.containsKey(c)) map.put(c, map.get(c)+1);
                else map.put(c, 1);
            }

            for(String p: participant){
                if(map.containsKey(p)){
                    if(map.get(p) >=1) map.put(p, map.get(p) -1);
                    else return p;
                } else return p;
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] completion = {"josipa", "filipa", "marina", "nikola"};
        System.out.println(solution.solution(participant, completion));
    }
}
