package programmers.level1;
import java.util.Arrays;

public class 문자열내림차순으로배치하기 {

    class Solution {
        public String solution(String s) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            return new StringBuilder(new String(arr)).reverse().toString();
        }
    }
}
