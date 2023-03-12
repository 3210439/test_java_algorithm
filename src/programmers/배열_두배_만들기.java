package programmers;

import java.util.Arrays;

public class 배열_두배_만들기 {

    class Solution{
        public int[] solution(int[] numbers){
            return Arrays.stream(numbers).map(num -> num * 2).toArray();

        }
    }
}
