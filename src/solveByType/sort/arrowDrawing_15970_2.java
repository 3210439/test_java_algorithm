package solveByType.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class arrowDrawing_15970_2 {
    static int N;
    static FastReader scan = new FastReader();
    static ArrayList<Integer>[] a;

    static void input() {
        N = scan.nextInt();
        a = new ArrayList[N +1];
        for (int color = 1; color <= N; color++) {
            a[color] = new ArrayList<Integer>();
        }
        for (int i = 1; i <= N; i++) {
            int coord, color;
            coord = scan.nextInt();
            color = scan.nextInt();
            // TODO: color 인 색깔의 점이 coord 에 놓여 있음
            a[color].add(coord);
        }
    }

    static int toLeft(int color, int idx) {
        // TODO
        // 색깔이 color 인 점의 idx 번째에 있는 점이 왼쪽으로 화살표를 그린다면
        // 화살표의 길이를 return 하는 함수. 왼쪽에 점이 없다면 무한대를 return.
        if (idx == 0) return Integer.MAX_VALUE;
        return a[color].get(idx) - a[color].get(idx - 1);
    }

    static int toRight(int color, int idx) {
        // TODO
        // 색깔이 color 인 점의 idx 번째에 있는 점이 오른쪽으로 화살표를 그린다면
        // 화살표의 길이를 return 하는 함수. 오른쪽에 점이 없다면 무한대를 return.
        if (idx == N) return Integer.MAX_VALUE;
        return a[color].get(idx + 1) - a[color].get(idx);
    }

    public static void main(String[] args){
        input();
        pro();
    }

    static void pro() {
        // TODO: 색깔별로 정렬하기
        for (int color = 1; color <= N; color++){
            Collections.sort(a[color]);
        }

        int ans = 0;
        for (int color = 1; color <= N; color++) {
            // TODO: 색깔 별로, 각 점마다 가장 가까운 점 찾아주기
            for (int i=0; i<a[color].size(); i++) {
                int toLeft = toLeft(color, i); // 왼쪽 점 까지의 거리
                int toRight = toRight(color, i); // 오른쪽 점 까지의 거리
            }
        }
        // 정답 출력하기
    }


    static class FastReader {
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

        public int nextInt() { return Integer.parseInt(next());}
        public long nextLong() {return Long.parseLong(next());}

    }

}
