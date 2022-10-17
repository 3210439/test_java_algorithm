package codingTestReady;

import java.util.Scanner;

public class 백준_9095_1_2_3더하기 {

    static int[] Dy;

    static void preprocess() {
        Dy = new int[15];
        // 초기값 구하기
        Dy[1] = 1;
        Dy[2] = 2;
        Dy[3] = 4;

        // 점화식을 토대로 Dy 배열 채우기
        for(int i=4; i<Dy.length; i++){
            Dy[i] = Dy[i-1] + Dy[i-2] + Dy[i-3];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        preprocess();

        for(int i=0; i<n; i++){
            int t = sc.nextInt();
            System.out.println(Dy[t]);
        }

    }
}
