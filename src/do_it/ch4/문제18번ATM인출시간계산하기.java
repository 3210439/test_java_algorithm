package do_it.ch4;

import java.util.Scanner;

import static java.util.Arrays.sort;

public class 문제18번ATM인출시간계산하기 {
    /**
     * from: https://www.acmicpc.net/problem/11399
     * ATM인출 시간 계산하기
     *
     * N(사람의 수) 입력 1 ~ 1000
     * P(사람 행) 입력 1 ~ 1000
     * P오름 차순 정렬
     * P의 요소 개수만큼 반복 첫 인덱스부터 끝 인덱스까지 더하기
     * 해당값 println
     */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // N(사람의 수) 입력 1~1000
        int N = sc.nextInt();

        // P(사람 행) 입력 1 ~ 1000
        int[] P = new int[N+1];
        for(int i=1; i<N+1; i++){
            P[i] = sc.nextInt();
        }


        // P 오름 차순 정렬
        sort(P);
        //for(int v : P)
        //System.out.print(v+" ");
        //System.out.println();

        int answer = 0;
        // P의 요소 개수만큼 반복 첫 인덱스부터 끝 인덱스까지 더하기
        for(int i = 1; i<N+1; i++){
            for(int j = 1; j < i+1; j++){
                //System.out.print(P[j]+" ");
                answer += P[j];
            }
            //System.out.println();
        }

        System.out.println(answer);

    }
}
