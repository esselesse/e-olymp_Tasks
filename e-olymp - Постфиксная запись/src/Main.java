import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        Scanner stringScanner = new Scanner(s);

        Stack<Long> longStack = new Stack<Long>();
        long result=0;
        String op;
        while (stringScanner.hasNext()){
            if(stringScanner.hasNextLong()){
                longStack.push(stringScanner.nextLong());
            } else if (stringScanner.hasNext()){
                result = longStack.pop();
                op = stringScanner.next();

                if(op.equalsIgnoreCase("+")){
                    result+=longStack.pop();
                    longStack.push(result);
                } else if(op.equalsIgnoreCase("-")){
                    result=longStack.pop()-result;
                    longStack.push(result);
                } else if(op.equalsIgnoreCase("*")){
                    result*=longStack.pop();
                    longStack.push(result);
                }


            }
        }

        System.out.println(longStack.pop());
        stringScanner.close();
        in.close();
    }
}