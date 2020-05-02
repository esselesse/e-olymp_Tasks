import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
        int k;
        List<Integer> mass = new ArrayList<Integer>();
        int min = 0;

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
                n = Integer.parseInt(s.substring(l,t));
                t++;
                l=t;
                while (t<s.length() && s.charAt(t) != ' ' )
                    t++;
                k = Integer.parseInt(s.substring(l,t));
                t++;
                l=t;

                for (int i = 0; i < n; i++) {
                    s = in.readLine();
                    mass.add(Integer.parseInt(s));
                    min=(min==0)?(mass.get(i)):(min<mass.get(i)?mass.get(i):min);
                }

                int answer = search(k, mass, min);
                out.println(answer);


            } finally {
                in.close();
                out.close();
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }

    }

    private static int search(int k, List<Integer> mass, int max){
        int left = 0;
        int right = max;
        boolean check = false;
        while (left<right-1){
            int t = (left+right)/2;
            long sum = 0;
            for (int i = 0; i < mass.size(); i++) {
                sum+=mass.get(i)/t;
            }
            if(sum>=k){
                left=t;
            } else {
                right=t;
            }
        }

        int sum = 0;
        for (int i = 0; i < mass.size(); i++) {
            sum+=mass.get(i)/right;
        }
        check = sum>=k;
        return check?right:left;
    }

    public static void main(String[] args) {
        try {
            read();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}