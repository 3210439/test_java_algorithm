package programmers.level1;

public class 문자열다루기기본 {
    class Solution {
        public boolean solution(String s) {
            boolean answer = true;
            int n = s.length();
            if(n == 4 || n == 6) {
                for(int i=0; i<n; i++){
                    if(s.charAt(i) < '0' || s.charAt(i) > '9')
                        answer = false;
                }
            }
            else{
                answer = false;
            }

            return answer;
        }
    }
}
