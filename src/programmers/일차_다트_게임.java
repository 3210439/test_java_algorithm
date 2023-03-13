package programmers;

public class 일차_다트_게임 {
    // 미해결

    class Solution {
        public int solution(String dartResult) {
            int answer = 0;
            int preScore = 0;
            int prepreScore = 0;

            for(int i=1; i<dartResult.length(); i++){
                if(dartResult.charAt(i) == 'S'){

                    preScore = toInt(dartResult.charAt(i - 1));

                    if(i-2>0) {
                        if(dartResult.charAt(i - 2) == '1')
                            preScore = 10;
                    }


                    answer += preScore;

                }
                else if(dartResult.charAt(i) == 'D') {
                    preScore = (int) Math.pow(toInt(dartResult.charAt(i - 1)),2);
                    if(i-2>0) {
                        if(dartResult.charAt(i - 2) == '1') preScore = 100;
                    }
                    answer += preScore;
                }
                else if(dartResult.charAt(i) == 'D') {
                    preScore = (int) Math.pow(toInt(dartResult.charAt(i - 1)),3);
                    if(i-2>0) {
                        if(dartResult.charAt(i - 2) == '1') preScore = 1000;
                    }
                    answer += preScore;
                }
                else if(dartResult.charAt(i) == '*') {
                    answer += preScore;

                    if(i+2 < dartResult.length()) {
                        if (dartResult.charAt(i + 2) == 'S')
                            answer += (int) Math.pow(toInt(dartResult.charAt(i + 1)), 1);
                        else if (dartResult.charAt(i + 2) == 'D')
                            answer += (int) Math.pow(toInt(dartResult.charAt(i + 1)), 2);
                        else if (dartResult.charAt(i + 2) == 'T')
                            answer += (int) Math.pow(toInt(dartResult.charAt(i + 1)), 3);
                    }
                    else if(i+3 < dartResult.length()) {
                        if (dartResult.charAt(i + 3) == 'S') answer += 10;
                        else if (dartResult.charAt(i + 3) == 'D') answer += 100;
                        else answer += 1000;
                    }
                }
                else if(dartResult.charAt(i) == '#') {
                    answer -= (2*preScore);
                }
            }
            return answer;
        }

        public int toInt(char n){
            return Integer.parseInt(String.valueOf(n));
        }
    }

    public static void main(String[] args){

    }

}
