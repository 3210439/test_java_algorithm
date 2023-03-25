package programmers.level1;

public class 부족한_금액_계산하기 {
    class Solution {
        public long solution(int price, int money, int count) {
            long leftMoney = money;

            for(long i=1; i<=count; i++){
                leftMoney -= i*price;
            }
            if(leftMoney > 0)
                return 0;
            else
                return leftMoney*-1;
        }
    }
}
