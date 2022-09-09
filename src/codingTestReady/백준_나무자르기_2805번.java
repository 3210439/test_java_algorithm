package codingTestReady;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_나무자르기_2805번 {

    static int n, m;
    static int[] a;
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static void input(){
        try {
            st =new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            a = new int[n+1];
            st =new StringTokenizer(br.readLine());

            for(int i=1; i<n+1; i++){
                a[i] = Integer.parseInt(st.nextToken());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static boolean determination(int H){
        // 높이 H로 잘랐을 때, M 만큼을 얻을 수 있으면 true, 없으면 false를 리턴하는 함
        long sum = 0;
        for(int i=1; i<n+1; i++){
            if(a[i] > H)
                sum += (a[i]-H);
        }
        return sum >= m;
    }

    static void pro(){
        long L = 0, R = 2000000000, ans = 0;
        // [L ... R] 범위 안에 정답이 존재한다!
        // 이분 탐색과 determination 문제를 이용해서 answer를 빠르게 구하자!
        while(L <= R) {
            int mid = (int) ((L + R) / 2);
            if (determination(mid)) {
                ans = mid;
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}
