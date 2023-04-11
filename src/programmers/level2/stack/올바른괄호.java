package programmers.level2.stack;

public class 올바른괄호 {
    class Solution {
        boolean solution(String s) {

            int sum = 0;

            for(int i=0; i<s.length(); i++){
                if(s.charAt(i) == '(') sum += 1;
                else sum -=1;
                if(sum < 0) return false;
                if(i == s.length() -1 && sum != 0) return false;
            }

            return true;
        }
    }
}
