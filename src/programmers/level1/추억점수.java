package programmers.level1;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class 추억점수 {
    class Solution {
        public int[] solution(String[] name, int[] yearning, String[][] photo) {
            int[] answer = new int[photo.length];

            HashMap<String, Integer> map = new HashMap<>();
            int n = yearning.length;

            for(int i=0; i<n; i++){
                map.put(name[i], yearning[i]);
            }

            for(int i=0; i<photo.length; i++){
                int total = 0;
                for(int j=0; j < photo[i].length; j++){
                    total += map.get(photo[i][j]);
                }
                answer[i] = total;
            }

            return answer;
        }
    }
}
