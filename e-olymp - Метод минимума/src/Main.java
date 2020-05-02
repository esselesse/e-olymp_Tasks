import java.io.*;
import java.util.*;

/**
 * Created by esselesse on 03.10.2017.
 */
public class Main {
    static long[] mass;
    static int counter=0;
    static int position=0;
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
                int min;

                for (i = 0; i < n-1; i++) {
                    min = i;
                    for (int j = i+1; j < n; j++) {
                        if(mass[j]<mass[min]){
                            min=j;
                        }
                    }
                    swap(i, min);
                }
            } finally {
                for (int i = 0; i < mass.length; i++) {
                    System.out.print(mass[i] + " ");
                }
                out.println(counter);
                input.close();
                out.close();
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }

    }

    private static void swap(int j, int i) {
        if(i==j)
            return;
        long temp = mass[j];
        mass[j]=mass[i];
        mass[i]=temp;
        if (i==position) {
            counter++;
            position=j;
        } else if (j==position){
            counter++;
            position=i;
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