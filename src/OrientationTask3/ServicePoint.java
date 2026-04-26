package OrientationTask3;

import java.util.LinkedList;

public class ServicePoint {

    private LinkedList<Customer> queue = new LinkedList<>();

    public void addToQueue(Customer c) {
        queue.addLast(c);
    }

    public Customer removeFromQueue() {
        return queue.removeFirst();
    }

    public boolean isQueueEmpty() {
        return queue.isEmpty();
    }
}