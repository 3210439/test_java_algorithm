package programmers.level1;

import java.util.Arrays;

public class 예산 {

    class Solution {
        public int solution(int[] d, int budget) {
            int answer = 0;
            int sum = 0;
            Arrays.sort(d);
            for(int n : d){
                if(sum + n <= budget){
                    answer ++;
                    sum += n;
                }
            }
            return answer;
        }
    }
}
