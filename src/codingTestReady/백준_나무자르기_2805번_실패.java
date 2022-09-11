package codingTestReady;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준_나무자르기_2805번_실패 {

    static int n, m;
    static StringTokenizer st;
    static BufferedReader br;
    static int[] a;

    static void input() {
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            a = new int[n+1];
            st = new StringTokenizer(br.readLine());

            for(int i=1; i<n+1; i++){
                a[i] = Integer.parseInt(st.nextToken());
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static void pro() {
        int ans = 0;
        // todo: 정렬하기
        Arrays.sort(a, 1, n+1);
        // todo: 이분 탐색하기
        ans = binary_search(1, n, m);
        // todo: 최대 높이값 반환
        System.out.println(ans);
    }

    static int binary_search(int l, int r, int x){
        int result = l-1;

        while(l <= r){

            int mid = (l+r)/2;

            if(totalHeight(mid) < x){
                r = mid - 1;
            }else{
                result = a[mid];
                l = mid + 1;
            }
        }

        return result;
    }

    private static int totalHeight(int mid) {

        int total = 0;

        for(int i=mid; i<n+1; i++){
            total += (a[i]-m);
        }

        return total;
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}
