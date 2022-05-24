package do_it;

import java.util.Scanner;

public class two_pointer_006_bak_2018 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int start_index = 1, end_index = 1, count = 1, sum = 1;

        while(end_index != N){
            if(sum == N){
                end_index++;
                count ++;
                sum += end_index;
            } else if (sum > N) {
                sum -= start_index;
                start_index++;
            } else {
                end_index++;
                sum += end_index;
            }
        }
        System.out.println(count);
    }
}
