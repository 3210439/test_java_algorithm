package 기본알고리즘;

public class 탐욕알고리즘 {

    public static void main(String[] args) {
        int[] coins = {500, 100, 50, 10, 1}; // 사용 가능한 동전의 종류
        int money = 1260; // 거스름돈 금액
        int count = 0; // 동전 개수

        for (int i = 0; i < coins.length; i++) {
            count += money / coins[i]; // 현재 동전 종류로 거슬러 줄 수 있는 동전의 개수 계산
            money %= coins[i]; // 현재 동전 종류로 거슬러 주고 남은 거스름돈 계산
        }

        System.out.println("동전 개수: " + count);
    }
}
