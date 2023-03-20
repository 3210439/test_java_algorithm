package programmers.level1;

import java.util.Arrays;

public class 문자열_정렬하기2 {

    class Solution {
        public String solution(String my_string) {

            String lowerCase = my_string.toLowerCase();
            char[] chars = lowerCase.toCharArray();

            Arrays.sort(chars);

            return new String(chars);
        }
    }


}
