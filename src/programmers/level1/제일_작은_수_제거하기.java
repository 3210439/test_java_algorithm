package programmers.level1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class 제일_작은_수_제거하기 {
    class Solution {
        public int[] solution(int[] arr) {
            List<Integer> list = Arrays.stream(arr).mapToObj(Integer::valueOf).collect(Collectors.toList());
            int min = Integer.MAX_VALUE;
            int indexToRemove = 0;

            for(int i=0; i<list.size(); i++){
                if(min > list.get(i)) {
                    indexToRemove = i;
                    min = list.get(i);
                }
            }

            list.remove(indexToRemove);

            int[] answer = list.stream().mapToInt(Integer::intValue).toArray();
            if(answer.length == 0) answer = new int[] {-1};
            return answer;
        }
    }

    public static void main(String[] args) {

    }
}
