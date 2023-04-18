package programmers.level2.stack;

import java.util.Arrays;

public class 주식가격 {

    class Solution {
        public int[] solution(int[] prices) {
            int n = prices.length;

            int[] answer = new int[prices.length];

            for(int i=0; i<n-1; i++){
                for(int j=i+1; j<n; j++){
                    answer[i]++;
                    if(prices[j] < prices[i])
                        break;
                }
            }
            answer[n-1] = 0;

            return answer;
        }
    }
}
