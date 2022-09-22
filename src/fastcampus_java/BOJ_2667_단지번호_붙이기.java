package fastcampus_java;

import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class BOJ_2667_단지번호_붙이기 {

    // 결과 실패
    static int n;
    static int[][] arr;
    static boolean[][] visited;
    static StringBuilder sb = new StringBuilder();
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int nowIndex = 2;
    static int count = 0;

    static void input() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n][n];
        visited = new boolean[n][n];
        String eraseEmpty = sc.nextLine();

        for(int i=0; i<n; i++){
            String str = sc.nextLine();
            for(int j=0; j<n; j++){
                arr[i][j] = parseInt(String.valueOf(str.charAt(j)));
            }
        }
    }

    static void dfs(int x,int y,int index){
        visited[x][y] = true;
        count+=1;
        arr[x][y] = index;

        // 방문이 필요한 4군대 방문하기
        for(int i=0; i<4; i++){
            // 다음 이동 위치가 벽인지 아닌지 확인
            if((dx[i]+x < n ) && (dx[i]+x >= 0)){
                if((dy[i]+y < n)&&(dy[i]+y >= 0)){
                    if(visited[x+dx[i]][y+dy[i]] == false){
                        if(arr[x+dx[i]][y+dy[i]] == 1)
                            dfs(x+dx[i],y+dy[i], index);
                    }
                }
            }
        }
    }

    static void pro(){
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(arr[i][j] == 1){
                    dfs(i,j,nowIndex++);
                    sb.append(count).append("\n");
                    count = 0;
                }
            }
        }
        System.out.println(nowIndex-2);
        System.out.println(sb);
    }

    public static void main(String[] args) {
        input();
        pro();
    }

}
