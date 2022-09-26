package codingTestReady;

import java.util.Scanner;

public class 백준_14502_연구소 {

    static int n,m;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int count = 0;
    static int zeroCount = 0;
    static int max = Integer.MIN_VALUE;
    static int[][] arr;
    static boolean[][] visit;

    static void input(){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[n][m];
        visit = new boolean[n][m];

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                arr[i][j] = sc.nextInt();
                if(arr[i][j] == 0) zeroCount +=1;
            }
        }
        zeroCount -= 3;
    }

    static void dfs(int x, int y){
        visit[x][y] = true;

        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if((0<= nx && nx < n) && (0 <= ny && ny < m)){
                if(visit[nx][ny] == false){
                    if(arr[nx][ny] == 0)  {
                        count += 1;
                        dfs(nx,ny);
                    }
                }
            }
        }
    }

    static void bruth(int k){

        if(k == 3){
            for(int i=0; i < n; i++){
                for(int j=0; j<m; j++){
                    if(arr[i][j] == 2) dfs(i,j);
                }
            }
            if((zeroCount - count) > max) max = zeroCount - count;
            visit = new boolean[n][m];
            count = 0;
        }
        else {
            for (int i = 0; i < n; i++) {
                for(int j = 0; j<m; j++){
                    if(arr[i][j] == 0) {
                        arr[i][j] = 1;
                        bruth(k + 1);
                        arr[i][j] = 0;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        input();
        bruth(0);
        System.out.println(max);
    }
}
