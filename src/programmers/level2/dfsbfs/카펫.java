package programmers.level2.dfsbfs;

import java.util.ArrayList;
import java.util.List;

public class 카펫 {
    /**
     * brown + yellow 는 사각형의 넓이이다.
     * return 값들은 사각형의 넓이의 약수 값이다.
     * 사각형 넓이 값의 약수 2개의 조합 중에서 곱할 때 사각형 넓이와 같은 것들의 조합 중에 답이 있다.
     */

    // 48 의 약수 중 가능한 조합 (16, 3), (12, 4), (8, 6)
    // brown 24 yellow 24
    // 여기서 사각형 크기는 테두리의 길이는 24+4인 28
    // 2 * (8 + 6) = 24이므로 8 과 6의 조합으로 구성된다는 것을 알 수 있다.

    static class Solution {

        public int[] solution(int brown, int yellow){
            int[] answer = {};
            int total = brown + yellow;
            List<Integer> measures = new ArrayList<>();
            int totalSq = (int)Math.sqrt(total);

            for(int i=3; i<=totalSq; i++){
                // total % i 는 공약수를 나타내는 조건
                if(total % i == 0){
                    measures.add(i);

                    // 이미 추가된 값은 무시한다.
                    if(total/i != i){
                        measures.add(total/i);
                    }


                    if(i*i == total){
                        measures.add(i);
                    }
                }
            }


            for(int i=0; i<measures.size()-1; i++){
                for(int j=i+1; j<measures.size(); j++){
                    int width = Math.max(measures.get(i), measures.get(j));
                    int height = Math.min(measures.get(i), measures.get(j));
                    int area = width * height;

                    if(area == total){
                        int squareSize = brown + 4;
                        int controlSquareSize = 2*(width + height);
                        if(squareSize == controlSquareSize){
                            answer = new int[] {width, height};
                            break;
                        }
                    }
                }
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        Solution solution1 = new Solution();

        int[] solution = solution1.solution(24, 24);

        for( int a : solution){
            System.out.println(a);
        }

    }
}
