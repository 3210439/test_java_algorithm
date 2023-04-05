package programmers.level1;


import java.util.*;

public class 같은숫자는싫어 {

    public class Solution {
        public int[] solution(int []arr) {

            Queue<Integer> queue = new LinkedList<>();

            int before = arr[0];

            for(int i=1; i<arr.length; i++) {
                if(before != arr[i]) {
                    queue.add(before);
                }
                if(i == arr.length-1){
                    queue.add(arr[i]);
                }
                before = arr[i];
            }

            int[] answer = queue.stream().mapToInt(Integer::intValue).toArray();

            return answer;
        }
    }


/*    // 시간 초과 풀이
    public class Solution {
        public int[] solution(int[] arr) {
            int[] answer = {};
            List<Integer> collect = new LinkedList<>();

            for(int a : arr){
                collect.add(a);
            }


            for(int i= collect.size()-2; i>=0; i--){
                int before = collect.get(i+1);
                if(before == collect.get(i)){
                    collect.remove(i+1);
                }
            }

            answer = collect.stream().mapToInt(i -> i).toArray();

            return answer;
        }
    }*/
}
