package programmers.level1;

public class 개미군단 {
    static class Solution {
        public int solution(int hp) {
            int answer = 0;
            int general = 5;
            int soldier = 3;
            int worker = 1;
            int leftHp = hp;

            while(leftHp > 0){
                if(leftHp >= general) leftHp -= general;
                else if(leftHp >= soldier) leftHp -= soldier;
                else leftHp -= worker;
                System.out.println(leftHp);
                answer += 1;
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(23));
    }
}
