import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        TreeSet<int[]> ts = new TreeSet<>((o1, o2) -> {
            // 문제 난이도가 다른 경우
            if (o1[1] != o2[1]) {
                // 문제 난이도가 작은 순으로 출력
               return o1[1] - o2[1];
            // 문제 난이도가 같은 경우
            } else {
                // 문제 번호가 작은 순으로 출력
                return o1[0] - o2[0];
            }
        });
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            ts.add(new int[] {p, l});
            map.put(p, l);
        }

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            switch(st.nextToken()) {
                case "recommend":
                    int num = Integer.parseInt(st.nextToken());
                    if (num == 1) {
                        int[] minT = ts.last();
                        sb.append(minT[0]).append('\n');
                    } else if (num == -1) {
                        int[] maxT = ts.first();
                        sb.append(maxT[0]).append('\n');
                    }
                    break;

                case "add":
                    int p = Integer.parseInt(st.nextToken());
                    int l = Integer.parseInt(st.nextToken());
                    ts.add(new int[] {p, l});
                    map.put(p, l);
                    break;
                
                case "solved":
                    int s_p = Integer.parseInt(st.nextToken());
                    int s_l = map.get(s_p);
                    ts.remove(new int[] {s_p, s_l});
                    map.remove(s_p);
                    break;

                default:
                    break;
            }
        }
        System.out.print(sb);
    }
}
