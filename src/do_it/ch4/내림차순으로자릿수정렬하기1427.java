package do_it.ch4;

import java.util.Scanner;

public class 내림차순으로자릿수정렬하기1427 {
    public static void main(String[] args) {
        /**
         * 슈도코드
         * str(정렬할 수)
         * A(str 길이만한 배열)
         * for(str의 길이만큼 반복하기) {
         *  A 배열 저장 -> str.substring 사용하기
         * }
         * for(i: 0~str의 길이만큼 반복하기) {
         *  for(j: i + 1 ~ str의 길이만큼 반복하기) {
         *      현재 범위에서 Max값 찾기
         *  }
         *  현재 i의 값과 Max값 중 Max값이 더 크면 swap 수행하기
         *  }
         *  A 배열 출력하기
         */

        Scanner sc = new Scanner(System.in);

        // 정렬할 수
        String str = sc.next();
        // A (str 길이만한 배열)
        int[] A = new int[str.length()];
        for(int i=0; i<str.length(); i++){
            A[i] = Integer.parseInt(str.substring(i,i+1));
        }

        for(int i=0; i<str.length(); i++){
            int max = i;
            for (int j=i+1; j<str.length(); j++){
                // 현재 범위에서 Max값 찾기
                if(A[max] < A[j]) max = j;
            }
            if(A[max] > A[i]) {
                int temp = A[max];
                A[max] = A[i];
                A[i] = temp;
            }
        }
        for(int num: A){
            System.out.print(num);
        }

    }
}
