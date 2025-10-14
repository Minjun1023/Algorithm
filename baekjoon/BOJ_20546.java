package baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_20546 {
    static int cash;
    static int[] arr = new int[14];

    static class stock {
        int money = 0;
        int cnt = 0;

        public stock(int money, int cnt) {
            this.money = money;
            this.cnt = cnt;
        }

        public void buy_stock(int cnt, int todaycost) {
            if (this.money < todaycost * cnt) return;
            money -= todaycost * cnt;
            this.cnt += cnt;
        }

        public int sell(int todaycost) {
            this.money += this.cnt * todaycost;
            this.cnt = 0;
            return todaycost;
        }
    }
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        cash = Integer.parseInt(br.readLine());
        int bnp, timing;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 14; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        bnp = BNP();
        timing = TIMING();

        if (bnp < timing) {
            System.out.println("TIMING");
        } else if (bnp > timing) {
            System.out.println("BNP");
        } else {
            System.out.println("SAMESAME");
        }
    }

    public static int BNP() {
        stock s = new stock(cash, 0);

        for (int i = 0; i < 14; i++) {
            if (arr[i] <= s.money) {
                s.buy_stock(s.money / arr[i], arr[i]);
            }
        }
        return (s.cnt * arr[13])+ s.money;
    }

    public static int TIMING() {
        stock s = new stock(cash, 0);

        for (int i = 3; i < 14; i++) {
            if (arr[i-1] < arr[i-2] && arr[i-2] < arr[i-3]) {
                s.buy_stock(s.money / arr[i], arr[i]);
            } else if (arr[i-1] > arr[i-2] && arr[i-2] > arr[i-3]) {
                s.sell(arr[i]);
            }
        }
        return (s.cnt * arr[13]) + s.money;
    }
}
