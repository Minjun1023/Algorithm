package baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_11000 {
    
    static class Class implements Comparable<Class> {
        int start;
        int end;

        public Class(int start, int end) {
            this.start = start;
            this.end = end;
        }
        @Override
        public int compareTo(Class o) {
            if (this.start == o.start) {
                return this.end - o.end;
            } else {
                return this.start - o.start;
            }
        }
    }
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int N = Integer.parseInt(br.readLine());
       List<Class> list = new ArrayList<>();
       for (int i = 0; i < N; i++) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        list.add(new Class(start, end));
       }
       Collections.sort(list);
       PriorityQueue<Integer> q = new PriorityQueue<>();
       int endTime = 0;

       for (Class m : list ) {
        endTime = m.end;
        if (!q.isEmpty() && q.peek() <= m.start) {
            q.poll();
        }
        q.add(endTime);
       }
       System.out.println(q.size());
    } 
}   


