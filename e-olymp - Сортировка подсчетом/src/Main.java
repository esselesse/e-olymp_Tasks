import java.util.*;
import java.io.*;

public class Main {
    static FastScanner in;
    static PrintWriter out;
    static int[] mass;
    static int[] tempMass;
    static int n;

    public static void run() {
        try {
            in = new FastScanner(new File("input.txt"));
            out = new PrintWriter(new File("output.txt"));

            n = in.nextInt();
            int max=-1;
            int temp;
            tempMass = new int[1000001];
            for (int i = 0; i < n; i++) {
                temp=in.nextInt();
                if(max<temp)
                    max=temp;
                tempMass[temp]++;
            }


            for (int i = 0; i < max+1; i++) {
                for (int k = 0; k < tempMass[i]; k++) {
                    out.print(i+" ");
                }
            }

            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(File f) {
            try {
                br = new BufferedReader(new FileReader(f));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

    public static void main(String[] arg) {
        run();
    }
}