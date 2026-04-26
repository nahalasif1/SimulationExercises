package OrientationTask2;

import java.util.PriorityQueue;

public class EventList {

    private PriorityQueue<Event> queue = new PriorityQueue<>();

    public void add(Event e) {
        queue.add(e);
    }


    public Event removeNext() {
        return queue.poll();
    }


    public void print() {
        // Copy to a new PriorityQueue to print in order
        PriorityQueue<Event> copy = new PriorityQueue<>(queue);
        System.out.println("Event list (" + copy.size() + " events):");
        while (!copy.isEmpty()) {
            System.out.println("  " + copy.poll());
        }
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}
