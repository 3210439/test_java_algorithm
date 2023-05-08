package programmers.level1.bruteforce;

public class 최소직사각형 {

    class Solution {
        public int solution(int[][] sizes) {
            int answer = 0;
            int maxWidth = 0;
            int maxHeight = 0;

            for(int[] size : sizes){
                int width = size[0];
                int height = size[1];

                if(width < height){
                    int temp = width;
                    width = height;
                    height = temp;
                }
                maxWidth = Math.max(maxWidth, width);
                maxHeight = Math.max(maxHeight,height);
            }


            answer = maxWidth * maxHeight;


            return answer;
        }
    }
}
