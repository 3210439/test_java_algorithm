package fastcampus_java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class BOJ_1253J_좋다 {

    static StringBuilder sb = new StringBuilder();
    static int n;
    static int[] arr;

    static void input(){
        BufferedReader sb = new BufferedReader(new InputStreamReader(System.in));
        try {
            n = parseInt(sb.readLine());
            arr = new int[n+1];
            StringTokenizer st = new StringTokenizer(sb.readLine());


            for(int i=1; i<n+1; i++){
                arr[i] = parseInt(st.nextToken());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // traget_idx 번째 원소가 서로 다른 두 수의 합으로 표현이 되는가?
    static boolean func(int target_idx) {
        int L = 1, R = n;
        int target = arr[target_idx];
        while ( L < R) {

            if(L == target_idx) L++;
            else if(R == target_idx) R--;
            else {
                int sum = arr[L] + arr[R];
                if (sum == target) return true;
                else if (sum > target) --R;
                else ++L;
            }
        }

        return false;
    }

    static void pro() {
        // 최소, 최대를 빠르게 알기 위한 정렬
        Arrays.sort(arr,1,n+1);
        int ans = 0;
        for (int i=1; i<=n; i++) {
            if(func(i)){
                ++ans;
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        input();
        pro();
    }

}
