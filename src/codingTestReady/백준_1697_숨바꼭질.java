package codingTestReady;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 백준_1697_숨바꼭질 {
    static int n, k;
    static int ans = Integer.MAX_VALUE;
    static int[] arr = new int[100001];
    static int[] dist = new int[100001];
    static boolean[] visit = new boolean[100001];

    static void input(){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
    }

    static void bfs(){
        int count = 0;
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(n);
        visit[n] = true;
        dist[n] = 0;

        while(!q.isEmpty()){
            int x = q.poll();

            for(int i=0; i<3; i++) {
                int next;

                switch (i) {
                    case 0:
                        next = x - 1;
                        break;
                    case 1:
                        next = x + 1;
                        break;
                    default:
                        next = 2 * x;
                        break;
                    }

                if (next < 0 || next >= arr.length) continue;
                if (visit[next]) continue;
                dist[next] = dist[x] + 1;
                visit[next] = true;
                q.add(next);
            }
        }
    }

    public static void main(String[] args) {
        input();
        bfs();
        System.out.println(dist[k]);
    }
}
