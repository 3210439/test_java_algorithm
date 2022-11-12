package codingTestReady;

import java.util.Scanner;

public class 백준_1309_동물원 {

    static int n;
    static long ans;
    static long[] dp;

    public static void main(String[] args) {
        input();
        calculate();
        this_is_answer();
    }

    private static void this_is_answer() {
        System.out.println(ans);
    }

    private static void calculate() {
        if (lowerThenTwo()) return;
        for(int i=3; i<n+1; i++){
            dp[i] = (2*dp[i-1] + dp[i-2])%9901;
        }
        ans = dp[n];
    }

    private static boolean lowerThenTwo() {
        dp[1] = 3;
        if(dp.length == 2){
            ans = dp[1];
            return true;
        }
        dp[2] = 7;
        if(dp.length == 3){
            ans = dp[2];
            return true;
        }
        return false;
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        dp = new long[n+1];
    }
}
