package codingTestReady;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 카드_백준_11652 {

    static int n;
    static long[] a;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static void input(){
        try {
            n = toInt(br.readLine());
            a = new long[n+1];
            for(int i=1; i<n+1; i++){
                a[i] = toLong(br.readLine());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static int toInt(String str){
        return Integer.parseInt(str);
    }

    static long toLong(String str) {
        return Long.parseLong(str);
    }


    static void pro() {
        // Sort 정렬하기
        Arrays.sort(a,1,n+1);

        long mode = a[1];
        int modeCnt = 1, curCnt = 1;

        // mode: 최빈값, modeCnt: 최빈값의 등장 횟수, curCnt: 현재 값(a[i])의 등장 횟수
        for(int i=1; i<n; i++){
            int seq = 0;
            if(a[i] == a[i+1]){
                curCnt +=1;
            }
            else{
                curCnt = 1;
            }
            if(modeCnt<curCnt){
                mode = a[i];
                modeCnt = curCnt;
            }
        }
        System.out.println(mode);

    }

    public static void main(String[] args) {
        input();
        pro();
    }
}
