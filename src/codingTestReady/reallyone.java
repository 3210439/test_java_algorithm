package codingTestReady;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class reallyone {




        public static int[] solution(String today, String[] terms, String[] privacies) {
            int[] answer = {};
            List<Integer> list = new ArrayList<>();

            int n = privacies.length;

            for(int i=0; i < n; i++){
                if(check(i, today, terms, privacies)){
                    list.add(i+1);
                }
            }
            answer = list.stream().mapToInt(Integer::intValue).toArray();
            return answer;
        }

        static private boolean check(int i, String today, String[] terms, String[] privacies) {

            int t_year, t_month, t_day;
            int n_year, n_month, n_day;
            String[] pri = privacies[i].split(" ");

            int period = 0;

            // 남은 기간
            int amount = 0;

            String now = pri[0];
            String nowTerm = pri[1];

            for(int j=0; j<terms.length; j++){
                String[] term = terms[j].split(" ");
                if(term[0].equals(nowTerm)){
                    period = parseInt(term[1]);
                }
            }

            amount = period*28;

            String[] strs = today.split("[.]");
            t_year = parseInt(strs[0]);
            t_month = parseInt(strs[1]);
            t_day = parseInt(strs[2]);

            String[] strs2 = now.split("[.]");
            n_year = parseInt(strs2[0]);
            n_month = parseInt(strs2[1]);
            n_day = parseInt(strs2[2]);

            int r_year = (t_year - n_year)*28*12;
            int r_month = (t_month - n_month)*28;
            int r_day = t_day - n_day;

            int result = r_year + r_month + r_day;


            return amount <= result;


    }

    public static void main(String[] args) {
        System.out.println(solution("2022.05.19" , new String[]{"A 6", "B 12", "C 3"}, new String[]{"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"}));
    }
}
