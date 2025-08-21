package baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_1946 {
    static int T, N;
    static int[][] applicants;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            applicants = new int[N][2];
            for (int j = 0; j < N; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                applicants[j][0] = Integer.parseInt(st.nextToken());
                applicants[j][1] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(applicants, Comparator.comparingInt(a -> a[0]));

            int count = 1;
            int minInterviewRank = applicants[0][1];

            for (int j = 1; j < N; j++) {
                if (applicants[j][1] < minInterviewRank) {
                    count++;
                    minInterviewRank = applicants[j][1];
                }
            }
            System.out.println(count);
        }
    }
}
