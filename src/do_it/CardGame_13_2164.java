package do_it;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CardGame_13_2164 {
    static int n;
    static Queue<Integer> cards;

    static void input(){
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        cards = new LinkedList<>();
        for (int i=1; i<=n; i++) cards.add(i);
    }
    static void pro() {
        while(cards.size()>1){
            cards.remove();
            if(cards.size()>1){
                cards.add(cards.remove());
            }
        }
        System.out.println(cards.remove());
    }

    public static void main(String[] args){
        input();
        pro();
    }
}
