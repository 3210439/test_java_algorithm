package programmers.level1;

import java.util.HashMap;
import java.util.Map;

public class 완주하지못한선수 {
    static class Solution {
        public String solution(String[] participant, String[] completion) {

            Map<String, Integer> map = new HashMap<>();

            for(int i=0; i<completion.length; i++){
                if(map.containsKey(completion[i]))
                    map.put(completion[i], map.get(completion[i]) + 1);
                else
                    map.put(completion[i], 1);
            }

            for(int i=0; i<participant.length; i++){
                if(map.containsKey(participant[i])){
                    if(map.get(participant[i]) == 0) return participant[i];
                    else map.put(participant[i], map.get(participant[i]) -1);
                }else{
                    return participant[i];
                }
            }


            String answer = "";
            return answer;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] participant = new String[] {"leo", "kiki", "eden"};
        String[] completion = new String[] {"eden", "kiki"};
        System.out.println(solution.solution(participant, completion));
    }
}
