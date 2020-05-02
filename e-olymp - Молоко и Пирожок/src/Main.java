import java.util.Scanner;

/**
 * Created by esselesse on 30.09.2017.
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        //int[] mass = new int[n];
        int i=0, temp=0;
        while (i<n){
            if(in.nextDouble()<30)
                temp++;
            i++;
        }
        System.out.println( (temp*200D%900D!=0?temp*200/900+1:temp*200/900) + " " + temp);

    }
}