package solveByType.sort;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class card_11652_bak {
    static FastReader scan = new FastReader();

    static void input(){
        N = scan.nextInt();
        P = new long[N+1];
        for (int i=1; i<=N; i++) P[i] = scan.nextLong();
    }

    static int N;
    static long[] P;

    static void pro(){
        // Sort 정렬하기
        Arrays.sort(P,1 , N+1);
        // mode: 최빈값
        // modeCnt: 최빈값의 등장 횟수, curCnt: 현재 값(a[1])의 등장 횟수
        long mode = P[1];
        int modeCnt = 1, curCnt = 1;

        // TODO
        // 2번 원소부터 차례대로 보면서, 같은 숫자가 이어서 나오고 있는 지,
        // 새로운 숫자가 나왔는 지를 판단하여 curCnt를 갱신해주고, 최빈값을
        // 갱신하는 작업

        for(int i=2; i<=N; i++){
            if(P[i-1] == P[i]) {
                curCnt += 1;
                if(curCnt > modeCnt) {
                    modeCnt = curCnt;
                    mode = P[i];
                }
            }
            else {
                curCnt = 1;
            }
        }
        // 정답 출력하기
        System.out.println(mode);
    }

    public static void main(String[] args){
        input();
        pro();
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {return Integer.parseInt(next());}
        long nextLong() {return Long.parseLong(next());}
        double nextDouble() {return Double.parseDouble(next());}

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
