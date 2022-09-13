package fastcampus_java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13144_ListOfUniqueNumbers {

    static int[] a;
    static int[] cnt;
    static int n;

    static void input() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            n = Integer.parseInt(br.readLine());
            a = new int[n+1];
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int i=1; i<n+1; i++){
                a[i] = Integer.parseInt(st.nextToken());
            }
            cnt = new int[100000 + 1];

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void pro() {
        long ans = 0;

        for (int L=1, R=0; L<=n; L++){  // L 마다 R을 최대한 옮김
            // R 을 옮길 수 있는 만큼 옮긴다.
            while (R + 1 <= n && cnt[a[R + 1]] == 0) {
                R++;
                cnt[a[R]]++;
            }

            // 정답을 갱신한다.
            ans += R - L + 1;

            // L 을 옮겨주면서 A[L] 의 개수를 감소시킨다.
            cnt[a[L]]--;
        }

        System.out.println(ans);
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}
