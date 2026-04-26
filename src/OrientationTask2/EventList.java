package OrientationTask2;

import java.util.PriorityQueue;

public class EventList {

    private PriorityQueue<Event> queue = new PriorityQueue<>();

    // Add an event to the list
    public void add(Event e) {
        queue.add(e);
    }

    // Remove and return the next event (earliest time)
    public Event removeNext() {
        return queue.poll();
    }

    // Print all events in chronological order
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
