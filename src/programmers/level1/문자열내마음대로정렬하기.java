package programmers.level1;

import java.util.Arrays;

public class 문자열내마음대로정렬하기 {

    class Solution {
        public String[] solution(String[] strings, int n) {
            String[] answer = Arrays.copyOf(strings, strings.length);

            for(int i=0; i<answer.length-1; i++){
                for(int j=0; j<answer.length-i-1; j++){
                    System.out.println(j);
                    System.out.println(answer[j].charAt(n) +" : "+ answer[j+1].charAt(n));
                    if(answer[j].charAt(n) > answer[j+1].charAt(n)) {
                        String temp = answer[j];
                        answer[j] = answer[j+1];
                        answer[j+1] = temp;
                    }else if(answer[j].charAt(n) == answer[j+1].charAt(n)){
                        if(answer[j].compareTo(answer[j+1]) > 0) {
                            String temp = answer[j];
                            answer[j] = answer[j+1];
                            answer[j+1] = temp;
                        }
                    }
                }
            }

            return answer;
        }
    }
}
