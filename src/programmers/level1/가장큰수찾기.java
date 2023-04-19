package programmers.level1;

public class 가장큰수찾기 {

    class Solution {
        public int[] solution(int[] array) {

            int max = array[0];
            int maxIndex =0;
            int n = array.length;

            for(int i=1; i<n; i++){
                if(array[i] > max){
                    max = array[i];
                    maxIndex = i;
                }
            }

            return new int[]{max, maxIndex};
        }
    }

}
