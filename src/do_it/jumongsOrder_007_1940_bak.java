package do_it;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class jumongsOrder_007_1940_bak {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] A = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i<=N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);
        int count = 0;
        int i = 1, j = N;
        while (i < j) { // 투 포인터 이동 원칙에 따라 포인터를 이동하며 처리
            if(M == (A[i] + A[j])){
                count ++;
                i++;
                j--;
            } else if(M > (A[i]+A[j])){
                i++;
            }
            else{
                j--;
            }
        }
        System.out.println(count);
        br.close();
    }
}
