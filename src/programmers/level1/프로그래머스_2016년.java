package programmers.level1;

public class 프로그래머스_2016년 {

    // 윤년은 2월이 29일 까지 있다는 것을 조심해야된다.
    public String solution(int a, int b) {
        String answer = "";
        String[] dayOfWeek = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};

        int[] monthEnd = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int days = 0;
        for (int i = 0; i < a; i++) {
            days += monthEnd[i];
        }
        days += b-1;

        answer = dayOfWeek[(days+5) % 7];
        return answer;
    }
}
