package programmers.level1;

public class 기사단원의_무기 {

    static class Solution {
        public int solution(int number, int limit, int power) {
            int answer = 0;

            for(int i=1; i<=number; i++){
                int count = countDivisors(i);
                if(count <= limit) answer += count;
                else answer += power;
            }

            return answer;
        }

        public static int countDivisors(int n) {
            int count = 0;
            for(int i=1; i<=Math.sqrt(n); i++){
                if(n % i == 0){
                    count ++;
                    if(n/i != i){
                        count ++;
                    }
                }
            }
            return count;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(10, 3, 2));
    }
}
