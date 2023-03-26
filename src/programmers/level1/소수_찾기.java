package programmers.level1;

import java.util.Arrays;

public class 소수_찾기 {

    /**
     * 에라토스테네스의 체(선별된 소수의 배수를 지우면서 소수를 찾는 방법)
     * 소수를 구하는대 효과적인 알고리즘이며 에라토스테네스의 체를 이용해서 해당 문제를 해결했습니다.
     */
    class Solution {
        public int solution(int n) {
            int answer = 0;
            boolean[] isPrime = new boolean[n + 1];
            Arrays.fill(isPrime, true); // 모든 수를 소수로 초기화

            isPrime[0] = false; // 0과 1은 소수가 아니므로 제외
            isPrime[1] = false;

            int sqrtN = (int) Math.sqrt(n);
            for(int i = 2; i <= sqrtN; i++) {
                if (isPrime[i]) { // i가 소수인 경우
                    for(int j = i * i; j <= n; j += i) {
                        isPrime[j] = false; // i의 배수들은 소수가 아니므로 제외
                    }
                }
            }
            for(int i=0; i<=n; i++){
                if(isPrime[i]) answer++;
            }

            return answer;
        }
    }
}
