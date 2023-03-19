package programmers.level1;

public class 정수_제곱근_판별 {


    //최댓값 50000000000000
    // 해당 문제의 최댓값은 21억을 초과하기 때문에 i*i 결과또한 21억을 넘어서는 안된다.
    // 따라서 해당 문제를 해결하기 위해서는 Long 타입을 반드시 사용해야 된다.
    class Solution {
        public long solution(long n) {

            for(Long i = 1L; i*i<=n; i++){
                if(i*i == n)
                    return (i+1)*(i+1);
            }
            return -1;

        }
    }
}
