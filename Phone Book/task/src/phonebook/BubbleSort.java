package phonebook;

import java.io.IOException;
import java.util.ArrayList;

public class BubbleSort {

    ArrayList<String> names;
    ArrayList<String> numbers;
    Time time;

    BubbleSort(ArrayList<String> names, ArrayList<String> numbers, Time time) {
        this.names = names;
        this.numbers = numbers;
        this.time = time;
    }

    public boolean sort(Time linearTime) throws IOException {

        for (int x = 0; x < names.size(); x++) {
            for (int i = 0; i < names.size() - x - 1; i++) {
                if (names.get(i + 1).compareTo(names.get(i)) < 0) {
                    String s = names.get(i);
                    names.remove(i);
                    names.add(i + 1, s);
                    String n = numbers.get(i);
                    numbers.remove(i);
                    numbers.add(i + 1, n);
                    time.sortingTime();
                    if (time.sortingTime > 10 * linearTime.searchingTime) {
                        return false;
                    }
                }
            }
            time.sortingTime();
        }
        /*FileWriter fileWriter = new FileWriter("W:\\bubbleSortedSmallNames.txt");
        for (String s : names) {
            fileWriter.write(s);
            fileWriter.write("\n");
        }
        fileWriter.close();*/
        return true;
    }
}
