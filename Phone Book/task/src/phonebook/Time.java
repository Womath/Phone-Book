package phonebook;

public class Time {
    long startingTime;
    long sortingTime;
    long searchingTime;

    Time() {
        this.startingTime = System.currentTimeMillis();
    }

    public void sortingTime() {
        this.sortingTime = System.currentTimeMillis() - startingTime;
    }

    public void searchingTime() {
        this.searchingTime = System.currentTimeMillis() - startingTime;
    }

    public String toString(long time) {
        return "Time taken: " + toTime(time);
    }

    public String toString(long searchingTime, long sortingTime, boolean isStopped) {
        long time = searchingTime + sortingTime;
        if (isStopped) {
            return "Time taken: " + toTime(time) + "\n" +
                    "Sorting time: " + toTime(sortingTime) + " - STOPPED, moved to linear search\n" +
                    "Searching time: " + toTime(searchingTime);
        } else {
            return "Time taken: " + toTime(time) + "\n" +
                    "Sorting time: " + toTime(sortingTime) + "\n" +
                    "Searching time: " + toTime(searchingTime);
        }
    }

    public String toString(long searchingTime, long sortingTime) {
        long time = searchingTime + sortingTime;
        return "Time taken: " + toTime(time) + "\n" +
                "Creating time: " + toTime(sortingTime) + "\n" +
                "Searching time: " + toTime(searchingTime);
    }

    public String toTime(long time) {
        long min = time / 60000;
        time %= 60000;
        long sec = time / 1000;
        long ms = time % 1000;

        return min + " min. " + sec + " sec. " + ms + " ms.";
    }

    public void setSearchingTime(Long n) {
        this.searchingTime = n;
    }
}
