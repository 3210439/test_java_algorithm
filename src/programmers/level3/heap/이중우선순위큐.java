package programmers.level3.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class 이중우선순위큐 {

    static class Solution {

        private PriorityQueue<Integer> maxHeap;
        private PriorityQueue<Integer> minHeap;

        public int[] solution(String[] operations) {
            int[] answer = {};

            maxHeap = new PriorityQueue<>(Collections.reverseOrder());
            minHeap = new PriorityQueue<>();

            for(String str : operations){
                verifyType(str);
            }

            if(maxHeap.isEmpty()){
                answer = new int[] {0, 0};
            }else{
                answer = new int[] {removeMax(), removeMin()};
            }

            return answer;
        }

        public void add(int num){
            minHeap.add(num);
            maxHeap.add(num);
        }

        public int removeMax() {
            int max = maxHeap.poll();
            minHeap.remove(max);
            return max;
        }

        public int removeMin() {
            int min = minHeap.poll();
            maxHeap.remove(min);
            return min;
        }

        public void verifyType(String str){
            if("D 1".equals(str)){
                if(!maxHeap.isEmpty())
                    removeMax();
            } else if("D -1".equals(str)){
                if(!minHeap.isEmpty())
                    removeMin();
            } else{
                String[] strArr = str.split(" ");
                int num = Integer.parseInt(strArr[1]);
                add(num);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] strs = new String[] {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
        solution.solution(strs);
    }


}
