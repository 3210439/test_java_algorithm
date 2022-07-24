package do_it.ch4;


import java.util.Scanner;

/**
 * 슈도코드
 * N(사람 수)
 * A(자릿수별로 구분해 저장한 배열)
 * S(A 합 배열: 각 사람이 인출을 완료하는 데 필요한 시간을 저장하기)
 * for(N만큼 반복하기) {
 *     A 배열 저장하기
 * }
 * for(i: N만큼 반복하기) {
 *     for(j: i - 1 ~ 0까지 뒤에서부터 반복하기) {
 *         현재 범위에서 삽입 위치 찾기
 *     }
 *     for(j: i ~ insert_point + 1까지 뒤에서부터 반복하기) {
 *         삽입을 위해 삽입 위치에서 i까지 데이터를 한 칸씩 뒤로 밀기
 *     }
 *     삽입 위치에 현재 데이터 삽입하기
 * }
 * for(i: N만큼 반복하기) {
 *     A 배열을 총한 합 배열 S 만들기
 * }
 *
 * S 배열의 각 데이터 값을 모두 합해 결과 출력하기
 */
public class 문제18번ATM인출시간계산하기답안 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        int[] S = new int[N];
        for(int i=0; i<N; i++){
            A[i] = sc.nextInt();
        }
        for(int i=1; i<N; i++){ // 삽입 정렬
            int insert_point = i;
            int insert_value = A[i];
            for(int j = i - 1; j >=0; j--){
                if(A[j] < A[i])
                {
                    insert_point = j + 1;
                    break;
                }
                if(j == 0) {
                    insert_point = 0;
                }
            }
            for(int j = i; j > insert_point; j--) {
                A[j] = A[j-1];
            }
            A[insert_point] = insert_value;
        }
        S[0] = A[0]; // 합배열 만들기
        for(int i = 1; i < N; i++) {
            S[i] = S[i-1] + A[i];
        }
        int sum = 0;
        for(int i=0; i<N; i++){
            sum += S[i];
        }
        System.out.println(sum);
    }
}
