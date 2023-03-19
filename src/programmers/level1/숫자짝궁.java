package programmers.level1;

public class 숫자짝궁 {

    // 나의 풀의
    class Solution {
        public String solution(String X, String Y) {

            String answer = "";
            int a[] = new int[10];
            int b[] = new int[10];

            for(int i=0; i<X.length(); i++){
                a[Integer.parseInt(String.valueOf(X.charAt(i)))] += 1;
            }

            for(int i=0; i<Y.length(); i++){
                b[Integer.parseInt(String.valueOf(Y.charAt(i)))] += 1;
            }

            StringBuilder sb = new StringBuilder();

            for(int i=9; i>=0; i--){
                while(a[i] > 0 && b[i] > 0){
                    sb.append(i);
                    a[i] -= 1;
                    b[i] -= 1;
                }
            }

            answer = sb.toString();

            if(answer.contains("0") && answer.length() > 1){
                Boolean isAllZero = true;
                for(int i=0; i<answer.length(); i++){
                    if(answer.charAt(i) != '0') isAllZero = false;
                }
                if(isAllZero) answer = "0";
            }

            if(answer.isBlank()) answer = "-1";

            return answer;
        }
    }


    // 코드 제출 후 봤던 더 좋아보였던 코드
    class Solution2 {
        public String solution(String X, String Y) {
            StringBuilder answer = new StringBuilder();
            int[] x = {0,0,0,0,0,0,0,0,0,0};
            int[] y = {0,0,0,0,0,0,0,0,0,0};
            for(int i=0; i<X.length();i++){
                x[X.charAt(i)-48] += 1;
            }
            for(int i=0; i<Y.length();i++){
                y[Y.charAt(i)-48] += 1;
            }

            for(int i=9; i >= 0; i--){
                for(int j=0; j<Math.min(x[i],y[i]); j++){
                    answer.append(i);
                }
            }
            if("".equals(answer.toString())){
                return "-1";
            }else if(answer.toString().charAt(0)==48){
                return "0";
            }else {
                return answer.toString();
            }
        }
    }


}
