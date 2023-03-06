package programmers;

public class 뒤집기3진법 {


    // 나의 답변
    class Solution {
        public int solution(int n) {
            String ternary = convertToTernary(n);
            int total = 0;
            for(int i=0; i<ternary.length(); i++){
                total += Integer.parseInt(String.valueOf(ternary.charAt(i)))*Math.pow(3,i);
            }
            return total;

        }

        public static String convertToTernary(int decimal){
            StringBuilder ternary = new StringBuilder();
            while(decimal > 0){
                int remainder = decimal % 3;
                ternary.append(remainder);
                decimal /= 3;
            }
            return ternary.reverse().toString();
        }
    }

    // 좀 더 좋았던 다른 사람 답변
//    class Solution {
//        public int solution(int n) {
//            String a = "";
//
//            while(n > 0){
//                a = (n % 3) + a;
//                n /= 3;
//            }
//            a = new StringBuilder(a).reverse().toString();
//
//
//            return Integer.parseInt(a,3);
//        }
//    }

    public static void main(String[] args){

    }
}
