package fastcampus_java;

public class 부르트포스_재귀_구현_스케치 {

    static int N, M;
    static int[] selected;
    // Recurrence Function (재귀 함수)
    // 만약 M 개를 전부 고름 => 조건에 맞는 탐색을 한 가지 성공한 것!
    // 아직 M 개를 고르지 않음 => k 번째부터 M번째 원소를 조건에 맞게 고르는 모든 방법을 시도한다.
    static void rec_func(int k) {
        if (k == M + 1) { // 다 골랐다!
            // selected[1..M] 배열이 새롭게 탐색된 결과
        } else {
            // 1~N 까지를 k 번 원소로 한 번씩 정하고,
            // 매번 k+1 번부터 M 번 원소로 재귀호출 해주기
        }
    }
}
