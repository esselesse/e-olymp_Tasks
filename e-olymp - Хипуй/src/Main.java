import java.util.*;
import java.lang.*;
import java.io.*;

class Heap{
    private List<Integer> items;

    public Heap() {
        items = new ArrayList<Integer> ();
    }

    private void shiftUp () {
        int k = items.size();
        while (k > 1){
            int curr = k/2;
            int temp = items.get(k-1);
            int parent = items.get(curr-1);
            if (temp > parent){
                items.set(k-1, parent);
                items.set(curr-1, temp);
                k = curr;
            }
            else break;
        }
    }

    private void shiftDown() {
        int curr = 1;
        int leftChild = 2;
        int rightChild, max;
        while (leftChild < items.size()+1) {
            max = leftChild;
            rightChild = leftChild + 1;
            if (rightChild < items.size()+1) {
                if (items.get(rightChild-1)>items.get(leftChild-1)) {
                    max = rightChild;
                }
            }
            if (items.get(curr-1)< items.get(max-1)) {
                int temp = items.get(curr-1);
                items.set(curr-1, items.get(max-1));
                items.set(max-1, temp);
                curr = max;
                leftChild = 2*curr;
            }
            else break;
        }
    }

    public void insert(int item) {
        items.add(item);
        shiftUp();
    }

    public int delete() throws NoSuchElementException {
        if (items.size() == 0) {
            throw new NoSuchElementException();
        }
        if (items.size() == 1) return items.remove(0);
        int x = items.get(0);
        items.set(0, items.remove(items.size()-1));
        shiftDown();
        return x;
    }

    public int max() {
        return items.get(0);
    }
}

class Main {
    public static void main(String[] args) throws IOException {
        Heap test = new Heap();
        File file = new File("input.txt");
        File file1 = new File("output.txt");
        try {
            if (!file.exists()) {
                file.createNewFile();
            }

            Scanner scanner = new Scanner(file);
            PrintWriter out = new PrintWriter(file1.getAbsoluteFile());

            int n = scanner.nextInt();
            int temp;
            for (int i = 0; i < n; i++) {
                temp = scanner.nextInt();
                if (temp == 0) {
                    test.insert(scanner.nextInt());
                } else {
                    out.println(test.delete());
                }
            }

            out.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}