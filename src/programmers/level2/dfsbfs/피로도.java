package programmers.level2.dfsbfs;

public class 피로도 {
    class Solution {
        public int maxValue = 0;
        public boolean[] visited;

        public int solution(int k, int[][] dungeons) {
            int n = dungeons.length;
            visited = new boolean[n];

            dfs(0, dungeons, k);

            return maxValue;
        }

        public void dfs(int count, int[][] dungeons, int k){
            int n = dungeons.length;
            maxValue = Math.max(maxValue, count);

            for(int i=0; i<n; i++){
                if(k >= dungeons[i][0] && visited[i] == false){
                    visited[i] = true;
                    dfs(count+1, dungeons, k-dungeons[i][1]);
                    visited[i] = false;
                }
            }
        }
    }
}
