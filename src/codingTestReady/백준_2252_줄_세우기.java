package codingTestReady;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.Integer.parseInt;

public class 백준_2252_줄_세우기 {
    static int n, m;
    static StringBuilder sb = new StringBuilder();
    static int[] indeg;
    static ArrayList<Integer>[] arrayLists;

    static void input(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        try {
            st = new StringTokenizer(br.readLine());
            n  = parseInt(st.nextToken());
            m  = parseInt(st.nextToken());
            indeg = new int[n+1];
            arrayLists = new ArrayList[n+1];
            for(int i=1; i<=n; i++) arrayLists[i] = new ArrayList<>();
            for(int i=1; i<=m; i++){
                st = new StringTokenizer(br.readLine());
                int x = parseInt(st.nextToken());
                int y = parseInt(st.nextToken());

                indeg[y]++;
                arrayLists[x].add(y);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static void bfs(){
        Queue<Integer> q = new LinkedList<>();
        for(int i=1; i<=n; i++) {
            if(indeg[i] == 0) q.add(i);
        }

        while(!q.isEmpty()){
            Integer poll = q.poll();
            sb.append(poll).append(' ');

            for(int y : arrayLists[poll]){
                indeg[y] -= 1;
                if(indeg[y] == 0) q.add(y);
            }
        }
    }

    public static void main(String[] args) {
        input();
        bfs();
        System.out.println(sb.toString());
    }


}
