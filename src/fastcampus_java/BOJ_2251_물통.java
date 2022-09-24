package fastcampus_java;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_2251_물통 {
    // todo: 각 용량은 오름차순으로 정렬한다.
    // todo: a가 비어있을 때 c의 모든 용량을 구하여라
    // A,B,C( 1<= A , B, C <= 200)
    // 입력 8 9 10
    // 출력 1 2 8 9 10

    // 물통의 현재 상태와 물을 붓는 행위를 관리하는 구조체
    static class State{
        int[] X;
        State(int[] _X){
            X = new int[3];
            for (int i=0; i<3; i++) X[i] = _X[i];
        }

        State move(int from, int to, int[] Limit){
            // from 물통에서 to 물통으로 물을 옮긴다.
            int[] nX = new int[]{X[0], X[1], X[2]};

            // 붙는 쪽의 물이 담기는 통의 크기보다 많을 경우
            if(X[from] + X[to] >= Limit[to]) {
                // 담겨있는 물이 있을 수 있으므로 그 분량을 빼준다.
                nX[from] -= Limit[to] - X[to];
                nX[to] = Limit[to];
            }else {
                nX[to] += nX[from];
                nX[from] = 0;
            }
            return new State(nX);
        }
    }

    // 물통 탐색 시작~
    static void bfs(int x1, int x2, int x3) {
        Queue<State> Q = new LinkedList<>();
        visit[x1][x2][x3] = true;
        Q.add(new State(new int[] {x1, x2, x3}));

        // BFS 과정 시작
        while (!Q.isEmpty()) {
            State st = Q.poll();
            if (st.X[0] == 0) possible[st.X[2]] = true;
            for (int from=0; from<3; from++) {
                for (int to=0; to<3; to++){
                    if (from == to) continue;
                    State nxt = st.move(from, to, Limit);

                    if (!visit[nxt.X[0]][nxt.X[1]][nxt.X[2]]) {
                        visit[nxt.X[0]][nxt.X[1]][nxt.X[2]] = true;
                        Q.add(nxt);
                    }
                }
            }
        }
    }

    static void pro() {
        bfs(0, 0, Limit[2]);
        // 정답 계산하기
        for (int i=0; i<= Limit[2]; i++) {
            if (possible[i]) sb.append(i).append(' ');
        }
        System.out.println(sb);
    }

    static StringBuilder sb = new StringBuilder();
    static int[] Limit;
    static boolean[] possible;
    static boolean[][][] visit;

    static void input() {
        Scanner sc = new Scanner(System.in);
        Limit = new int[3];
        for (int i=0; i<3; i++) Limit[i] = sc.nextInt();
        visit = new boolean[205][205][205];

        // 정답으로 가능한 값들 저장 공간
        possible = new boolean[205];
    }

    public static void main(String[] args) {
        input();
        pro();
    }

}
