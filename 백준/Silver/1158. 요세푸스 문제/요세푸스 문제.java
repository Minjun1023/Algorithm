import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        sb.append("<");
        int index = 0;

        while (!list.isEmpty()) {
            index = (index + k - 1) % list.size();
            sb.append(list.remove(index));
            if (!list.isEmpty()) sb.append(", ");
        }

        sb.append(">");
        System.out.print(sb);

    }
    
}
