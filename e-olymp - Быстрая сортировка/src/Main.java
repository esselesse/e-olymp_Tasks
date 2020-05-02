import java.io.*;
import java.util.*;

/**
 * Created by esselesse on 03.10.2017.
 */
public class Main {
    static long[] mass;
    static int n;
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

                mass = new long[100000];
                int i=0;
                while (input.hasNextLong()){
                    mass[i]=input.nextLong();
                    i++;
                }
                n=i;
                for (i = n / 2 - 1; i >= 0; i--)
                    heapify(n, i);

                for (i=n-1; i>=0; i--)
                {
                    swap(0, i);
                    heapify(i, 0);
                }

            } finally {
                for (int i = 0; i < n; i++) {
                    System.out.print(mass[i] + " ");
                    out.print(mass[i] + " ");
                }
                input.close();
                out.close();
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void swap(int j, int i) {
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

    private static void heapify(int n, int i)
    {
        int largest = i;
        int left = 2*i + 1;
        int right = 2*i + 2;

        if (left < n && mass[left] > mass[largest])
            largest = left;

        if (right < n && mass[right] > mass[largest])
            largest = right;

        if (largest != i)
        {
            swap(i, largest);
            heapify(n, largest);
        }
    }



}