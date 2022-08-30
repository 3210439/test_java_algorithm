package fastcampus_java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1182_부분_수열의_합 {
    static int N, S, ans;
    static int[] nums;


    static void input(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            S = Integer.parseInt(st.nextToken());
            if(S == 0){
                ans -=1;
            }
            st = new StringTokenizer(br.readLine());
            nums = new int[N+1];
            for(int i=1; i<=N; i++){
                nums[i] = Integer.parseInt(st.nextToken());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // k 번째 원소를 포함시킬 지 정하는 함수
    // value:= k-1 번째 원소까지 골라진 원소들의 합
    static void rec_func(int k, int value){
        if (k == N + 1){ // 부분 수열을 하나 완성 시킨 상태
            // value 가 S 랑 같은 지 확인하기
            if(value == S) ans++;
        } else {
            // k 번째 원소를 포함시킬 지 결정하고 재귀호출해주기
            // Include
            rec_func(k+1, value + nums[k]);
            // Not Include
            rec_func(k + 1, value);
        }
    }

    public static void main(String[] args) {
        input();
        // 1번째 원소부터 M 번째 원소를 조건에 맞게 고르는 모든 방법을 탐색
        rec_func(1, 0);
        // ans 가 정말 "진 부분집합"만 다루는 지 확인하기
        System.out.println(ans);
    }
}
