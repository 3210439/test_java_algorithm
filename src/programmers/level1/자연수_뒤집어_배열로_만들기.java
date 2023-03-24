package programmers.level1;

import java.util.ArrayList;
import java.util.List;

public class 자연수_뒤집어_배열로_만들기 {

    class Solution {
        public int[] solution(long n){
            int[] answer = {};
            List<Integer> list = new ArrayList<>();

            while (n>0){
                list.add((int) (n % 10));
                n /= 10;
            }
            return list.stream().mapToInt(i -> i).toArray();
        }
    }
}
