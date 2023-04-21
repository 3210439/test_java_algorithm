package programmers.level2;

import java.util.PriorityQueue;

public class 더맵게 {


    class Solution {
        public int solution(int[] scoville, int K) {
            int answer = 0;
            PriorityQueue<Integer> heap = new PriorityQueue<>();
            for (int s:scoville){
                heap.add(s);
            }

            while(heap.size() >=2)
            {
                int min1 = heap.remove();
                int min2 = heap.remove();
                int temp = min1 + min2*2;
                heap.add(temp);
                answer+=1;
                if(heap.peek() >= K)
                    return answer;
            }
            return -1;

        }
    }
}
