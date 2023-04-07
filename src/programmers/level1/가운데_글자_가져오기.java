package programmers.level1;

public class 가운데_글자_가져오기 {
    class Solution {
        public String solution(String s) {
            String answer = "";
            int n = s.length();
            if(n % 2 != 0) answer = String.valueOf(s.charAt(n/2));
            else answer = String.valueOf(s.charAt(n/2-1)) + String.valueOf(s.charAt(n/2));
            return answer;
        }
    }
}
