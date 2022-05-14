package solveByType.sort;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class organizeFile_20291_bak {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static void input(){
        N = scan.nextInt();
        files = new String[N+1];
        for(int i=1; i<=N; i++) files[i] = scan.nextLine();
        files[0] = "";
    }

    static int N;
    static String[] files;

    static void pro(){
        // 필요한 정수
        int count = 1;
        String now_str = files[1];

        for(int i=1; i<=N; i++) {
            files[i] = files[i].split("\\.")[1];
        }

        // 파일 정렬
        Arrays.sort(files,1, N+1);

        // 특정 파일이 몇개 있는지 개수 세기
        for(int i=2; i<=N; i++){
            if(files[i].equals(files[i-1])) {
                count++;
            } else{
                sb.append(files[i-1]).append(" "+count).append("\n");
                count = 1;
            }
        }
        if(count > 1 || files[N] != files[N-1]){
            sb.append(files[N]).append(" "+count).append("\n");
        }

        System.out.println(sb.toString());
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
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {return Integer.parseInt(next());}
        long nextLong() {return Long.parseLong(next());}
        double nextDouble() {return Double.parseDouble(next());}

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
