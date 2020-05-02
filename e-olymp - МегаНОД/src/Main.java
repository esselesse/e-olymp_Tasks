import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        Scanner stringScanner = new Scanner(s);
        int n = stringScanner.nextInt();
        int m=0;
        if (stringScanner.hasNextInt()){
            m = stringScanner.nextInt();
        } else {
            System.out.println(n);
            return;
        }
        int temp = gcd(n,m);
        while (stringScanner.hasNextInt()) {
            temp = gcd(temp, stringScanner.nextInt());
        }
        System.out.println(temp);
        stringScanner.close();
        in.close();
    }

    public static int gcd(int n, int m){
        while (m != 0)
            m = n % (n = m);
        return n;
    }
}