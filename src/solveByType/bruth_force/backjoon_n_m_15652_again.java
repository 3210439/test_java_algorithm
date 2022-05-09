package solveByType.bruth_force;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class backjoon_n_m_15652_again {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        selected = new int[N+1];
    }

    static int N, M, ans;
    static int[] selected;

    static void rec_func(int k){
        int start = selected[k-1];
        if (start == 0) start = 1;

        if(k == M+1){
            for (int i=1; i <= M; i++) sb.append(selected[i]).append(' ');
            sb.append('\n');
        } else {
            for(int cand = start; cand <= N; cand++ ){
                selected[k] = cand;
                rec_func(k+1);
                selected[k] = 0;
            }
        }
    }

    public static void main(String[] args) {
        input();
        rec_func(1);
        System.out.println(sb.toString());
    }


    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() { br = new BufferedReader(new InputStreamReader(System.in));}

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() { return Integer.parseInt(next());}

        long nextLong() { return Long.parseLong(next());}

        double nextDouble() { return Double.parseDouble(next());}

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
