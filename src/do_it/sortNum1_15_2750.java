package do_it;

import java.util.Scanner;

public class sortNum1_15_2750 {
    static int n;
    static int a[];
    static StringBuilder sb = new StringBuilder();

    static void input() {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        a = new int[n+1];
        for(int i=1; i<=n; i++) a[i] = scan.nextInt();
    }

    static void bubble() {
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n-i; j++){
                if(a[j] > a[j+1]) {
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
        for(int i=1; i<=n; i++){
            sb.append(a[i]).append("\n");
        }
        System.out.println(sb);
    }

    static public void main(String[] args){
        input();
        bubble();
    }
}
