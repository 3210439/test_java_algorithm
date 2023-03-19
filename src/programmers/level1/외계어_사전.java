package programmers.level1;

public class 외계어_사전 {

    class Solution {
        public static int solution(String[] spell, String[] dic) {
            int answer = 2;

            for(String d : dic){
                String temp = "";
                int count = 0;
                for(String s : spell){
                    if(d.contains(s) && !temp.contains(s)){
                        count++;
                        temp += s;
                    }
                    if(count == spell.length) return 1;
                }
            }
            return answer;
        }
    }

    public static void main(String[] args) {
       System.out.println(Solution.solution(new String[]{"z", "d", "x"}, new String[]{"def", "dww", "dzx", "loveaw"}));
    }
}
