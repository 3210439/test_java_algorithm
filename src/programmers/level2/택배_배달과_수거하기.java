package programmers.level2;

import java.util.Arrays;




public class 택배_배달과_수거하기 {

    class Solution {
        static public long solution(int cap, int n, int[] deliveries, int[] pickups) {

            long answer = 0;
            int deliveryTotal = 0;
            int pickupsTotal = 0;
            for(int i=0; i<n; i++){
                deliveryTotal += deliveries[i];
                pickupsTotal += pickups[i];
            }

            int truck = 0;
            int pickupBox = 0;

            while(deliveryTotal > 0 || pickupsTotal > 0){

                truck = 0;
                pickupBox = 0;

                int beginIndex = n-1;
                for(int i=n-1; i>=0; i--){
                    if(deliveries[i] == 0 && pickups[i] == 0
                            && beginIndex >0) beginIndex -=1;
                    else break;
                }

                for(int i=beginIndex; i>=0; i--){

                    if(truck < cap && deliveries[i] != 0) {

                        if(truck + deliveries[i] <= cap) {
                            truck += deliveries[i];
                            deliveryTotal -= deliveries[i];
                            deliveries[i] = 0;
                        }else{
                            int temp = cap - truck;
                            truck += temp;
                            deliveryTotal -= temp;
                            deliveries[i] -= temp;
                        }

                    }
                    if(pickupBox < cap && pickups[i] != 0) {

                        if(pickupBox + pickups[i] <= cap) {
                            pickupBox += pickups[i];
                            pickupsTotal -= pickups[i];
                            pickups[i] = 0;
                        } else {
                            int temp = cap - pickupBox;
                            pickupBox += temp;
                            pickupsTotal -= temp;
                            pickups[i] -= temp;
                        }

                    }

                    if((truck == cap && pickupBox == cap) || i == 0 ){
                        answer += 2*(beginIndex+1);
                        break;
                    }
                }
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        System.out.println("answer: " + Solution.solution(5, 5, new int[] {1,2,3,4,5}, new int[] {5,4,3,2,1}));
    }
}