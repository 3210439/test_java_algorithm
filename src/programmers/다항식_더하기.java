package programmers;

import java.util.Arrays;

public class 다항식_더하기 {

    /**
     x가 1일때 1x가 아닌 x로 표기해야 된다.
     * 위 부분을 놓처서 시간이 좀더 걸렸던 것 같다.
     */

    class Solution {
        public String solution(String polynomial) {
            String answer = "";

            String[] strings = polynomial.split(" ");
            int xSum = 0;
            int numSum = 0;

            for(String str : strings){
                if(str.contains("+")) continue;
                if(str.contains("x")) {
                    if(str.length() != 1)
                        xSum += Integer.parseInt(str.split("x")[0]);
                    else
                        xSum += 1;
                }
                else {
                    numSum += Integer.parseInt(str);
                }
            }

            if( xSum >0 && numSum >0)
                if(xSum != 1)
                    answer = xSum + "x + " + numSum;
                else
                    answer = "x + " + numSum;
            else if(xSum > 0)
                if(xSum != 1)
                    answer = xSum + "x";
                else
                    answer = "x";
            else if(numSum > 0)
                answer = String.valueOf(numSum);
            else
                answer = polynomial;

            return answer;
        }
    }
    public static void main(String args[]){

    }

}
