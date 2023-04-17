package programmers.level1;


import java.util.Arrays;

public class K번째수 {
    class Solution {
        public int[] solution(int[] array, int[][] commands) {
            int[] answer = new int[commands.length];

            for(int p=0; p<commands.length; p++)
            {
                int i = commands[p][0];
                int j = commands[p][1];
                int k = commands[p][2];
                int[] arr = Arrays.copyOfRange(array,i-1, j);
                Arrays.sort(arr);
                answer[p] = arr[k-1];
            }

            return answer;
        }
    }
}
