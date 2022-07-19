package phonebook;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class LinearSearch {
    ArrayList<String> names;
    ArrayList<String> numbers;
    int found = 0;
    Time time;

    LinearSearch(ArrayList<String> names, ArrayList<String> numbers, Time time) {
        this.names = names;
        this.numbers = numbers;
        this.time = time;
    }

    public void search(File file) throws FileNotFoundException {

        Scanner scanner = new Scanner(file);
        int entries = 0;

        while (scanner.hasNext()) {
            entries++;
            String s = scanner.nextLine();
            for (int i = 0; i < names.size(); i++) {
                if (names.get(i).equals(s)) {
                    String telNum = numbers.get(i);
                    //System.out.println("Name: " + s + ", Found: " + names.get(i) + ", " + telNum);
                    found++;
                    time.searchingTime();
                    break;
                }
            }
        }

        System.out.print("Found " + found + " / " + entries + " entries. ");
    }

}
