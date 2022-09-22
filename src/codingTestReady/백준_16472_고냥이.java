package codingTestReady;

import java.util.*;

public class 백준_16472_고냥이 {
    static int n;
    static String str;
    static Queue<Character> list;
    static int max = 0;

    static void input() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        str = sc.next();
        list = new LinkedList<>();
    }

    static void pro() {
        int count = 0;
        for(int i=0; i<str.length(); i++){
            if(list.contains(str.charAt(i))) count +=1;
            else if(list.size() < n){
                list.add(str.charAt(i));
                count +=1;
            } else{
                list.clear();
                if(max < count) max = count;
                list.add(str.charAt(i));
                count = 1;
            }

        }
        if(count > max) max = count;
        System.out.println(max);
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}
