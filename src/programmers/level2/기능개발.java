package programmers.level2;

import java.util.*;

public class 기능개발 {

    static class Solution {
        public int[] solution(int[] progresses, int[] speeds) {

            int now = 0;
            List<Integer> list = new ArrayList<>();
            int n = progresses.length;

            while(now < n){
                int temp = progresses[now] + speeds[now];
                if(temp > 100){
                    int count = 0;
                    for(int i=now; i<n; i++){
                        if(progresses[i] + speeds[i] > 100){
                            count++;
                            now++;
                        }
                        else{
                            break;
                        }
                    }
                    list.add(count);
                    if(now >= progresses.length) {
                        break;
                    }
                }
                else{

                    for(int i=now; i<n; i++){
                        progresses[i] += speeds[i];
                    }
                }
            }

            int[] answer = new int[list.size()];
            for(int i=0; i<list.size(); i++){
                answer[i] = list.get(i);
            }

            return answer;
        }
    }

    public static void main(String[] args) {

        Solution solution = new Solution();
        int[] progresses = new int[] {93, 30, 55};
        int[] speeds = new int[] {1, 30, 5};
        int[] solution1 = solution.solution(progresses, speeds);
        for(int i : solution1){
            System.out.println(i);
        }
    }

}
