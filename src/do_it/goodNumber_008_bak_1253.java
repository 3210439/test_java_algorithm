package do_it;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class goodNumber_008_bak_1253 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);
        int count = 0;
        for(int k=1; k<=N; k++) {
            long find = A[k];
            int i=1, j=N;
            while(i < j){
                if(find == (A[i]+A[j])){
                    if(k != i && k != j) {
                        count++;
                        i++;
                        j--;
                        break;
                    }
                    else if(i == k){
                        i++;
                    }
                    else if(j == k){
                        j--;
                    }
                } else if(k > (A[i]+A[j])){
                    i++;
                } else{
                    j--;
                }
            }
        }
        System.out.println(count);
    }
}
