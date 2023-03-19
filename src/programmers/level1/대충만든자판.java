package programmers.level1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static programmers.level1.대충만든자판.Solution.solution;

public class 대충만든자판 {

    class Solution {
        static public int[] solution(String[] keymap, String[] targets) {
            int[] answer = {};
            List<Integer> list = new ArrayList();

            Map<Character, Integer> map = new HashMap<Character, Integer>();

            for(int i=0; i< keymap.length; i++){
                for(int j=0; j< keymap[i].length(); j++){
                    if(map.containsKey(keymap[i].charAt(j))){
                        map.put(keymap[i].charAt(j), Math.min(map.get(keymap[i].charAt(j)), j+1));
                    }else {
                        map.put(keymap[i].charAt(j), j+1);
                    }
                }
            }

            for(int i=0; i<targets.length; i++){
                int total = 0;
                boolean noKey = false;
                for(int j=0; j< targets[i].length(); j++){
                    if(map.containsKey(targets[i].charAt(j)))
                        total += map.get(targets[i].charAt(j));
                    else
                        noKey = true;
                }
                if(noKey)
                    list.add(-1);
                else
                    list.add(total);
            }

            for(Map.Entry<Character, Integer> entry : map.entrySet()) {
                System.out.println("Key: " + entry.getKey() + ", value: " + entry.getValue());
            }

            answer = list.stream().mapToInt(i -> i).toArray();

            return answer;
        }

    }

    public static void main(String[] args) {
        String[] keymap = {"ABACD", "BCEFD"};
        String[] targets = {"ABCD", "AABB"};
        System.out.println(solution(keymap, targets));
    }



}
