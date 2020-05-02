import java.io.*;
import java.util.*;

/**
 * Created by esselesse on 03.10.2017.
 */
public class Main {
    public static void read() throws FileNotFoundException {
        //StringBuilder sb = new StringBuilder();
        File file = new File("input.txt");
        File file1 = new File("output.txt");

        int n;
        int a1, a2;
        try {
            if(!file.exists()){
                file.createNewFile();
            }

            BufferedReader in = new BufferedReader(new FileReader( file.getAbsoluteFile()));
            PrintWriter out = new PrintWriter(file1.getAbsoluteFile());
            try {
                String s;
                s = in.readLine();
                n = Integer.parseInt(s);

                int l=0;
                int t=0;

                for (int i = 0; i < n; i++) {
                    s = in.readLine();
                    l = 0;
                    t = 0;

                    while (t < s.length() && s.charAt(t) != ' ')
                        t++;
                    a1 = Integer.parseInt(s.substring(l, t));
                    t++;
                    l = t;
                    while (t < s.length() && s.charAt(t) != ' ')
                        t++;
                    a2 = Integer.parseInt(s.substring(l, t));

                    out.println(a1+a2);
                }




            } finally {
                in.close();
                out.close();
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }

    }
    public static void main(String[] args) {
        try {
            read();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}