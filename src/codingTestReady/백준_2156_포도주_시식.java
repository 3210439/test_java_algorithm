package codingTestReady;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Integer.parseInt;
import static java.lang.Math.max;

public class 백준_2156_포도주_시식 {
    static int max = 10010;
    static int n, ans;
    static int[] arr;
    static int[] dp;

    static void input(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            n = parseInt(br.readLine());
            arr = new int[10010];
            dp = new int[10010];
            for(int i=1; i<n+1; i++){
                arr[i] = parseInt(br.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void pro(){
        dp[1] = arr[1];
        dp[2] = dp[1] + arr[2];
        for(int i=3; i<n+1; i++){
            dp[i] = max(arr[i]+dp[i-2], arr[i]+arr[i-1]+dp[i-3]);
            dp[i] = max(dp[i - 1], dp[i]);
        }
        System.out.println(dp[n]);
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}
