package programmers.level1;

import java.util.Arrays;
import java.util.List;

public class 달리기경주 {


    // 해당 솔루션은 테스트 9~13 에서 시간 초과가 발생함으로 성능 개선이 필요합니다.
    class Solution {
        public String[] solution(String[] players, String[] callings) {

            List<String> list = Arrays.asList(players);

            for(String call : callings){
                int i = list.indexOf(call);

                String temp = list.get(i-1);
                list.set(i-1, call);
                list.set(i, temp);
            }


            return list.toArray(new String[list.size()]);
        }
    }
}
