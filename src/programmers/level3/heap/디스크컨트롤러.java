package programmers.level3.heap;

import java.util.*;


/**
 * 주어진 문제는 "Shortest Job First(SJF)" 알고리즘을 구현하는 것입니다.
 * 이 알고리즘은 현재 대기중인 작업 중에 소요시간이 가장 짧은 작업을 먼저 처리하는 방식입니다.
 *
 * 자바로 SJF 알고리즘을 구현하는 방법은 다음과 같습니다.
 *
 * 1. 작업을 요청 시간이 빠른 순서대로 정렬합니다.
 * 2. 작업을 처리하는데 걸리는 시간이 가장 적은 작업을 선택합니다.
 * 3. 선택된 작업을 처리하고 걸린 시간을 측정합니다.
 * 4. 현재 처리 중인 작업이 없을 경우, 다음 작업을 선택합니다.
 * 5. 모든 작업이 처리될 때까지 2~4단계를 반복합니다.
 */
public class 디스크컨트롤러 {

    class Job implements Comparable<Job> {
        int requestTime;
        int duration;

        public Job(int requestTime, int duration) {
            this.requestTime = requestTime;
            this.duration = duration;
        }

        @Override
        public int compareTo(Job other) {
            // 작업의 소요시간을 기준으로 오름차순으로 정렬합니다.
            return this.duration - other.duration;
        }
    }

    class Solution {
        public int solution(int[][] jobs) {
            int answer = 0;
            int currentTime = 0;
            int index = 0;
            int n = jobs.length;

            // 작업을 요청 시간이 빠른 순서대로 정렬합니다.
            Arrays.sort(jobs, (a, b) -> a[0] - b[0]);

            PriorityQueue<Job> pq = new PriorityQueue<>();
            while (index < n || !pq.isEmpty()) {
                // 현재 처리할 수 있는 작업을 선택합니다.
                while (index < n && jobs[index][0] <= currentTime) {
                    pq.offer(new Job(jobs[index][0], jobs[index][1]));
                    index++;
                }

                // 현재 처리할 수 있는 작업이 없는 경우 시간을 1초 증가시킵니다.
                if (pq.isEmpty()) {
                    currentTime++;
                } else {
                    // 작업을 처리하고 걸린 시간을 측정합니다.
                    Job job = pq.poll();
                    currentTime += job.duration;
                    answer += currentTime - job.requestTime;
                }
            }

            // 평균 처리 시간을 계산하고 반환합니다.
            return answer / n;
        }
    }
}
