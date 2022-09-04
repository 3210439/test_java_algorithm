package codingTestReady;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 화살표_그리기_백준_15970 {

    static int n;
    static Point[] a;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static class Point implements Comparable<Point>{
        int index, color;

        Point(int index, int color){
            this.index = index;
            this.color = color;
        }

        @Override
        public int compareTo( Point o) {
            if(color != o.color) return color - o.color;
            return index - o.index;
        }
    }

    static void input() {
        try {

            n = Integer.parseInt(br.readLine());
            a = new Point[n + 1];
            for (int i=1; i<n+1; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int coord = Integer.parseInt(st.nextToken());
                int color = Integer.parseInt(st.nextToken());
                Point point = new Point(coord, color);
                a[i] = point;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static void pro() {
        // TODO: 색깔별로 정렬하기
        Arrays.sort(a,1,n+1);
        int ans = 0;

        for (int i = 1; i <=n; i++) {
            // TODO: 색깔 별로, 각 점마다 가장 가까운 점 찾아주기
            if( i == n){
                ans += a[i].index - a[i-1].index;
                break;
            }
            if(i > 1){
                if(a[i-1].color == a[i].color){
                    if(a[i+1].color == a[i].color){
                     if((a[i].index - a[i-1].index)>(a[i+1].index - a[i].index)){
                         ans += a[i+1].index - a[i].index;
                     }else{
                         ans += a[i].index - a[i-1].index;
                     }
                    }else{
                        ans += a[i].index - a[i-1].index;
                    }
                }else{
                    ans += a[i+1].index - a[i].index;
                }
            }else{
                ans += a[i+1].index - a[i].index;
            }
        }

        // 정답 출력하기
        System.out.println(ans);
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}
