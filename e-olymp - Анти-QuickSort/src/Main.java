import java.util.*;
import java.io.*;

public class Main {
    static FastScanner in;
    static PrintWriter out;
    static int[] mass;
    static int[] mass1;
    static int n;


    public static void run() {
        try {
            in = new FastScanner(new File("input.txt"));
            out = new PrintWriter(new File("output.txt"));

            n=in.nextInt();
            mass=new int[n];
            mass1=new int[n];
            for (int i = 0; i < n; i++) {
                mass[i]=i;
            }

            for (int i = n-1; i >=0; i--) {
                mass1[mass[i/2]]=i+1;
                swap(i/2, i, mass);
            }

            int m1=0;
            int m2=0;
            boolean f1=true, f2=true;
            for (int i = 0; i < n; i++) {
                if(f1){
                    if(mass1[i]==1){
                        m1=i;
                        f1=false;
                    }
                }
                if(f2){
                    if(mass1[i]==2){
                        m2=i;
                        f2=false;
                    }
                }
                if(!f1&&!f2){
                    break;
                }
            }
            if(m1>m2){
                swap(m1, m2, mass1);
            }

            for (int i = 0; i < n; i++) {
                out.print(mass1[i] + " ");
            }


            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void swap(int i, int j, int[] mass) {
        int temp = mass[i];
        mass[i]=mass[j];
        mass[j]=temp;
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