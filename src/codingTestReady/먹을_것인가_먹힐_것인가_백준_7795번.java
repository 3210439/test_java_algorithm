package codingTestReady;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 먹을_것인가_먹힐_것인가_백준_7795번 {

    static int N, M, testCase;
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] A, B;

    static int toInt(String str){
        return Integer.parseInt(str);
    }

    static void input() {
        try {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            A = new int[N+1];
            B = new int[M+1];

            st = new StringTokenizer(br.readLine());

            for(int i=1; i<N+1; i++){
                A[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i=1; i<M+1; i++){
                B[i] = Integer.parseInt(st.nextToken());
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static int lower_bound(int[] A, int L, int R, int X) {
        // A[L...R] 에서 x 미만의 수(X 보다 작은 수) 중 제일 오른쪽 인덱스를 return 하는 함수

        int result = L - 1;
        while (L <= R) {
            int mid = (L + R)/2;
            if (A[mid] < X){
                result = mid;
                L = mid + 1;
            }else if (A[mid] >= X){
                R = mid - 1;
            }
        }

        // 그런게 없다면 L - 1 을 return 한다
        return result;
    }

    static void pro() {
        // B 배열에 대해 이분탐색을 할 예정이니까, 정렬을 해주자!
        Arrays.sort(B, 1, M + 1);

        int ans = 0;
        for (int i = 1; i <= N; i++) {
            // A[i] 를 선택했을 때, B 에서는 A[i]보다 작은 게 몇 개나 있는 지 count 하기
            ans += lower_bound(B, 1, M, A[i]);
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        try {
            testCase = Integer.parseInt(br.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for(int i=1; i<testCase+1; i++){
            input();
            pro();
        }
    }
}
