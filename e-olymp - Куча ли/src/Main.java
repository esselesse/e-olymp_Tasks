import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] mass = new int[n+1];
        for (int i = 1; i <= n; i++) {
            if(in.hasNextInt())
            mass[i]=in.nextInt();
        }

        System.out.println(IsHeap(mass, n)?"YES":"NO");

        in.close();
    }

    private static boolean IsHeap(int[] mass, int n) {

        for (int i = n; i > 1 ; i--) {
            if(mass[i]<mass[i/2]){
                return false;
            }
        }
        return true;
    }
}