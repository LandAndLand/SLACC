package CodeJam.Y13R5P1.jalman;

import java.io.*;
import java.util.Arrays;

public class A {

    public static int[] answer = new int[1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("in.txt"));
        PrintWriter pw = new PrintWriter(new FileWriter("out.txt"));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            System.out.println(t + " ~~~~~");
            String[] tmp = br.readLine().split(" ");
            long B = Long.parseLong(tmp[0]);
            long N = Long.parseLong(tmp[1]);
            tmp = br.readLine().split(" ");
            long[] v = new long[37];
            for (int i = 0; i < tmp.length; i++) {
                v[i] = Long.parseLong(tmp[i]);
            }
            Arrays.sort(v);
            double max = 0.0;
            for (int i = 1; i < 37; i++) {
                long initadd = 0;
                long waste = 0;
                int numtie = 0;
                for (int j = i; j < 37; j++) {
                    if (v[j] == v[i]) {
                        numtie++;
                    }
                }
                if (v[i] == v[i - 1]) {
                    v[i]++;
                    initadd++;
                    waste += numtie;
                }
                long bet = i * (v[i] - 1);
                long min = 0;
                for (int j = 0; j < i; j++) {
                    min += v[j];
                }
                if (i * v[i - 1] - min > B) {
                    bet = 0;
                } else if (bet - min + waste > B) {
                    bet = i * v[i - 1] - min;
                    bet += i * ((B - bet - waste) / i);
                } else {
                    bet -= min;
                    if (36 > i + numtie) {
                        long tp = B - bet - waste;
                        tp /= i + numtie;
                        while (i + numtie < 37 && v[i + numtie] < v[i] + tp) {
                            long dif = v[i + numtie] - v[i];
                            waste += numtie * dif;
                            bet += i * dif;
                            numtie++;
                            v[i] += dif;
                            initadd += dif;
                            tp = B - bet - waste;
                            tp /= i + numtie;
                        }
                        waste += numtie * tp;
                        bet += i * tp;
                    }
                }
                //System.out.println(i + " " + bet + " " + waste + " " + numtie + " " + min);
                if (bet > 0) {
                    long v1 = 36 * bet;
                    double val = v1 / (i + 0.0);
                    val -= bet;
                    val -= waste;
                    System.out.println(val);
                    if (val > max)
                        max = val;
                }
                v[i] -= initadd;
            }
            max += 0.0000001;
            pw.println("Case #" + t + ": " + max);
        }
        pw.flush();
        pw.close();
    }
}
