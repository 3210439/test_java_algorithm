package programmers.level1.bruteforce;

import java.util.*;


public class 모의고사 {

    class Solution {
        public int[] solution(int[] answers) {

            List<Integer> list = new LinkedList<>();
            int[] answer;

            int[] supoza1 = {1,2,3,4,5};
            int[] supoza2 = {2,1,2,3,2,4,2,5};
            int[] supoza3 = {3,3,1,1,2,2,4,4,5,5};
            int score1 = 0, score2 = 0, score3 = 0;
            int n = answers.length;

            for(int i=0; i <n; i++){
                if(supoza1[i%supoza1.length] == answers[i]) score1++;
                if(supoza2[i%supoza2.length] == answers[i]) score2++;
                if(supoza3[i%supoza3.length] == answers[i]) score3++;
            }

            int maxValue = Math.max(score1, Math.max(score2, score3));
            if(score1 == maxValue) list.add(1);
            if(score2 == maxValue) list.add(2);
            if(score3 == maxValue) list.add(3);

            answer = new int[list.size()];

            for(int i=0; i<answer.length; i++){
                answer[i] = list.get(i);
            }

            return answer;
        }
    }
}
