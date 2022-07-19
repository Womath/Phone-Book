package phonebook;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("W:\\Letöltések\\directory.txt");
        Scanner scanner = new Scanner(file);

        ArrayList<String> names = new ArrayList<>();
        ArrayList<String> numbers = new ArrayList<>();
        while (scanner.hasNext()) {
            numbers.add(scanner.next());
            names.add(scanner.nextLine().trim());
        }


        File searchFile = new File("W:\\Letöltések\\find.txt");
        Time linearTime = new Time();
        LinearSearch linearSearch = new LinearSearch(names, numbers, linearTime);
        System.out.println("Start searching (linear search)...");
        linearSearch.search(searchFile);
        System.out.println(linearTime.toString(linearTime.searchingTime) + "\n");


        Time bubbleTime = new Time();
        BubbleSort bubbleSort = new BubbleSort(names, numbers, bubbleTime);
        System.out.println("Start searching (bubble sort + jump search)...");
        if (bubbleSort.sort(linearTime)) {
            Time jumpSearchTime = new Time();
            JumpSearch jumpSearch = new JumpSearch(bubbleSort.names, bubbleSort.numbers, jumpSearchTime);
            jumpSearch.search(searchFile);
            System.out.println(jumpSearchTime.toString(jumpSearchTime.searchingTime, bubbleTime.sortingTime, false) + "\n");
        } else {
            Time anotherLinearTime = new Time();
            LinearSearch anotherLinearSearch = new LinearSearch(bubbleSort.names, bubbleSort.numbers, anotherLinearTime);
            anotherLinearSearch.search(searchFile);
            System.out.println(anotherLinearTime.toString(anotherLinearTime.searchingTime, bubbleTime.sortingTime, true) + "\n");
        }


        Time quicksortTime = new Time();
        QuickSort quickSort = new QuickSort(names, numbers, quicksortTime);
        System.out.println("Start searching (quick sort + binary search)...");
        quickSort.quicksort(0, quickSort.names.size() - 1);
        quickSort.log();

        Time binarySearchTime = new Time();
        BinarySearch binarySearch = new BinarySearch(quickSort.names, quickSort.numbers, binarySearchTime);
        binarySearch.search(searchFile);
        System.out.println(binarySearchTime.toString(binarySearchTime.searchingTime, quicksortTime.sortingTime, false) + "\n");


        Time hashTime = new Time();
        System.out.println("Start searching (hash table)...");
        HashMapSearch hashMapSearch = new HashMapSearch(names, numbers, hashTime);
        hashMapSearch.search(searchFile);
        System.out.println(hashTime.toString(hashTime.searchingTime, hashTime.sortingTime));
    }
}
