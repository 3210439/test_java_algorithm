package programmers.level2.stack;

import java.util.Queue;
import java.util.LinkedList;

public class 다리를지나는트럭 {

    static class Solution {
        public int solution(int bridge_length, int weight, int[] truck_weights) {
            int answer = 1;

            Queue<Integer> readyQ = new LinkedList<>();
            Queue<RunningTruck> runningQ = new LinkedList<>();

            for(int truck : truck_weights){
                readyQ.add(truck);
            }

            while(readyQ.size() != 0 || runningQ.size() != 0) {

                if(readyQ.size() != 0 && canOnBridge(runningQ,readyQ.peek(), weight))
                    runningQ.add(new RunningTruck(readyQ.poll()));

                for(RunningTruck t : runningQ){
                    t.howFar += 1;
                }

                while(!runningQ.isEmpty() && runningQ.peek().howFar >= bridge_length){
                    runningQ.poll();
                }

                answer += 1;
            }

            return answer;
        }

        class RunningTruck {
            int howFar = 0;
            int truckWeight = 0;

            RunningTruck(int truckWeight){
                this.truckWeight = truckWeight;
            }

        }

        boolean canOnBridge(Queue<RunningTruck> runningQ, int truck, int weight){
            if(runningQ.isEmpty()) return true;

            int sum = truck;

            for(RunningTruck t : runningQ){
                sum += t.truckWeight;
            }

            return sum <= weight;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int bridgeLength = 100;
        int weight = 100;
        int[] truck_weight = new int[] {10};
        System.out.println(solution.solution(bridgeLength, weight, truck_weight));
    }
}
