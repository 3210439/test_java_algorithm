package codingTestReady;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class 백준_9465_스티커 {

    static int n;
    static int[][] dp, arr;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    static void input() {
        StringTokenizer st;
        try {
            n = parseInt(br.readLine());
            dp = new int[2][n+1];
            arr = new int[2][n+1];
            for(int i=0; i<2; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=1; j<n+1; j++){
                    arr[i][j] = getIntToken(st);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void pro() {
        dp[0][1] = arr[0][1];
        dp[1][1] = arr[1][1];
        /**
         * 이런 문제는 i - 2 번째까지 접근하기 때문에 n이 2이거나 1일 경우를 늘 생각하고 있어야 한다.
         */
        if(n >=2) {
            dp[0][2] = arr[0][2] + dp[1][1];
            dp[1][2] = arr[1][2] + dp[0][1];
        }

        if(n >= 3) {
            for (int i = 3; i < n + 1; i++) {
                dp[0][i] = arr[0][i] + Math.max(dp[1][i - 1], dp[1][i - 2]);
                dp[1][i] = arr[1][i] + Math.max(dp[0][i - 1], dp[0][i - 2]);
            }
        }
        System.out.println(Math.max(dp[0][n], dp[1][n]));
    }

    public static void main(String[] args){
        br = new BufferedReader(new InputStreamReader(System.in));
        int t = 0;
        try {
            t = getInteger(br);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for(int i=0; i<t; i++){
            input();
            pro();
        }
    }

    private static int getIntToken(StringTokenizer st) {
        return parseInt(st.nextToken());
    }

    private static int getInteger(BufferedReader br) throws IOException {
        return parseInt(br.readLine());
    }
}
