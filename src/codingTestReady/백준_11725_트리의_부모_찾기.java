package codingTestReady;

import java.util.ArrayList;
import java.util.Scanner;

//https://www.acmicpc.net/problem/11725
public class 백준_11725_트리의_부모_찾기 {

    static int n;
    static ArrayList<Integer>[] adj;
    static int[] parent;
    static StringBuilder sb = new StringBuilder();

    static void input() {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        adj = new ArrayList[n + 1];
        parent = new int[n + 1];
        for (int i=1; i<=n; i++) adj[i] = new ArrayList<>();
        for (int i = 1; i < n; i++){
            int x = scan.nextInt(), y = scan.nextInt();
            adj[x].add(y);
            adj[y].add(x);
        }
    }

    // dfs(x, par) := 정점 x 의 부모가 par 였고, x의 children들을 찾아주는 함수
    static void dfs(int x, int par) {
        for (int y: adj[x]){
            if (y == par) continue;
            parent[y] = x;
            dfs(y, x);
        }
    }

    static void pro() {
        // 1번 정점이 ROOT 이므로, 여기서 시작해서 Tree의 구조를 파악하자.
        dfs(1, -1);
        for (int i=2; i<=n; i++)
            sb.append(parent[i]).append('\n');
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}
