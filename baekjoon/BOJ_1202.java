package baekjoon;

import java.io.*;
import java.util.*;

/*
 3  2
 1  65
 5  23
 2  99
 10
 2   

 1  65
 2  99
 5  23
 가방1: 10  가방2: 2
 출력: 164 65+99
 */

public class BOJ_1202 {
    static class jewel implements Comparable<jewel> {
        int weight, value;
        public jewel(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
        @Override
        public int compareTo(jewel o) {
            if (this.weight == o.weight) {
                // 무게가 같을 때 가치 내림차순
                return o.value - this.value;
            }
            // 무게가 다를때 가치 오름차순
            return this.weight - o.weight;
        }
    }
    static int N, K;
    static long answer = 0;
    static int[] bag;
    static jewel[] jewels;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        bag = new int[K];
        jewels = new jewel[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            jewels[i] = new jewel(M, V); // 무게, 가치
        }
        for (int i = 0; i < K; i++) {   
            int C = Integer.parseInt(br.readLine());
            bag[i] = C; // 가방
        }
        Arrays.sort(bag);   // 가방 정렬
        Arrays.sort(jewels);    // 보석 정렬
        // 내림차순 정렬로 설정
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        // 가방 무게가 낮은 것부터 탐색
        for (int i = 0, j = 0; i < K; i++) {
            while(j < N) {
                if (bag[i] < jewels[j].weight)  // 다음 보석부터 가방의 무게보다 클 때
                break;  
                pq.add(jewels[j++].value);  // 가방에 보석을 넣을 수 있을 때
            }
            // 넣을 수 있는 보석이 있을 때 가장 가치가 높은 것 넣기
            if(!pq.isEmpty()) {
                // 내림차순이므로 가장 큰 값을 가져옴
                answer += pq.poll();
            }
        }
        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
        }
    }


