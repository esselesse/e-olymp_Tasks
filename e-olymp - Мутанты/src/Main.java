import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by esselesse on 30.09.2017.
 */
public class Main {

    public static void read() throws FileNotFoundException {
        StringBuilder sb = new StringBuilder();
        File file = new File("input.txt");
        File file1 = new File("output.txt");

        int n;
        Map<Integer, Integer> mass1 = new HashMap<Integer, Integer>();
        int m;
        int temp;

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
                s = in.readLine();
                int k = 0;
                int t = 0;
                for (int i = 0; i < n; i++) {
                    while (t<s.length() && s.charAt(t) != ' ' )
                        t++;
                    temp = Integer.parseInt(s.substring(k,t));
                    if(mass1.containsKey(temp)){
                        mass1.replace(temp, mass1.get(temp)+1);
                    } else {
                        mass1.put(temp, 1);
                    }
                    t++;
                    k=t;
                }
                s = in.readLine();
                m = Integer.parseInt(s);

                s = in.readLine();
                k=0;
                t=0;
                for (int i = 0; i < m; i++) {
                    while (t<s.length() && s.charAt(t) != ' ' )
                        t++;
                    temp = Integer.parseInt(s.substring(k,t));
                    t++;
                    k=t;
                    out.println(mass1.get(temp)==null?0:mass1.get(temp));
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