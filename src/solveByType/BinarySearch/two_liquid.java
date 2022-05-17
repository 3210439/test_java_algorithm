package solveByType.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class two_liquid {
    static FastReader scan = new FastReader();
    static int N, ans;
    static int[] liquids;
    static StringBuilder sb = new StringBuilder();

    static void input(){
        N = scan.nextInt();
        liquids = new int[N+1];
        for (int i=1; i<=N; i++) liquids[i] = scan.nextInt();
    }

    static int lower_bound(int[] A, int L, int R, int X) {
        // A[L...R] 에서 X 이상의 수 중 제일 왼쪽 인덱스를 return 하는 함수
        // 그런 게 없다면 R + 1 을 return 한다.

        int res = R + 1; // 만약 A[L...R] 중
        while (L <= R) {
            int mid = (L + R) / 2;
            if (A[mid] >= X) {
                res = mid;
                R = mid - 1;
            } else{
                L = mid + 1;
            }
        }
        return res;
    }

    static void pro(){
        // A 에 대해 이분 탐색을 할 예정이니까, 정렬을 미리 해주자.
        Arrays.sort(liquids, 1, N + 1);

        int best_sum = Integer.MAX_VALUE;
        int v1 = 0, v2 = 0;
        for (int left=1; left <= N - 1; left++) {
            // A[left] 용액을 쓸 것이다. 고로 -A[left] 와 가장 가까운 요액을 자신의 올느쪽 구간에서 찾자.
            int candidate = lower_bound(liquids,left+1, N, -liquids[left]);

            // A[candidate - 1] 와 A[candidate] 중에 A[left] 와 섞었을 때의 정보를 정답에 갱신시킨다.

            // 1. A[left] + A[candidate - 1]
            if (left < candidate - 1 && Math.abs(liquids[left] + liquids[candidate - 1]) < best_sum) {
                best_sum = Math.abs(liquids[left] + liquids[candidate - 1]);
                v1 = liquids[left];
                v2 = liquids[candidate - 1];
            }

            // 2. A[left] + A[candidate]
            if (candidate <= N && Math.abs(liquids[left] + liquids[candidate]) < best_sum) {
                best_sum = Math.abs(liquids[left] + liquids[candidate]);
                v1 = liquids[left];
                v2 = liquids[candidate];
            }
        }
        sb.append(v1).append(' ').append(v2);
        System.out.println(sb);
    }

    public static void main(String[] args){
        input();
        pro();
    }

    static class FastReader{
        BufferedReader br;
        StringTokenizer st;

        public FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while(st == null || !st.hasMoreElements()){
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
