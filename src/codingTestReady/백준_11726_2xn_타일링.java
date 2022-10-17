package codingTestReady;

import java.util.Scanner;

public class 백준_11726_2xn_타일링 {
    static int n;
    static int[] arr;

    static void input(){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n+1];
    }

    static void preprocess(){
        arr[1] = 1;
        if(n <= 1) {
            System.out.println(1);
            return;
        }
        arr[2] = 2;
        if(n <= 2) {
            System.out.println(2);
            return;
        }

        for(int i=3; i<arr.length; i++){
            arr[i] = (arr[i-1] + arr[i-2]) % 10007;
        }
        System.out.println(arr[n]);
    }

    public static void main(String args[]){
        input();
        preprocess();
    }
}
