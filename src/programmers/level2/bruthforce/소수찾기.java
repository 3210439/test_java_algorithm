package programmers.level2.bruthforce;

import java.util.HashSet;
import java.util.Set;

public class 소수찾기 {

    class Solution {

        private static boolean isPrime(int num){
            if( num < 2) return false;

            for(int i=2; i <= Math.sqrt(num); i++){
                if(num % i == 0) return false;
            }
            return true;
        }

        public int solution(String numbers) {
            int answer = 0;
            Set<Integer> set = new HashSet<>();

            recursion("", numbers, set);

            for(int num : set){
                if(isPrime(num)) answer ++;
            }

            return answer;
        }

        static void recursion(String prefix, String str,  Set<Integer> set){
            int n = str.length();

            if(prefix != ""){
                set.add(Integer.parseInt(prefix));
            }

            for(int i=0; i<str.length(); i++){
                recursion(prefix+str.charAt(i)
                        , str.substring(0,i) + str.substring(i+1,n), set);
            }
        }

    }
}
