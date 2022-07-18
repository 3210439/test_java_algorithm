package do_it.ch4;

import java.util.Scanner;

public class Fifteen_sort_number_2750 {


    public static void main(String[] args){
        /**
         * N(정렬할 수 개수)
         * A(정렬할 배열 선언)
         * for(i : 0 ~ N - 1)
         * {
         *      for(j : 0 ~ N - 1 - i)
         *      {
         *          현재 A 배열의 값보다 1칸 오른쪽 배열의 값이 더 작으면 두 수 바꾸기
         *      }
         * }
         * A 배열 출력
         */

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];

        for(int i=0; i<N; i++){
            A[i] = sc.nextInt();
        }

        for(int i=0; i<N-1; i++){
            for(int j=0; j<N-1-i; j++){
                // 현재 A 배열보다 값이 크면 swap 하기
                if(A[j] > A[j+1]){
                    int temp = A[j];
                    A[j] = A[j+1];
                    A[j+1] = temp;
                }
            }
        }
        for(int value : A){
            System.out.println(value);
        }
    }

}
