package programmers.level2.dfsbfs;

public class 타겟_넘버 {
    class Solution {
        static int count = 0;

        static void dfs(int depth, int sum, int[] numbers,int target){
            if (depth == numbers.length)
            {
                if (sum == target)
                {
                    count +=1;
                }
                return;
            }
            dfs(depth +1, sum + numbers[depth], numbers, target);
            dfs(depth +1, sum - numbers[depth], numbers, target);
        }
        public int solution(int[] numbers, int target) {
            int answer = 0;
            dfs(0, 0, numbers, target);
            answer = count;
            return answer;
        }
    }
}
