package programmers.level3.sort;

import java.util.Arrays;

public class H_Index {

    class Solution {
        public int solution(int[] citations) {

            Arrays.sort(citations);

            int h = 1;
            int start = citations.length-1;

            while(citations[start] > h){
                h++;
                start--;
            }
            return citations[start];

        }
    }
}
