package programmers.level1;

public class 삼총사 {

    class Solution {

        static int total =0 ;
        public int solution(int[] number) {

            countSamchonsa(0, 0,0, number);

            return total;
        }

        public void countSamchonsa(int index, int count,int sum, int[] number){

            if(count >= 3){
                if(sum == 0) total +=1;
                return;
            }

            for(int i=index; i<number.length; i++){
                countSamchonsa(i+1, count+1, sum + number[i], number);
            }

        }
    }
}
