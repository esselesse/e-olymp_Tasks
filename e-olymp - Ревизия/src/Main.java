import java.io.*;
import java.util.*;

/**
 * Created by esselesse on 03.10.2017.
 */
public class Main {
    public static void read() throws FileNotFoundException {
        File file = new File("input.txt");
        File file1 = new File("output.txt");

        int n;
        int a1=Integer.MAX_VALUE, a2=Integer.MAX_VALUE;
        int temp;
        try {
            if(!file.exists()){
                file.createNewFile();
            }

            Scanner input = new Scanner(System.in);
            input = new Scanner(file);
        //BufferedReader in = new BufferedReader(new FileReader( file.getAbsoluteFile()));
        PrintWriter out = new PrintWriter(file1.getAbsoluteFile());
        try {
            String s;

            n = input.nextInt();

            for (int i = 0; i < n; i++) {
                temp = input.nextInt();

                if(a1>=temp){
                    a2=a1;
                    a1=temp;
                } else {
                    if (a2 > temp) {
                        a2 = temp;
                    }
                }
            }
            out.println(a1+" "+a2);
            return;
        } finally {
            input.close();
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