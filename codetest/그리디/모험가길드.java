package codetest.그리디;
import java.io.*;
import java.util.*;

public class 모험가길드 {

    public static int n;
    public static ArrayList<Integer> arrayList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i<n; i++) {
            arrayList.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(arrayList);

        int result = 0;
        int count = 0;
        for (int i = 0; i<n; i++) {
            count += 1;
            if (count >= arrayList.get(i)) {
                result += 1;
                count = 0;
            }
        }
        System.out.println(result);
    }
    
}












