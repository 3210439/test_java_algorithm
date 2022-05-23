package do_it;

import java.util.Scanner;

public class Prefix_Sum_003 {
    public static void main(String[] args){
        // 백준 11659
        StringBuilder sb = new StringBuilder();
        int N, M;
        int[] A, S;

        // 입력 받기
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        M = scan.nextInt();
        A = new int[N+1];
        S = new int[N+1];
        S[0] = 0;
        // 구간 합을 입력과 동시에 구하기
        for (int i=1; i<=N; i++){
            A[i] = scan.nextInt();
            S[i] = A[i] + S[i-1];
        }
        // i번째부터 j번째까지 값 구하기
        for(int i=1; i<=M; i++){
            int index = scan.nextInt();
            int j = scan.nextInt();
            long temp = 0;

            temp = S[j] - S[index-1];
            sb.append(temp).append('\n');
        }

        System.out.println(sb);
    }
}
