package fastcampus_java;

import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;


public class BOJ_1015_수열정렬 {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader rb = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static int[] p;
    static WithIndex[] a;

    static void input(){
        try {
            n = Integer.parseInt(rb.readLine());
            a = new WithIndex[n];
            p = new int[n];
            StringTokenizer st = new StringTokenizer(rb.readLine());
            for(int i=0; i<n; i++){
                a[i] = new WithIndex(i, Integer.parseInt(st.nextToken()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class WithIndex implements Comparable<WithIndex>{
        int index, num;

        WithIndex(int index, int num){
            this.index = index;
            this.num = num;
        }

        @Override
        public int compareTo(WithIndex o) {
            if(o == null) return 1;
            if(o.num != num) return num - o.num;
            return index - o.index;
        }
    }

    static void pro(){
        Arrays.sort(a);
        for(int b_index=0; b_index<n; b_index++){
            p[a[b_index].index] = b_index;
        }
        for(int i=0; i<n; i++){
            sb.append(p[i]).append(' ');
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        input();
        pro();
    }


}
