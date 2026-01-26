import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 정보의 개수
        int N = Integer.parseInt(st.nextToken());

        // 대여기간
        String L = st.nextToken();
        // 날짜
        int ld = Integer.parseInt(L.substring(0, 3));
        // 시
        int lh = Integer.parseInt(L.substring(4, 6));
        // 분
        int lm = Integer.parseInt(L.substring(7, L.length()));
        // 시간 계산
        int range = ld*24*60 + lh*60 + lm;
        // 벌금
        int F = Integer.parseInt(st.nextToken());

        HashMap<String, String> map = new HashMap<>();
        HashMap<String, Long> fin = new HashMap<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            // 날짜
            String date = st.nextToken();
            // 시간
            String time = st.nextToken();
            // 대여 물품
            String item = st.nextToken();
            // 유저 이름
            String user = st.nextToken();

            // 대여 물품, 이름 = key
            String id = item + "_" + user;

            // key값이 존재할 경우(map에 값이 존재하는 경우) 
            if (map.containsKey(id)) {
                String dateStr1 = map.get(id);
                String dateStr2 = date + " " + time;
                SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                long d1 = f.parse(dateStr1).getTime();
                long d2 = f.parse(dateStr2).getTime();

                // 시간 차 계산
                long diff = ((d2 - d1) / (1000*60));
                if (diff > range) {
                    // key값이 존재할 경우
                    if (fin.containsKey(user)) {
                        // 누적되어 있는 벌금에 계산한 값 추가
                        fin.put(user, fin.get(user) + (diff-range) * F);
                    } else {
                        // 계산한 값 추가
                        fin.put(user, (diff-range) * F);
                    }
                }
                // 반납 처리
                map.remove(id);
            } else {
                // 입력받은 값 추가 (대여 처리)
                map.put(id, date + " " + time);
            }
        }

        List<String> list = new ArrayList<>(fin.keySet());
        Collections.sort(list);
        if (fin.size() <= 0) {
            System.out.println(-1);
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < list.size(); i++) {
                String key = list.get(i);
                sb.append(key + " " + fin.get(key)).append('\n');
            }
            System.out.print(sb);
        }
    }
}
