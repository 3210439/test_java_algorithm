package codingTestReady;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 카드_백준_11652번_실패 {

    static int n = 0;
    static List<Card> list;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static void input(){
        try {
            n = toInt(br.readLine());
            list  = new ArrayList<Card>();
            for(int i=1; i<n+1; i++){
                long temp = toLong(br.readLine());
                if(!findNum(temp)){
                    list.add(new Card(temp));
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static boolean findNum(long num){
        boolean exist = false;
        for(Card value : list){
            if(value.num == num){
                value.count += 1;
                exist = true;
                break;
            }
        }
        return exist;
    }

    static void pro(){
        Collections.sort(list);
        System.out.println(list.get(0).count);
    }

    public static void main(String[] args) {
        input();
        pro();
    }


    static int toInt(String str){
        return Integer.parseInt(str);
    }

    static long toLong(String str){
        return Long.parseLong(str);
    }

    static class Card implements Comparable<Card>{
        int count;
        long num;

        Card(long num){
            this.count = 1;
            this.num = num;
        }

        @Override
        public int compareTo(Card o) {
            if(o.count != count) return o.count - count;
            return (int) (num - o.num);
        }
    }


}
