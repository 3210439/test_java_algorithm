package do_it.ch4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class K번째수구하기 {
    public static void main(String args[]) throws IOException {
        /**
         *  N(숫자의 개수) K(K번째 수)
         *  A(숫자 데이터 저장 배열)
         *  for(N만큼 반복하기) {
         *  A 배열 저장하기
         *  }
         *  퀵 소트 실행하기
         *  K번째 데이터 출력하기
         *
         *  [별도의 함수 구현 부분]
         *  퀵 소트 함수(시작, 종료, K)
         *  {
         *      피벗 구하기 함수(시작, 종료)
         *      if(피벗 == k) 종료
         *      else if(K < 피벗) 퀵 소트 수행하기(시작, 피벗 - 1, K)
         *  }
         *  피벗 구하기 함수(시작, 종료)
         *  {
         *      중앙값을 피벗으로 설정하기
         *      i(시작점), j(종료점)
         *      while(i < j)
         *      {
         *          피벗보다 큰 수가 나올 때까지 i++
         *          피벗보다 작은 수가 나올 때까지 j--
         *          찾은 i와 j 데이터를 swap
         *      }
         *      피벗 데이터를 나눠진 두 그룹의 경계 index에 저장하기
         */

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(in.readLine());
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        quickSort(A, 0, N - 1, K - 1);
        System.out.println(A[K - 1]);
    }

    public static void quickSort(int[] A, int S, int E, int K) {
        if (S < E) {
            int pivot = partition(A, S, E);
            if (pivot == K)         // K번째 수가 pivot이면 더이상 구할 필요 없음
                return;
            else if (K < pivot)     // K가 pivot보다 작으면 왼쪽 그룹만 정렬 수행하기
                quickSort(A, S, pivot - 1, K);
            else
                quickSort(A, pivot + 1, E, K);
        }
    }

    public static int partition(int[] A, int S, int E) {
        int M = (S + E) / 2;
        swap(A, S, M);          // 중앙값을 1번째 요소로 이동하기
        int pivot = A[S];
        int i = S, j = E;
        while (i < j) {
            while(pivot < A[j]){    // 피벗보다 작은 수가 나올 때까지 j--
                j--;
            }

            while (i < j && pivot >= A[i]){     // 피벗보다 큰 수가 나올 때까지 i++
                i++;
            }
            swap(A, i, j);
        }
        // i==j 피벗의 값을 양쪽으로 분리한 가운데에 오도록 설정하기
        A[S] = A[i];
        A[i] = pivot;
        return i;
    }
    public static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
