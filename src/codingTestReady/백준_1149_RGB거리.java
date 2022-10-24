package codingTestReady;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class 백준_1149_RGB거리 {

    static int n;
    static int ans = Integer.MAX_VALUE;
    static int[][] arr;
    static int[][] dy;

    static void input() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        try {
            n = parseInt(br.readLine());
            arr = new int[n+1][3+1];
            dy = new int[n+1][3+1];

            for(int i=1; i<n+1; i++){
                st = new StringTokenizer(br.readLine());
                arr[i][1] = parseInt(st.nextToken());
                arr[i][2] = parseInt(st.nextToken());
                arr[i][3] = parseInt(st.nextToken());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void pro() {

        dy[1][1] = arr[1][1];
        dy[1][2] = arr[1][2];
        dy[1][3] = arr[1][3];

        for(int i=2; i<n+1; i++){
            for(int j=1; j<4; j++){
                for(int k=1; k<4; k++){
                    if(j != k) {
                        if(dy[i][j] == 0) dy[i][j] = arr[i][j] + dy[i-1][k];
                        dy[i][j] = Math.min(arr[i][j] + dy[i-1][k],dy[i][j]);
                    }
                }
            }
        }

        for(int i =1; i<4; i++){
            ans = Math.min(dy[n][i], ans);
        }

        System.out.println(ans);
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}
