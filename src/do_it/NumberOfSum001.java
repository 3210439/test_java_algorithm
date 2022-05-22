package do_it;

import java.util.Scanner;

public class NumberOfSum001 {
    static Scanner scan = new Scanner(System.in);
    static long N=0, sum=0;
    static String numStr;

    static void input(){
        N = Long.parseLong(scan.nextLine());
        numStr = scan.nextLine();
    }

    static void pro(){
        for(int i=0; i<N; i++){
            sum += Integer.parseInt(String.valueOf(numStr.charAt(i)));
        }
        System.out.println(sum);
    }

    static public void main(String[] args) {
        input();
        pro();
    }
}
