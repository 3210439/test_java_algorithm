package do_it.ch4;

import java.util.Arrays;
import java.util.Scanner;

public class bubbleSort1377 {
    public static void main(String args[]){
        /**
         * 슈도코드
         * N(데이터 개수) A(데이터 배열, 단 클래스를 데이터로 담는 배열)
         * for(N만큼 반복하기)
         * {
         *  A 배열 저장하기
         * }
         * 배열 정렬하기
         * for(N만큼 반복하기)
         * {
         *      A[i]의 정렬 전 index - A[i]의 정렬 후 index 계산의 최댓값을 찾아 저장하기
         * }
         * 최댓값 + 1 을 정답으로 출력하기
         *
         * 별도 클래스 선언하기
         * mData(데이터 표현)
         * {
         *      int index;
         *      int value;
         *      mData(int index, int value){
         *          this.index = index;
         *          this.value = value;
         *      }
         *      value 기준 오름차순 정렬 함수  Comparable 구현하기
         */

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        mData[] A = new mData[N];

        for(int i= 0; i < N; i++){
            int value = sc.nextInt();
            A[i] = new mData(i, value);
        }
        Arrays.sort(A);
        int max = 0;

        for(int i=0; i<N; i++){

            System.out.println(A[i].index+" : "+A[i].value);
            if(max < A[i].index - i) max = A[i].index - i;
        }
        System.out.println(max + 1);

    }

    static class mData implements Comparable<mData> {

        private int index;
        private int value;

        mData(int index, int value){
            this.index = index;
            this.value = value;
        }

        @Override
        public int compareTo(mData o) {
            return this.value - o.value;
        }
    }
}
