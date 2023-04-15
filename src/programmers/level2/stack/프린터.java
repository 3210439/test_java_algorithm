package programmers.level2.stack;

import java.util.LinkedList;
import java.util.Queue;

public class 프린터 {

    static class Solution {
        public int solution(int[] priorities, int location) {
            int answer = 0;
            Queue<Integer> queue = new LinkedList<>();
            int nowIndex = location;

            for(int num : priorities) {
                queue.add(num);
            }
            while(true){
                int now = queue.poll();
                nowIndex -= 1;
                if(nowIndex < 0) nowIndex = queue.size();

                if(isNowMost(now, queue)){

                    answer += 1;

                    if(nowIndex == queue.size()) {
                        break;
                    }

                } else {
                    queue.add(now);
                }
            }

            return answer;
        }

        boolean isNowMost(int now, Queue<Integer> queue){
            for(int n : queue){
                if(n > now) return false;
            }
            return true;
        }

    }

    public static void main(String[] args) {
        int[] priorities = {1, 1, 9, 1, 1, 1};
        int location = 0;
        Solution solution = new Solution();
        solution.solution(priorities, location);
    }
}
