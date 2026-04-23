package OrientationTask1_3;


public class Customer {

    private static int nextId = 1; // Class-level counter; first customer gets id=1

    private final int id;
    private long startTime;
    private long endTime;

    /** Creates a new Customer. ID is assigned automatically. Start time is set to now. */
    public Customer() {
        this.id = nextId++;
        this.startTime = System.nanoTime();
        this.endTime = 0;
    }



    public int getId() {
        return id;
    }

    public long getStartTime() {
        return startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    /**
     * Returns the total time spent (end - start) in nanoseconds.
     * Returns 0 if the customer has not yet been given an end time.
     */
    public long getTimeSpent() {
        if (endTime == 0) return 0;
        return endTime - startTime;
    }



    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return String.format("Customer{id=%d, startTime=%d, endTime=%d, timeSpent=%d ns}",
                id, startTime, endTime, getTimeSpent());
    }
}
