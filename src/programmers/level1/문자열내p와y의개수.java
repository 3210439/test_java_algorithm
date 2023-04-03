package programmers.level1;

public class 문자열내p와y의개수 {
    class Solution {
        boolean solution(String s) {
            boolean answer = true;

            int countP = 0;
            int countY = 0;

            for(int i=0; i<s.length(); i++){
                if(s.charAt(i) == 'p' || s.charAt(i) == 'P') ++countP;
                if(s.charAt(i) == 'y' || s.charAt(i) == 'Y') ++countY;
            }

            System.out.println(countP);
            System.out.println(countY);

            if(countP != countY) answer = false;

            return answer;
        }
    }
}
