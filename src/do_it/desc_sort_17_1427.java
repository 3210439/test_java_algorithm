package do_it;

import java.util.Scanner;

public class desc_sort_17_1427 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        StringBuilder sb = new StringBuilder();
        int[] A = new int[str.length()];
        for(int i = 0; i<str.length(); i++) A[i] = Integer.parseInt(str.substring(i,i+1));

        for(int i = 0; i<A.length-1; i++){
            int max = i;
            for(int j = i+1; j<A.length; j++){
                if(A[max] < A[j]) max = j;
            }
            if(A[i] < A[max]){
                int temp = A[i];
                A[i] = A[max];
                A[max] = temp;
            }
            sb.append(A[i]);
        }
        sb.append(A[A.length-1]);
        System.out.println(sb);
    }
}
