package phonebook;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class JumpSearch {
    ArrayList<String> names;
    ArrayList<String> numbers;
    int found = 0;
    Time time;

    JumpSearch(ArrayList<String> names, ArrayList<String> numbers, Time time) {
        this.names = names;
        this.numbers = numbers;
        this.time = time;
    }

    public void search(File file) throws IOException {

        Scanner scanner = new Scanner(file);

        int entries = 0;
        Scan:
        while (scanner.hasNext()) {
            int counter = 0;
            String s = scanner.nextLine();
            entries++;
            int step = (int) Math.floor(Math.sqrt(this.names.size()));

            while (counter < this.names.size()) {
                if (this.names.get(counter).equals(s)) {
                    found++;
                    continue Scan;
                } else if (this.names.get(counter).compareTo(s) > 0) {
                    int i = counter - 1;
                    while (i > counter - step && i >= 0) {
                        if (this.names.get(i).equals(s)) {
                            found++;
                            continue Scan;
                        }
                        i--;
                    }
                }
                counter += step;
            }

            int i = this.names.size() - 1;
            while (i > counter - step) {
                if (this.names.get(i).equals(s)) {
                    found++;
                    continue Scan;
                }
                i--;
            }
        }
        time.searchingTime();
        System.out.print("Found " + found + " / " + entries + " entries. ");
    }
}
