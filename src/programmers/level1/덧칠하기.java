package programmers.level1;

public class 덧칠하기 {
    class Solution {
        public int solution(int n, int m, int[] section) {
            int answer = 0;
            int temp = 0;

            for(int i=0; i<section.length; i++){
                if(section[i] >= temp){
                    System.out.println(temp);
                    temp = section[i] + m;
                    answer++;
                }
            }

            return answer;
        }
    }
}
