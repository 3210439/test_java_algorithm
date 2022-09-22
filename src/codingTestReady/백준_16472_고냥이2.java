package codingTestReady;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 백준_16472_고냥이2 {
    static int n;
    static String str;
    static int max = 0;
    static int[] cnt;
    static int kind;

    static void input() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        str = sc.next();
        cnt = new int[26];
    }

    static void add(char x) {
        cnt[x-'a']++;
        if(cnt[x-'a'] == 0) kind --;
    }

    static void erase(char x) {
        cnt[x-'a']--;
        if(cnt[x-'a'] == 0) kind --;
    }

    static void pro() {
        int len = str.length(), ans = 0;
        for (int R = 0, L = 0; R < len; R++) {
            // R 번째 문자를 오른쪽에 추가
            add(str.charAt(R));

            // 불가능하면, 가능할 때까지 L을 이동
            while(true){
                kind = 0;
                for(int i=0; i<cnt.length; i++){
                    if (cnt[i] > 0) {
                        kind++;
                    }
                }
                if(kind > n){
                    erase(str.charAt(L++));
                }else{
                    break;
                }
            }
            // 정답 갱신
            ans = Math.max(ans, R - L + 1);

        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}
