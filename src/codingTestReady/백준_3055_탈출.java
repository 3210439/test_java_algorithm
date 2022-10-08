package codingTestReady;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class 백준_3055_탈출 {
    static int R, C;
    static char[][] arr;
    static int[][] dist_water;
    static int[][] dist_gosu;
    static boolean[][] visit_water;
    static boolean[][] visit_gosu;
    static int[][] dir = {{-1,0}, {0,1}, {1,0}, {0,-1}};

    static void input() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            StringTokenizer st = new StringTokenizer(br.readLine());
            R = parseInt(st.nextToken());
            C = parseInt(st.nextToken());
            arr = new char[R+1][C+1];
            dist_water = new int[R+1][C+1];
            dist_gosu = new int[R+1][C+1];
            visit_water = new boolean[R+1][C+1];
            visit_gosu = new boolean[R+1][C+1];
            for(int i=1; i<=R; i++){
                String str = br.readLine();
                for(int j=1; j<=C; j++){
                    arr[i][j] = str.charAt(j-1);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void bfs_water() {
        Queue<Integer> q = new LinkedList<>();

        for(int i=1; i<=R; i++){
            for(int j=1; j<=C; j++){
                dist_water[i][j] = -1;
                if(arr[i][j] == '*'){
                    q.add(i);
                    q.add(j);
                    dist_water[i][j] = 0;
                    visit_water[i][j] = true;

                }
            }
        }

        while(!q.isEmpty()){
            int x = q.poll();
            int y = q.poll();

            for(int i=1; i<=4; i++){
                int nx = x + dir[i-1][0];
                int ny = y + dir[i-1][1];
                if( 1> nx || 1 > ny || R<nx || C<ny) continue;
                if(arr[nx][ny] != '.') continue;
                if(visit_water[nx][ny] == true) continue;
                if(arr[nx][ny] == 'X') continue;

                visit_water[nx][ny] = true;
                dist_water[nx][ny] = dist_water[x][y] + 1;
                q.add(nx);
                q.add(ny);
            }
        }
    }

    // 고슴도치를 시작으로 동시에 BFS 시작!
    static void bfs_hedgehog() {
        Queue<Integer> Q = new LinkedList<>();
        // 고슴도치 위치를 Q에 넣어주기!
        for (int i = 1; i <= R; i++){
            for (int j = 1; j<=C; j++){
                dist_gosu[i][j] = -1;
                if(arr[i][j] == 'S'){
                    Q.add(i);
                    Q.add(j);
                    dist_gosu[i][j] = 0;
                    visit_gosu[i][j] = true;

                }
            }
        }

        while(!Q.isEmpty()){
            int x = Q.poll();
            int y = Q.poll();

            for(int i=0; i<4; i++){
                int nx = x + dir[i][0];
                int ny = y + dir[i][1];
                if( nx < 1 || ny <1 || nx >R || ny > C) continue;
                if(visit_gosu[nx][ny]) continue;
                if(arr[nx][ny] != '.' && arr[nx][ny] != 'D') continue;
                if(arr[nx][ny] == 'X') continue;
                if(dist_water[nx][ny] <= dist_gosu[x][y] + 1 && dist_water[nx][ny] != -1) continue;
                visit_gosu[nx][ny] = true;
                dist_gosu[nx][ny] = dist_gosu[x][y] + 1;
                Q.add(nx);
                Q.add(ny);
            }
        }
    }

    static void pro() {
        // 각 칸마다 물에 닿는 시간 계사하기
        bfs_water();

        // 고슴도치가 물을 피해 탐색할 수 있는 공간 찾기
        bfs_hedgehog();

        // 탈출구 'D' 에 대한 결과를 통해 정답 출력하기
        for (int i=1; i<=R; i++){
            for (int j=1; j<=C; j++){
                if(arr[i][j] == 'D'){
                    if(dist_gosu[i][j] == -1) System.out.println("KAKTUS");
                    else System.out.println(dist_gosu[i][j]);
                }
            }
        }
    }

    public static void main(String[] args) {
        input();
        pro();
    }

}
