package codingTestReady;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class 백준_1005_ACM_Craft {

    static int testcase, n, m, w;
    static ArrayList<Integer>[] adj;
    static int[] indeg, T_done, T;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    static void input() {
        // Testcase 가 조재하는 문제이므로 "배열 초기화"에 유의하자
        StringTokenizer st;
        try {
            st = new StringTokenizer(br.readLine());
            n =  parseInt(st.nextToken());
            m =  parseInt(st.nextToken());

            adj = new ArrayList[n+1];
            indeg = new int[n + 1];
            T = new int[n+1];
            T_done = new int[n+1];

            st = new StringTokenizer(br.readLine());
            for (int i=1; i<= n; i++){
                adj[i] = new ArrayList<>();
                T[i] = parseInt(st.nextToken());
            }

            for(int i=1; i<=m; i++) {
                st = new StringTokenizer(br.readLine());
                int x = parseInt(st.nextToken());
                int y = parseInt(st.nextToken());

                adj[x].add(y);
                indeg[y]++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void pro() {
        Deque<Integer> queue = new LinkedList<>();
        // 제일 앞에 "정렬될 수 있는" 정점 찾기
        for (int i = 1; i <= n; i++){
            if (indeg[i] == 0) {
                queue.add(i);
                T_done[i] = T[i];
            }
        }
        // 정렬될 수 있는 정점이 있다면?
        // 1. 정렬 결과에 추가하기
        // 2. 정점과 연결된 간선 제거하기
        // 3. 새롭게 "정렬 될 수 있는" 정점
        while (!queue.isEmpty()) {
            int x = queue.poll();
            for (int y : adj[x]) {
                indeg[y]--;
                if (indeg[y] == 0) queue.add(y);
                T_done[y] = Math.max(T_done[y], T_done[x] + T[y]);
            }
        }
        try {
            int W = parseInt(br.readLine());
            System.out.println(T_done[W]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            int Q = parseInt(br.readLine());
            while (Q > 0) {
                Q--;
                input();
                pro();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
