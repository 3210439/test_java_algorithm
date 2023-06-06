package programmers.level2.dfsbfs;

public class 전력망을_둘로_나누기 {

    static class Solution{

        int[][] dArr = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        boolean[][] visited;
        boolean[][] wireArr;
        int max = 0;

        int solution(int n, int[][] wires){
            int answer = -1;
            wireArr = new boolean[n+1][n+1];
            visited = new boolean[n+1][n+1];

            for(int i=0; i<n; i++){
                visited[0][i] = true;
                visited[i][0] = true;
            }

            for(int i=0; i<n; i++){
                int left = wires[i][0];
                int right = wires[i][1];
                wireArr[left][right] = true;
            }

            for(int i=1; i<=n; i++){
                for(int j=1; j<=n; j++){

                }
            }

            return answer;
        }

        void dfs(int x, int y, int count){
            if(visited[x][y] == false && wireArr[x][y]){
                visited[x][y] = true;
                for(int i=0; i<dArr.length; i++){
                    dfs(dArr[i][0], dArr[i][1], count+1);
                }
            }
        }
    }
}
