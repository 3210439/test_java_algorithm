package programmers.level1;

public class 이진수더하기 {

    class Solution {
        public String solution(String bin1, String bin2) {

            return addBinary(bin1, bin2);
        }

        public String addBinary(String bin1, String bin2) {
            int carry = 0;
            int i = bin1.length() - 1;
            int j = bin2.length() - 1;
            StringBuilder sb = new StringBuilder();
            while (i >= 0 || j >= 0) {
                int sum = carry;
                if (i >= 0) {
                    sum += bin1.charAt(i--) - '0';
                }
                if (j >= 0) {
                    sum += bin2.charAt(j--) - '0';
                }
                sb.append(sum % 2);
                carry = sum / 2;
            }
            if (carry != 0) {
                sb.append(carry);
            }
            return sb.reverse().toString();
        }
    }
}
