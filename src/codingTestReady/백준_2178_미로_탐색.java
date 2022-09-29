package codingTestReady;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

// 메모리 초과 문제
public class 백준_2178_미로_탐색 {
    static int n, m;
    static int[][] arr;
    static int count;
    static boolean[][] visit;
    static int[][] dir = {{-1, 0}, {0,1}, {1,0}, {0, -1}};
    static Queue<Integer> q = new LinkedList<>();

    static void input(){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n+1][m+1];
        visit = new boolean[n+1][m+1];

        for(int i=1; i<=n; i++){
            String str = sc.nextLine();
            if(str.equals("")) str = sc.nextLine();
            for(int j=1; j<=m; j++){
                arr[i][j] = parseInt(String.valueOf(str.charAt(j-1)));
            }
        }
    }

    static void bfs(){
        // x, y 순으로 q에 넣는다.
        q.add(1);
        q.add(1);

        while(!q.isEmpty()) {
            int x = q.poll();
            int y = q.poll();
            visit[x][y] = true;

            for (int i = 1; i <= 4; i++) {
                int nx = x + dir[i-1][1];
                int ny = y + dir[i-1][0];
                if (1>nx || nx > n || 1>ny || ny>m) continue;
                if (visit[nx][ny] == true) continue;
                if (arr[nx][ny] == 0) continue;
                q.add(nx);
                q.add(ny);
                arr[nx][ny] = arr[x][y] + 1;
            }
        }
    }

    static void pro() {
        int ans =0;
        bfs();
        System.out.println(arr[n][m]);
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}
