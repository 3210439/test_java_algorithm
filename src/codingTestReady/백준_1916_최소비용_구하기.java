package codingTestReady;


import KRUSKAL.Edge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class 백준_1916_최소비용_구하기 {

    static int N, M, start, end;
    static int[] dist;
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Edge>[] edges;

    static class Edge {
        public int to, weight;

        public Edge(int _to, int _weight) {
            this.to = _to;
            this.weight = _weight;
        }
    }


    private static class Info {
        int dist, idx;

        public Info() {

        }

        Info(int idx, int dist) {
            this.dist = dist;
            this.idx = idx;
        }
    }

    static void input(){
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            N = parseInt(br.readLine());
            M = parseInt(br.readLine());
            for(int i=0; i<M; i++){
                st = new StringTokenizer(br.readLine());
                int from = parseInt(st.nextToken());
                int to = parseInt(st.nextToken());
                int weight = parseInt(st.nextToken());
                edges[from].add(new Edge(to, weight));
            }
            start = parseInt(br.readLine());
            end = parseInt(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    static void dijkstra(int start) {
        // 모든 정점까지에 대한 거리를 무한대로 초기화 해주기.
        for (int i=1; i<=N; i++) dist[i] = Integer.MAX_VALUE;

        // 최소 힙 생성
        PriorityQueue<Info> pq = new PriorityQueue<Info>(Comparator.comparing(o -> o.dist));

        // 시작점에 대한 정보(Information)을 기록에 추가하고, 거리 배열(dist)에 갱신해주다.
        pq.add(new Info(start, 0));
        dist[start] = 0;

        // 거리 정보들이 모두 소진될 때까지 거리 갱신을 반복한다.
        while (!pq.isEmpty()){
            Info info = pq.poll();
            if (dist[info.idx] < info.dist) continue;
            for (Edge e: edges[info.idx]){
                if (dist[info.idx] + e.weight >= dist[e.to]) continue;

                dist[e.to] = dist[info.idx] + e.weight;
                pq.add(new Info(e.to, dist[e.to]));
            }
        }
    }

    static void pro() {
        dijkstra(start);
        System.out.print(dist[end]);
    }

    public static void main(String[] args) {
        input();
        pro();
    }

}
