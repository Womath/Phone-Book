package phonebook;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class HashMapSearch {
    ArrayList<String> names;
    ArrayList<String> numbers;
    HashMap<String, String> map;
    Time time;
    int found = 0;

    HashMapSearch(ArrayList<String> names, ArrayList<String> numbers, Time time) {
        this.names = names;
        this.numbers = numbers;
        this.time = time;
        makeMap();
    }

    void makeMap() {
        map = new LinkedHashMap<>();
        for (int i = 0; i < names.size(); i++) {
            map.put(names.get(i), numbers.get(i));
        }
        time.sortingTime();
    }

    public void search(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        int entries = 0;

        time.startingTime = System.currentTimeMillis();

        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            entries++;

            if (map.containsKey(s)) {
                found++;
            }
        }

        time.searchingTime();
        System.out.print("Found " + found + " / " + entries + " entries. ");
    }


}
