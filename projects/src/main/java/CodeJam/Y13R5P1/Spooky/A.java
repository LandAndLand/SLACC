package CodeJam.Y13R5P1.Spooky;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class A {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        //PrintWriter out = new PrintWriter(System.out);
        PrintWriter out = new PrintWriter(new File("A.out"));
        final int N = 37, W = 36;
        for (int t = in.nextInt(), cs = 1; t > 0; t--, cs++) {
            out.print("Case #" + cs + ": ");
            long b = in.nextLong();
            int n = in.nextInt();
            Long[] x = new Long[N];
            for (int i = 0; i < n; i++) x[i] = in.nextLong();
            Long[] bets = new Long[N];
            double ans = 0;
            for (int i = 1; i <= b; i++) {
                long min = getMin(x);
                for (int j = 0; j < N; j++) {
                    if (x[j] == min) {
                        x[j]++;
                        bets[j]++;
                        break;
                    }
                }
                double win = getWin(x, bets, W) - i;
                /*System.out.println(i + " " + min + " " + win);
				System.out.println(Arrays.toString(x));
				System.out.println(Arrays.toString(bets));
				System.out.println("------------------");*/
                if (win > ans)
                    ans = win;
            }
            out.println(ans);
        }
        out.flush();
    }

    static double getWin(Long[] x, Long[] bets, int w) {
        double res = 0;
        long min = getMin(x);
        int cnt = 0;
        for (int i = 0; i < x.length; i++) if (x[i] == min)
            cnt++;
        for (int i = 0; i < x.length; i++) if (x[i] == min) {
            res += 1.0 / cnt * bets[i] * w;
        }
        return res;
    }

    static long getMin(Long[] x) {
        long res = Long.MAX_VALUE;
        for (long xx : x) if (xx < res)
            res = xx;
        return res;
    }
}
