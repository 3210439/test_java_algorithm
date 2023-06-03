package programmers.level2.dfsbfs;

public class 카펫 {
    // 1. 테두리 1줄은 갈색이다.
    // 2. 사각형 넓이가 주어진다.
    // 3. 소수를 구한다.

    static class Solutnion {

        public int[] solution(int brown, int yellow){
            int[] answer = {};
            int total = brown + yellow;
            int totalSq = (int) Math.sqrt(total);

            // ex 3
            for(int i = 1; i <= totalSq; ++i){
                if( totalSq % i == 0){
                    answer = new int[]{i,totalSq / i};
                    break;
                }
            }


            return answer;
        }
    }

    public static void main(String[] args) {
        Solutnion solutnion = new Solutnion();

        int[] solution = solutnion.solution(10, 2);

        for( int a : solution){
            System.out.println(a);
        }

    }
}
