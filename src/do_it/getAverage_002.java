package do_it;

import java.util.Scanner;

public class getAverage_002 {
    static int N;
    static double ans;
    static int[] subjects;
    static int imax = Integer.MIN_VALUE;
    // 백준 1546번
    static void input(){
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        subjects = new int[N+1];
        for(int i=1; i<=N; i++){
            subjects[i] = scan.nextInt();
        }
        ans = 0;
        for (int i=1; i<=N; i++) imax = Integer.max(subjects[i], imax);
    }

    static void pro(){
        for(int i=1; i<=N; i++){
            ans += (((double)subjects[i]/(double)imax) * (double)100);
        }
        ans /= N;
        System.out.println(ans);
    }

    static public void main(String args[]){
        input();
        pro();
    }
}
