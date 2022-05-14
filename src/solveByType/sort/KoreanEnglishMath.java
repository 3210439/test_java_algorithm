package solveByType.sort;


import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class KoreanEnglishMath {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static void input(){
        N = scan.nextInt();
        s = new Student[N];
        for(int i=0; i<N; i++){
            s[i] = new Student();
            s[i].name = scan.next();
            s[i].korean = scan.nextInt();
            s[i].english = scan.nextInt();
            s[i].math = scan.nextInt();
        }

    }

    static int N;
    static Student[] s;

    static void pro() {
        // TODO
        // 기준을 통해 정렬하기
        Arrays.sort(s);

        // 정답 출력하기
        for (int i=0; i<s.length; i++){
            sb.append(s[i].name).append('\n');
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        input();
        pro();
    }

    static class Student implements Comparable<Student>{
        String name;
        int korean, english, math;

        @Override
        public int compareTo(Student other) {
            // 1. 국어 점수가 감소하는 순서로
            if(korean != other.korean) return other.korean - korean;
            // 2. 국어 점수가 같으면 영어 점수가 증가하는 순서로
            if(english != other.english) return english - other.english;
            // 3. 국어 점수와 영어 점수가 같으면 수학 점수가 감소하는 순서로
            if(math != other.math) return other.math - math;
            return name.compareTo(other.name);
        }
    }



    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() { br = new BufferedReader(new InputStreamReader(System.in));}

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try{
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() { return Integer.parseInt(next()); }

        long nextLong() { return Long.parseLong(next()); }

        double nextDouble() { return Double.parseDouble(next());}

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch(IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
