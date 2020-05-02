import java.util.Scanner;

/**
 * Created by esselesse on 09.10.2017.
 */
public class Main {
    static boolean flag = true;
    static MyList myList = new MyList();

    public static void push(long n){
        myList.add(n);
        System.out.println("ok");
    }

    public static void pop(){
        System.out.println(Long.toString(myList.pop()));
    }

    public static void front(){
        System.out.println(Long.toString(myList.front()));
    }

    public static void size(){
        System.out.println(Long.toString(myList.size()));
    }

    public static void clear(){
        myList.clear();
        System.out.println("ok");
    }

    public static void exit(){
        flag = false;
        System.out.println("bye");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s;
        long temp;

        while (flag){
            s=in.next();
            if (s.equalsIgnoreCase("push")){
                temp = in.nextLong();
                push(temp);
            } else if (s.equalsIgnoreCase("size")){
                size();
            } else if (s.equalsIgnoreCase("pop")){
                pop();
            } else if (s.equalsIgnoreCase("exit")){
                exit();
            } else if (s.equalsIgnoreCase("front")){
                front();
            } else if (s.equalsIgnoreCase("clear")){
                clear();
            }
        }
    }
}

class MyList{

    static long size=0;
    long number;
    MyList next = null;
    static MyList last = null;


    public MyList(long n){
        this.number = n;
        this.size++;
    }

    public MyList(){
        last=this;
    }

    public void add(long n){
        if(this.size==0){
            this.size++;
            this.number = n;
            return;
        }
//        MyList temp = this;
//
//        while (temp.next!=null)
//            temp=temp.next;
//        temp.next = new MyList(n);

        while (last.next!=null)
            last = last.next;
        last.next=new MyList(n);

        //last = last.next;
    }

    public long pop(){
        long temp = this.number;
        if (this.size!=1){
            this.number = this.next.number;
            this.next = this.next.next;
        }
        this.size--;
        return (temp);
    }

    public long front(){
        return(this.number);
    }

    public long size() {
        return(this.size);
    }

    public void clear(){
        this.size=0;
        this.next=null;
        last=this;
    }
}