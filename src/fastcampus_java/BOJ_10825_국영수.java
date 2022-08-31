package fastcampus_java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10825_국영수 {

    static int n;
    static Elem[] elems;
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    static class Elem implements Comparable<Elem> {
        public String name;
        public int korean, english, math;

        @Override
        public int compareTo(Elem other) {
            if (other == null) return 1;
            // TODO 국어 하락, 영어 상승, 수학 하락, 이름 상승
            if(this.korean != other.korean) return other.korean - this.korean;
            if(this.english != other.english) return this.english - other.english;
            if(this.math != other.math) return other.math - this.math;
            return this.name.compareTo(other.name);
        }
    }

    static void input() {
        try {
            n = Integer.parseInt(br.readLine());
            elems = new Elem[n+1];
            for(int i=1; i<=n; i++){
                st = new StringTokenizer(br.readLine());
                elems[i] = new Elem();
                elems[i].name = st.nextToken();
                // todo: 국어, 영어, 수학으로 입력 받기
                elems[i].korean = Integer.parseInt(st.nextToken());
                elems[i].english = Integer.parseInt(st.nextToken());
                elems[i].math = Integer.parseInt(st.nextToken());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void pro() {
        // 기준을 통해 정렬하기
        Arrays.sort(elems);
        for(int i=1; i<=n; i++){
            sb.append(elems[i].name).append('\n');
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        input();
        pro();
    }

}
