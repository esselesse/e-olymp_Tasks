import java.io.*;
import java.util.*;

/**
 * Created by esselesse on 03.10.2017.
 */
public class Main {
    static long[][] mass;
    static long[][] temp;
    static int n;
    //static int[] indexMass;
    //static int[] tempIndexMass;
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
                n = input.nextInt();
                mass = new long[n][2];
                temp = new long[n][2];
//                indexMass = new int[n];
//                tempIndexMass = new int[n];
                int i=0;
                while (input.hasNextLong()){
                    mass[i][0]=input.nextLong();
                    mass[i][1]=input.nextLong();
                    //indexMass[i]=i;
                    i++;
                }


                sort(0,n-1);
                //sort();



            } finally {
                for (int i = 0; i < n; i++) {
                    //System.out.println(mass[indexMass[i]][0] + " " + mass[indexMass[i]][1]);
                    //out.println(mass[indexMass[i]][0] + " " + mass[indexMass[i]][1]);
                    out.println(mass[i][0] + " " + mass[i][1]);
                }
                input.close();
                out.close();
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void sort(int left, int right){
        if (left>=right) return;
        int mid = (left+right)/2;
        sort(left, mid);
        sort(mid+1, right);
        merge(left, mid, right);

    }

//    private static void sort(){
//        int n = mass.length;
//        int t[] = new int[n];
//        for (int len = 1; len < n; len *= 2) {
//            for (int left = 0; left < n - len; left += len + len) {
//                int mid = left + len - 1;
//                int right = Math.min(left + len + len - 1, n - 1);
//                merge(left, mid, right);
//            }
//        }
//
//    }

    private static void merge(int left, int mid, int right){
        for (int i = left; i <= right; i++) {
            //tempIndexMass[i]=indexMass[i];
            temp[i]=mass[i];
        }
        int i = left;
        int j = mid+1;
        for (int k = left; k <= right; k++) {
            if (i>mid) {
                //indexMass[k] = tempIndexMass[j++];
                mass[k]=temp[j++];
            }
            else if(j>right) {
                //indexMass[k] = tempIndexMass[i++];
                mass[k]=temp[i++];
            }
            else if(temp[j][0]<temp[i][0]) {
            //else if(mass[tempIndexMass[j]][0]<mass[tempIndexMass[i]][0]) {
                //indexMass[k] = tempIndexMass[j++];
                mass[k]=temp[j++];
            }
            else {
                //indexMass[k] = tempIndexMass[i++];
                mass[k]=temp[i++];
            }
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