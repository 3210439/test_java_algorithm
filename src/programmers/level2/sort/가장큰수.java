package programmers.level2.sort;


import java.util.Arrays;
import java.util.Comparator;

public class 가장큰수 {

    static class Solution {

        public String solution(int[] numbers) {

            String[] stringNums = new String[numbers.length];

            for(int i=0; i< stringNums.length; i++){
                stringNums[i] = Integer.toString(numbers[i]);
            }

            Arrays.sort(stringNums, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    String leftStr = o1 + o2;
                    String rightStr = o2 + o1;
                    return rightStr.compareTo(leftStr);
                }
            });

            StringBuilder sb = new StringBuilder();

            for(String str : stringNums) sb.append(str);

            if(sb.charAt(0) == '0') return "0";
            String answer = sb.toString();
            return answer;
        }

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {6, 10, 2};

        System.out.println(solution.solution(arr));
    }
}
