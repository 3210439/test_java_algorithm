package programmers.level2.dfsbfs;

public class 전력망을_둘로_나누기 {

    static class Solution {
        public int solution(int n, int[][] wires) {
            int minDifference = Integer.MAX_VALUE;

            for (int i = 0; i < wires.length; i++) {
                boolean[] removed = new boolean[wires.length];
                removed[i] = true;

                int count1 = dfs(1, wires, removed);
                int count2 = n - count1;

                int difference = Math.abs(count1 - count2);
                minDifference = Math.min(minDifference, difference);
            }

            return minDifference;
        }

        private int dfs(int node, int[][] wires, boolean[] removed) {
            int count = 1;

            for (int i = 0; i < wires.length; i++) {
                if (!removed[i] && (wires[i][0] == node || wires[i][1] == node)) {
                    removed[i] = true;
                    int nextNode = (wires[i][0] == node) ? wires[i][1] : wires[i][0];
                    count += dfs(nextNode, wires, removed);
                }
            }

            return count;
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int solution1 = solution.solution(4, new int[][]{{1, 2}, {2, 3}, {3, 4}});
        System.out.println(solution1);
    }
}
