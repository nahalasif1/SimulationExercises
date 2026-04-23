package OrientationTask1_5;

import java.util.LinkedList;


public class ServicePoint {

    private final LinkedList<Customer> queue = new LinkedList<>();

    // Accumulated stats (for Task 1_6 average calculation)
    private long totalServiceTime = 0;
    private int  servedCount      = 0;

    // ---------------------------------------------------------------
    // Queue operations
    // ---------------------------------------------------------------


    public void addToQueue(Customer c) {
        queue.addLast(c);
    }


    public Customer removeFromQueue() {
        return queue.removeFirst();
    }

    public boolean isQueueEmpty() {
        return queue.isEmpty();
    }

    public int getQueueSize() {
        return queue.size();
    }

    // ---------------------------------------------------------------
    // Serving
    // ---------------------------------------------------------------


    public void serve() {
        System.out.println("\n--- ServicePoint: starting to serve " + queue.size() + " customer(s) ---");

        while (!isQueueEmpty()) {
            Customer c = removeFromQueue();

            long serviceStart = System.nanoTime();
            c.setServiceStartTime(serviceStart);

            // Random service time between 50 ms and 500 ms
            long sleepMs = 50 + (long)(Math.random() * 451);

            try {
                Thread.sleep(sleepMs);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }

            long departure = System.nanoTime();
            c.setDepartureTime(departure);

            // Accumulate stats
            totalServiceTime += c.getServiceTime();
            servedCount++;

            // Report
            System.out.printf(
                    "%s | Wait: %6.1f ms | Service: %6.1f ms | Response: %6.1f ms%n",
                    c,
                    c.getWaitTime()     / 1_000_000.0,
                    c.getServiceTime()  / 1_000_000.0,
                    c.getResponseTime() / 1_000_000.0
            );
        }

        System.out.println("--- Queue empty. All customers served. ---\n");
    }

    // ---------------------------------------------------------------
    // Statistics (Task 1_6)
    // ---------------------------------------------------------------

    /** Returns average service time across all served customers (ms). */
    public double getAverageServiceTime() {
        if (servedCount == 0) return 0;
        return (totalServiceTime / (double) servedCount) / 1_000_000.0;
    }

    public int getServedCount() {
        return servedCount;
    }

    /** Resets statistics (allows reuse across multiple test runs). */
    public void resetStats() {
        totalServiceTime = 0;
        servedCount = 0;
    }
}