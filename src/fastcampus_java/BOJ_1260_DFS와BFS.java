package fastcampus_java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.Integer.parseInt;

public class BOJ_1260_DFS와BFS {

    static int n, m, v;
    static boolean[] visited_dfs;
    static boolean[] visited_bfs;
    static StringBuilder sb = new StringBuilder();
    static List<Integer>[] list;

    static void input(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = parseInt(st.nextToken());
            m = parseInt(st.nextToken());
            v = parseInt(st.nextToken());
            list = new ArrayList[n +1];
            visited_dfs = new boolean[n+1];
            visited_bfs = new boolean[n+1];

            for(int i=1; i<n+1; i++){
                list[i] = new ArrayList<Integer>();
            }

            for(int i=0; i<m; i++){
                st = new StringTokenizer(br.readLine());
                int x = parseInt(st.nextToken());
                int y = parseInt(st.nextToken());
                list[x].add(y);
                // 양방향이므로 y에서 x로도 더해주어야 한다.
                list[y].add(x);

            }
            for(int i=1; i<n+1; i++){
                Collections.sort(list[i]);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void bfs(int x){
        sb.append("\n");
        visited_bfs[x] = true;
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(x);

        while(!q.isEmpty()){
            int z = q.poll();
            sb.append(z).append(" ");

            // x에 연결된 다른 노드로 방문한다.
            for(int y : list[z]){
                if(visited_bfs[y] == false){
                    // visit 의 값이 true 라는 것을 여기서 넣어주어야한다.
                    visited_bfs[y] = true;
                    q.add(y);
                }
            }

        }
    }

    static void dfs(int x){
        // x를 방문 하였다.
        visited_dfs[x] = true;
        sb.append(x).append(" ");

        //x에 연결된 다른 노드들로 방문한다.
        for(int y : list[x]){
            if(visited_dfs[y] == false){
                dfs(y);
            }
        }
    }

    public static void main(String[] args) {
        input();
        dfs(v);
        bfs(v);
        System.out.println(sb);
    }
}
