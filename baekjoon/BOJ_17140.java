package baekjoon;

import java.io.*;
import java.util.*;

/*
 * R: 배열 A의 모든 행에 대해서 정렬. 행의 개수 >= 열의 개수
 * C: 배열 A의 모든 열에 대해서 정렬. 행의 개수 < 열의 개수
 * 한 행 또는 열에 있는 수를 정렬하기위해서는 각각의 수가 몇 번 나왔는지 알아야 함.
 * 수의 등장 횟수가 커지는 순으로, 여러가지일 경우 수가 커지는 순으로 정렬
 * 정렬된 결과를 배열에 넣을 때는 수와 등장 횟수를 모두 넣으며, 순서는 수가 먼저
 * 
 * [3,1,1] 3:1, 1:2
 * 정렬된 결과: [3,1,1,2] 3:1, 1:2, 2:1
 * 정렬된 결과: [2,1,3,1,1,2] 
 *  1 2 2
    1 2 1
    2 1 3
    3 3 3
    A[1][2] = 1
    -> A[0][1] = 2 
    R 연산
    [1,2,1] 1:2 2:1
    -> [2,1,1,2]
    [2,1,3] 2:1 1:1 3:1
    -> [1,1,2,1,3,1]
    [3,3,3] 3:3
    -> [3,3]

    [2,1,1,2,0,0]
    [1,1,2,1,3,1]
    [3,3,0,0,0,0]
    A[0][1] = 1 만족
    출력 = 1
 */

public class BOJ_17140 {
    static class Pair implements Comparable<Pair> {
        int number;
        int count;

        public Pair(int number, int cnt) {
            this.number = number;
            this.count = cnt;
        }

        // 수의 등장횟수가 커지는 순으로, 등장횟수가 같은 경우수가 커지는 순으로
        @Override
        public int compareTo(Pair o) {
            if (this.count > o.count) {
                // 양수이므로 뒤에 위치
                return 1;
            } else if (this.count == o.count) {
                return this.number - o.number;
            } else {
                // 음수이므로 앞에 위치
                return -1;
            }
        }
    }

    static int r, c, k;
    static int[][] A = new int[101][101];
    static int xLength = 3, yLength = 3;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 3; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(solution());
    }

    public static int solution() {
        for (int time = 0; time <= 100; time++) {
            if (A[r][c] == k) {
                return time;
            }
            operating();
        }

        return -1;
    }

    public static void operating() {
        // R 연산: 배열 A의 모든 행에 대해서 정렬을 수행한다. 행의 개수 ≥ 열의 개수인 경우에 적용된다.
        // C 연산: 배열 A의 모든 열에 대해서 정렬을 수행한다. 행의 개수 < 열의 개수인 경우에 적용된다.
        if (xLength >= yLength) {
            for (int i = 1; i <= xLength; i++) {
                R(i);
            }
        } else {
            for (int i = 1; i <= yLength; i++) {
                C(i);
            }
        }
    }

    static void R(int key) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        Map<Integer, Integer> map = new HashMap<>(); // number, count

        for (int i = 1; i <= yLength; i++) {
            // 0인 경우 무시
            if (A[key][i] == 0) continue;
            // 중복이 없을 경우 1, 있을 경우 +1
            map.compute(A[key][i], (number, cnt) -> cnt == null ? 1 : cnt+1);
        }   

        map.forEach((k, v) -> pq.add(new Pair(k, v)));

        int i = 1;
        // 숫자와 등장횟수 값 넣기
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            A[key][i++] = p.number;
            A[key][i++] = p.count;
        }

        // 배열의 열 길이를 갱신
        yLength = Math.max(yLength, i);

        // 나머지를 0으로 채움
        while (i <= 99) {
            A[key][i++] = 0;
            A[key][i++] = 0;
        }
    }

    static void C(int key) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        Map<Integer, Integer> map = new HashMap<>(); // number, count

        for (int i = 1; i <= xLength; i++) {
            if (A[i][key] == 0) continue;
            map.compute(A[i][key], (number, count) -> count == null ? 1 : count+1);
        }

        map.forEach((k, v) -> pq.add(new Pair(k, v)));

        int i = 1;
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            A[i++][key] = p.number;
            A[i++][key] = p.count;
        }

        xLength = Math.max(xLength, i);

        while (i <= 99) {
            A[i++][key] = 0;
            A[i++][key] = 0;
        }
    }
}
