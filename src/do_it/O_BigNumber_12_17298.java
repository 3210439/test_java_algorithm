package do_it;

import java.io.*;
import java.util.Scanner;
import java.util.Stack;

public class O_BigNumber_12_17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N+1];
        int[] ans = new int[N+1];
        String[] str = br.readLine().split(" ");
        for(int i=1; i<=N; i++){
            A[i] = Integer.parseInt(str[i-1]);
        }
        Stack<Integer> myStack = new Stack<>();
        myStack.push(1);
        for(int i=2; i<=N; i++){
            // 스택이 비어 있지 않고 현재 수열이 스택 top 인덱스가 가리키는 수열보다 클 경우
            while (!myStack.isEmpty() && A[myStack.peek()] < A[i]){
                ans[myStack.pop()] = A[i];  // 정답 배열에 오큰수를 현재 수열로 저장하기
            }
            myStack.push(i);                // 신규 데이터 push
        }
        while (!myStack.empty()) {
            // 반복문을 다 돌고 나왔는데 스택이 비어 있지 않다면 빌 때까지
            ans[myStack.pop()] = -1;
            // 스택에 쌓인 index에 -1을 넣고
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i=1; i<=N; i++){
            bw.write(ans[i] + " ");
            // 출력한다.
        }
        bw.write("\n");
        bw.flush();
    }
}
