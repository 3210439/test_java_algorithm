package programmers.level1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 가장_가까운_같은_글자 {

    class Solution {
        public int[] solution(String s) {
            int[] answer = {};
            List<Integer> list = new ArrayList<>();
            Map<Character, Integer> map = new HashMap();

            for(int i=0; i<s.length(); i++){
                if(map.containsKey(s.charAt(i))){
                    list.add( i - map.get(s.charAt(i)));
                    map.put(s.charAt(i), i);
                }else{
                    list.add(-1);
                    map.put(s.charAt(i), i);
                }
            }

            return list.stream().mapToInt(Integer::intValue).toArray();
        }
    }


}
