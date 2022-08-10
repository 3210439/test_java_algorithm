package do_it.ch4;

import java.util.Scanner;

public class 버블소트프로그램2 {

    static int count = 0;
    public static void main(String[] args){
        /**
         * N 입력
         * A 배열 생성
         * A 값 입력
         * 전역변수 count 생성
         * 버블정렬시 count 1씩 증가
         * count 값 반환
         */

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N+1];

        for(int i=1; i<N+1; i++){
            A[i] = sc.nextInt();
        }
        bubble(A, N);
        System.out.println(count);
    }
    static void bubble(int[] A,int N){
           for(int i=1; i<N+1; i++){
               for(int j=1; j<N; j++){
                    if(A[j] > A[j+1]) swap(A, j, j+1);
               }
           }
    }

    static void swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
        count++;
    }
}
