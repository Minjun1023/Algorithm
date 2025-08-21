package codetest.이진탐색;
import java.util.*;
import java.io.*;

public class 떡볶이떡 {
    static int n, m;
    static int[] box;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        box = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            box[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(box);
        // 10 15 17 19

        int result = binarySearch(box, m, 0, box[box.length-1]);
        System.out.println(result);
    }

    private static int binarySearch(int[] box, int m, int start, int end) {
        int max = 0;

        while (start <= end) {
            int mid = (start + end) / 2;

            int cutting = 0;
            for (int i: box) {
                cutting += Math.max((i-mid), 0);
            }

            if (cutting == m) {
                return mid;
            } else if (cutting < m) {
                end = mid - 1;
            } else {
                start = mid + 1;
                max = mid;
            }
        }
        return max;
    }
}
