import java.io.*;
import java.util.*;

/**
 * Created by esselesse on 03.10.2017.
 */
public class Main {
    static long[] mass;
    static int counter = 0;
    public static void read() throws FileNotFoundException {
        File file = new File("input.txt");
        File file1 = new File("output.txt");


        try {
            if(!file.exists()){
                file.createNewFile();
            }

            Scanner input = new Scanner(file);
            PrintWriter out = new PrintWriter(file1.getAbsoluteFile());
            try {
                int n = input.nextInt();
                mass = new long[n];
                int i=0;
                while (input.hasNextLong()){
                    mass[i]=input.nextLong();
                    i++;
                }

                i=0;
                boolean wasswap=true;
                while (wasswap){
                    wasswap=false;
                    for (int j = 0; j < n-i-1; j++) {
                        if(mass[j]>mass[j+1]){
                            swap(j, j+1);
                            wasswap=true;

                        }
                    }
                    i++;
                }
            } finally {
                out.println(counter);
                for (int i = 0; i < mass.length; i++) {
                    System.out.print(mass[i] + " ");
                }
                input.close();
                out.close();
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }

    }

    private static void swap(int j, int i) {
        counter++;
        long temp = mass[j];
        mass[j]=mass[i];
        mass[i]=temp;
    }

    public static void main(String[] args) {
        try {
            read();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}