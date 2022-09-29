package codingTestReady;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Oneone {


    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};
    // u 위쪽 r 오른쪽 d 아래쪽, l 왼쪽
    static char [][] arr;
    static int n;
    static int m;
    static int k;
    static List<String> list = new ArrayList<String>();
    static boolean[][] visit;
    static StringBuilder sb = new StringBuilder();

    static void dfs(int x, int y, int count, String str1){

        String str2 = str1;
        if(count == k){
            if(arr[x][y] == 'E') {
                list.add(str1);
                return;
            }
            else{
                return;
            }
        }


        // 연견된 노드로 이동
        for(int i=0; i<4; i++){
            if((x+dx[i] >= 0) && (x+dx[i]<n)){
                if((y+dy[i] >= 0) && (y+dy[i]<m)){
                        switch (i){
                            case 0: str1 += "d";
                                    break;
                            case 1: str1 += 'r';
                                    break;
                            case 2: str1 += 'u';
                                    break;
                            case 3: str1 += 'l';
                                    break;
                        }
                        dfs(x+dx[i], y+dy[i],count+1, str1);
                        str1 = str2;

                }
            }
        }

    }

    static void set(int r, int c, int kk){
        n = r;
        m = c;
        k = kk;
    }

    static public String solution(int n, int m, int x, int y, int r, int c, int k) {
        arr = new char[n][m];
        visit = new boolean[n][m];
        set(n, m,k);

        // 모든 칸에 점표를 넣는다.
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                arr[i][j] = '.';
            }
        }

        // 출발 지점과 도착 지점을 나타낸다.
        arr[x-1][y-1] = 'S';
        arr[r-1][c-1] = 'E';

        dfs(x-1,y-1,0,"");

        String answer = "impossible";
        if(!list.isEmpty()) {
            Collections.sort(list);
            answer = list.get(0);
        }

        return answer;
    }


    public static void main(String[] args) {
        System.out.println(solution(3, 4, 2, 3, 3, 1, 5));
    }
}
