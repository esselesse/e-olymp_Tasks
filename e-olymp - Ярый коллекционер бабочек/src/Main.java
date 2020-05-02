import java.io.*;
import java.util.Scanner;


public class Main {

    public static boolean binSearchRec(int[] a, int key){
        return binSearchRecIn(a, key, 0, a.length-1);
    }

    private static boolean binSearchRecIn(int[] a, int key, int left, int right) {

        if(key<a[left] || key>a[right])
            return false;
        int mid = (right + left)/2;
        if (a[mid] > key){
            if (left==right)
                return false;
            return binSearchRecIn(a, key, left, mid - 1);
        } else if (a[mid]<key){
            if (left==right)
                return false;
            return binSearchRecIn(a, key, mid+1, right);
        } else {
            return true;
        }
    }

    public static void readForButterflies(String fileName) throws FileNotFoundException {
        File file = new File(fileName);

        int n;
        int[] mass1;
        int m;
        int mass2[];
        try {
            BufferedReader in = new BufferedReader(new FileReader( file.getAbsoluteFile()));
            try {
                String s;
                s = in.readLine();
                n = Integer.parseInt(s);
                mass1 = new int[n];
                s = in.readLine();
                int k = 0;
                int t = 0;
                for (int i = 0; i < n; i++) {
                    while (t<s.length() && s.charAt(t) != ' ' )
                        t++;
                    mass1[i] = Integer.parseInt(s.substring(k,t));
                    t++;
                    k=t;
                }
                s = in.readLine();
                m = Integer.parseInt(s);
                mass2 = new int[m];
                s = in.readLine();
                k=0;
                t=0;
                for (int i = 0; i < m; i++) {
                    while (t<s.length() && s.charAt(t) != ' ' )
                        t++;
                    mass2[i] = Integer.parseInt(s.substring(k,t));
                    t++;
                    k=t;
                }

            } finally {
                in.close();
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }

        butterflies(n, mass1, m, mass2);
        return;
    }

    public static void butterflies(int n, int[] mass1, int m, int[] mass2) {
        try {
            
            File file = new File("output.txt");
            if(!file.exists()){
                file.createNewFile();
            }

           
            PrintWriter out = new PrintWriter(file.getAbsoluteFile());

            try {

                for (int i = 0; i < m; i++) {
                    out.println(binSearchRec(mass1, mass2[i])?"YES":"NO");

                }
            } finally {

                out.close();
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) {
               
        String str = "";
        try {

            readForButterflies("input.txt");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int n,m;

    }
}