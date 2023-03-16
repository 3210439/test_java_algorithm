package programmers;

import java.util.Arrays;

public class 최댓값_만들기1 {

    class Solution {
        public int solution(int[] numbers){
            Arrays.sort(numbers);
            return numbers[numbers.length-1] * numbers[numbers.length-2];
        }
    }
}
