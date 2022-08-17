package codingTestReady;

import java.io.*;
import java.util.Scanner;

public class 백준4375번1 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        while(sc.hasNextLong()){
            int n = sc.nextInt();
            int count = 1;
            long now = 1L;
            while(true){
                if(now % n == 0L) break;
                now = now*10 + 1;
                count += 1;
            }
            System.out.println(count);
        }
    }

}
