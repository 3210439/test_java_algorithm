package solveByType.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class arrowDrawing_15970_bak {
    static FastReader scan = new FastReader();
    static int N;
    static Elem[] points;

    static class Elem implements Comparable<Elem>{
        int l,c;
        @Override
        public int compareTo(Elem other){
            return l - other.l;
        }
    }

    static void input(){
        N = scan.nextInt();
        points = new Elem[N+1];
        for(int i=1; i<=N; i++){
            points[i] = new Elem();
            points[i].l = scan.nextInt();
            points[i].c = scan.nextInt();
        }
    }

    // 가장 가까운 점을 찾아야 한다.
    static int search(int nowIdx, Elem[] elems){
        int nearest = Integer.MAX_VALUE;
        for(int i = nowIdx+1; i<=N; i++){
            if(elems[nowIdx].c == elems[i].c) {
                nearest = elems[i].l - elems[nowIdx].l;
                break;
            }
        }
        for(int i = nowIdx-1; i>=1; i--){
            if(elems[nowIdx].c == elems[i].c){
                if(nearest > (elems[nowIdx].l - elems[i].l)){
                    nearest = elems[nowIdx].l - elems[i].l;
                }
                break;
            }
        }
        return nearest;
    }

    static void pro(){
        int total = 0;
        Arrays.sort(points,1, N+1);
        for(int i=1; i<=N; i++){
            total += search(i, points);
        }
        System.out.println(total);
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

        String next(){
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
