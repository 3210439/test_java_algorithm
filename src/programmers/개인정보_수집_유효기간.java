package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 개인정보_수집_유효기간 {

    public static int[] solution(String today, String[] terms, String[] privacies){

        ArrayList<Integer> resultList = new ArrayList<Integer>();

        HashMap<String, Integer> termsHash = new HashMap<String, Integer>();

        for(String term : terms){
            String name = term.split(" ")[0];
            int month = Integer.parseInt(term.split(" ")[1]);
            termsHash.put(name, month);
        }

        for(int i =0; i<privacies.length; i++){
            String date = privacies[i].split(" ")[0];
            String t = privacies[i].split(" ")[1];

            int year = Integer.parseInt(date.split("\\.")[0]);
            int month = Integer.parseInt(date.split("\\.")[1]);
            int day = Integer.parseInt(date.split("\\.")[2]);

            int todayYear = Integer.parseInt(today.split("\\.")[0]);
            int todayMonth = Integer.parseInt(today.split("\\.")[1]);
            int todayDay = Integer.parseInt(today.split("\\.")[2]);


            year += (termsHash.get(t) / 12);
            month +=  termsHash.get(t) % 12;

            if(month > 12){
                month -= 12;
                year += 1;
            }

            if( year < todayYear){
                resultList.add(i+1);
            }
            else if( year == todayYear){
                if(month < todayMonth){
                    resultList.add(i+1);
                }
                else if(month == todayMonth){
                    if(day <= todayDay){
                        resultList.add(i+1);
                    }
                }
            }

        }

        return resultList.stream().mapToInt(Integer::intValue).toArray();
    }


    public static void main(String[] args){
        String today = "2022.05.19";
        String[] terms = new String[]{"A 6", "B 12", "C 3"};
        String[] privacies = new String[] {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};
        System.out.println(solution(today, terms, privacies));
    }
}
