package codingTestReady;

import java.util.Scanner;

public class 백준_2579_계단오르기 {

    static int[] A;
    static int[][] Dy;
    static int N;

    static void input(){
        Scanner sc = new Scanner(System.in);
        N  = sc.nextInt();
        A = new int[N+1];
        Dy = new int[N+1][2];

        for(int i=1; i<N+1; i++){
            A[i] = sc.nextInt();
        }
    }

    static void pro() {
        // 초기값 구하기
        Dy[1][0] = 0;
        Dy[1][1] = A[1];

        if (N >= 2){
            Dy[2][0] = A[2];
            Dy[2][1] = A[1] + A[2];
        }

        // 점화식을 토대로 Dy 배열 채우기
        for (int i = 3; i <= N; i++){
            Dy[i][0] = Math.max(Dy[i - 2][0] + A[i], Dy[i - 2][1] + A[i]);
            Dy[i][1] = Dy[i - 1][0] + A[i];
        }

        // Dy 배열로 정답 계산하기
        int ans = Math.max(Dy[N][0], Dy[N][1]);

        System.out.println(ans);
    }


    // 진짜 문제 = N번째 계단에 도착하며 얻는 최대 점수
    // 가짜 문제 = Dy[i] = i번째 계단에 도착하며 얻는 최대 점수
    public static void main(String[] args) {
        input();
        pro();
    }
}
