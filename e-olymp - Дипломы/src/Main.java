import java.io.*;
public class Main {

    private static long search(int n, long temp, int w, int h){
        long left = 0;
        long right = temp;
        boolean check = false;
        while (left<right-1){
            long t = (left+right)/2;
            long a1 = t/w;
            long a2 = t/h;
            if(a1 * a2 >= n)
                right = t;
            else left = t;
        }

        return right;
    }

    public static void read() throws FileNotFoundException {
        StringBuilder sb = new StringBuilder();
        File file = new File("input.txt");
        File file1 = new File("output.txt");

        int w;
        int h;
        int n;

        try {
            if(!file.exists()){
                file.createNewFile();
            }

            BufferedReader in = new BufferedReader(new FileReader( file.getAbsoluteFile()));
            PrintWriter out = new PrintWriter(file1.getAbsoluteFile());
            try {
                String s;
                s = in.readLine();
                int l=0;
                int t=0;

                while (t<s.length() && s.charAt(t) != ' ' )
                    t++;
                w = Integer.parseInt(s.substring(l,t));
                t++;
                l=t;
                while (t<s.length() && s.charAt(t) != ' ' )
                    t++;
                h = Integer.parseInt(s.substring(l,t));
                t++;
                l=t;
                while (t<s.length() && s.charAt(t) != ' ' )
                    t++;
                n = Integer.parseInt(s.substring(l,t));
                long temp = n;
                temp*= w>h?w:h;
                out.println(Long.toString(search(n, /*n * (w>h?w:h)*/temp, w, h)));





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