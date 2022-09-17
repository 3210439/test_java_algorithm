package codingTestReady;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;
import static java.util.Arrays.sort;

public class 백준_2470_두용액 {

    static int N;
    static int[] A;

    static void input() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            N = parseInt(br.readLine());
            A = new int[N+1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=1; i<N+1; i++){
                A[i] = parseInt(st.nextToken());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // target_idx 번째 원소가 서로 다른 두 수의 합으로 표현이 되는가?
    static boolean func(int target_idx) {
        int L = 1, R = N;
        int target = A[target_idx];
        while(L < R) {
            if(L == target_idx) L++;
            else if (R == target_idx) R--;
            else {
                if (A[L] + A[R] == target) return true;
                if (A[L] + A[R] > target) R--;
                else L++;
            }
        }
        return false;
    }

    static void pro() {
        // 최소, 최대를 빠르게 알기 위한 정렬
        sort(A,1,N+1);

        int ans = 0;
        for (int i = 1; i <= N; i++) {
            // i 번째 원소가 서로 다른 두 수의 합으로 표현이 되는가?
            if (func(i)) ans++;
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}
