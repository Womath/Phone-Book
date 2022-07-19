package phonebook;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class BinarySearch {

    ArrayList<String> names;
    ArrayList<String> numbers;
    int found = 0;
    Time time;


    BinarySearch (ArrayList<String> names, ArrayList<String> numbers, Time time) {
        this.names = names;
        this.numbers = numbers;
        this.time = time;
    }

    public void search(File file) throws IOException {

        Scanner scanner = new Scanner(file);

        int entries = 0;

        Search:
        while (scanner.hasNext()) {

            int left = 0;
            int right = names.size() - 1;

            String s = scanner.nextLine();
            entries++;
            while (left <= right) {

                int middle = (left + right) / 2;

                if (names.get(middle).equals(s)) {
                    found++;
                    time.searchingTime();
                    continue Search;
                } else if (names.get(middle).compareTo(s) > 0) {
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }

            }
        }
        System.out.print("Found " + found + " / " + entries + " entries. ");

    }
}
