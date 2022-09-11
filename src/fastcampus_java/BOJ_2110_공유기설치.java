package fastcampus_java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2110_공유기설치 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n,c;
    static int[] a;

    static void input() {
        try {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            a = new int[n+1];

            for(int i=1; i<n+1; i++){
                a[i] = Integer.parseInt(br.readLine());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void pro() {
        Arrays.sort(a,1,n+1);
        int l = 0;
        int r = 1000000000;
        int ans = 0;
        while(l <= r){
            int mid = (l+r)/2;
            if(determination(mid)){
                ans = mid;
                l = mid+1;
            }else{
                r = mid-1;
            }
        }
        System.out.println(ans);
    }

    private static boolean determination(int mid) {
        // todo: 가능한가 아닌가?
        int count = 1;
        long now = mid+a[1];


        for(int i=2; i < n+1; i++){
            if(a[i] >= now){
                count +=1;
                now = a[i]+mid;
            }
        }

        return count>=c;
    }

    public static void main(String[] args) {
        input();
        pro();
    }

}
