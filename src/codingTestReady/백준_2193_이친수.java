package codingTestReady;

import java.util.Scanner;

public class 백준_2193_이친수 {
    static int n;
    static long[] dy;
    static int MAX = 91;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        dy = new long[MAX];
        dy[1] = 1;
        dy[2] = 1;
        for(int i=3; i<MAX; i++){
            dy[i] = dy[i-1] + dy[i-2];
        }
        System.out.println(dy[n]);
    }
}
