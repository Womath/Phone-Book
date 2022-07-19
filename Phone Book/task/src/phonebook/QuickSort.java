package phonebook;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class QuickSort {
    ArrayList<String> names;
    ArrayList<String> numbers;
    Time time;

    QuickSort(ArrayList<String> names, ArrayList<String> numbers, Time time) {
        this.names = names;
        this.numbers = numbers;
        this.time = time;
    }


    public void quicksort(int low, int high) {
        if (low < high) {
            int p = partition(low, high);
            quicksort(low, p - 1);
            quicksort(p + 1, high);
        }
        time.sortingTime();
    }

    void swap(int low, int pivot) {
        String tmp = names.get(low);
        String tmpNum = numbers.get(low);
        names.set(low, names.get(pivot));
        names.set(pivot, tmp);
        numbers.set(low, numbers.get(pivot));
        numbers.set(pivot, tmpNum);
    }

    int partition(int low, int high) {
        int p = low;
        for (int i = low + 1; i <= high; i++) {
            if (names.get(i).compareTo(names.get(low)) < 0) {
                swap(++p, i);
            }
        }
        swap(low, p);
        return p;
    }

    public void log() throws IOException {
        FileWriter fw = new FileWriter("W:\\quickSort.txt");
        for (String s : names) {
            fw.write(s + "\n");
        }
        fw.close();
    }

}
