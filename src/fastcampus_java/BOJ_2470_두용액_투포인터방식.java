package fastcampus_java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;
import static java.util.Arrays.sort;

public class BOJ_2470_두용액_투포인터방식 {

    static int n;
    static int[] a;

    static void input(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            n = parseInt(br.readLine());
            a = new int[n+1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=1; i<=n; i++){
                a[i] = parseInt(st.nextToken());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void pro() {
        sort(a,1, n+1);
        int L = 1;
        int R = n;
        int min = Integer.MAX_VALUE;
        int v1 = 0, v2 = 0;

        while(L < R){
            int temp = a[R] + a[L];
            if(Math.abs(temp) < min){
               min = Math.abs(temp);
               v1 = a[L];
               v2 = a[R];
               if(temp == 0) break;
            }

            if( temp < 0) L +=1;
            else R -=1;

        }
        System.out.println(v1 + " "+v2);
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}
