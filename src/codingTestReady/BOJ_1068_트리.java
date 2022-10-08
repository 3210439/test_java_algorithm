package codingTestReady;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class BOJ_1068_트리 {

    static int n, root, erased;
    static int[] leaf;
    static ArrayList<Integer>[] child;
    static StringBuilder sb = new StringBuilder();

    static void input() {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        child = new ArrayList[n];
        leaf = new int[n];
        for (int i=0; i<n; i++) child[i] = new ArrayList<>();
        for (int i=0;i<n;i++){
            int par = parseInt(scan.next());
            if(par == -1){
                root = i;
                continue;
            }
            child[par].add(i);
        }
        erased = scan.nextInt();
    }

    static void dfs(int x) {
        if(child[x].isEmpty()){
            leaf[x] = 1;
        }
        for (int y: child[x]){
            dfs(y);
            // leaf[y] 계산
            leaf[x] += leaf[y];
        }
    }

    static void pro() {
        // erased와 그의 부모 사이의 연결을 끊어주기
        for (int i=0; i<n; i++){
            if(child[i].contains(erased)){
                child[i].remove(child[i].indexOf(erased));
            }
        }
        // erased 가 root 인 예외 처리하기
        if (root != erased) dfs(root);

        // 정답 출력하기
        System.out.println(leaf[root]);
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}
