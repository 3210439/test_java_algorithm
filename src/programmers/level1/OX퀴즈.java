package programmers.level1;

import java.util.ArrayList;
import java.util.List;

public class OX퀴즈 {
    static class Solution {
        public String[] solution(String[] quiz) {
            List<String> strList = new ArrayList<String>();

            for(String q : quiz){
                String[] split = q.split(" ");
                if(split[1].equals("+")){
                    if(Integer.parseInt(split[0]) + Integer.parseInt(split[2]) == Integer.parseInt(split[4]))
                        strList.add("O");
                    else
                        strList.add("X");
                } else{
                    if(Integer.parseInt(split[0]) - Integer.parseInt(split[2]) == Integer.parseInt(split[4]))
                        strList.add("O");
                    else
                        strList.add("X");
                }
            }
            return  strList.toArray(new String[0]);
        }
    }

    public static void main(String[] args) {
        String[] quiz = new String[] {"3 - 4 = -3", "5 + 6 = 11"};

        Solution solution = new Solution();
        solution.solution(quiz);
    }

}
