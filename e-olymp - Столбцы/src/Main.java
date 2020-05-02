/**
 * Created by esselesse on 05.10.2017.
 */
import javafx.collections.transformation.SortedList;

import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int x = in.nextInt();
        int n = in.nextInt();
        int temp;
        List<Integer> list= new ArrayList<>();
        int[][] mass = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                temp = in.nextInt();
                if(temp==x){
                    if(!list.contains(j))
                        list.add(j);
                }
            }
        }

        Collections.sort(list);
        for (int i = 0; i < n; i++) {
            if(list.indexOf(i)!=-1){
                System.out.println("YES");
            }
            else {
                System.out.println("NO");
            }
        }

    }
}