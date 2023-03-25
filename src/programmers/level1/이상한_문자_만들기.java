package programmers.level1;

public class 이상한_문자_만들기 {

    class Solution {
        public String solution(String s) {
            String answer = "";
            String[] strs = s.split(" ");

            strs[0] = strs[0].trim();
            for(int j=0; j< strs[0].length(); j++){
                if(j % 2 == 0) answer += String.valueOf(strs[0].charAt(j)).toUpperCase();
                else answer += String.valueOf(strs[0].charAt(j)).toLowerCase();
            }

            for(int i=1; i<strs.length; i++){
                strs[i] = strs[i].trim();
                answer += " ";
                for(int j=0; j< strs[i].length(); j++){
                    if(j % 2 == 0) answer += String.valueOf(strs[i].charAt(j)).toUpperCase();
                    else answer += String.valueOf(strs[i].charAt(j)).toLowerCase();
                }
            }

            return answer;
        }
    }
}
