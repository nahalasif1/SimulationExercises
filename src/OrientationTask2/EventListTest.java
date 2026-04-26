package OrientationTask2;

public class EventListTest {

    public static void main(String[] args) {
        EventList eventList = new EventList();

        // a) Generate events with types
        eventList.add(new Event(15.0, EventType.DEPARTURE));
        eventList.add(new Event(3.0,  EventType.ARRIVAL));
        eventList.add(new Event(7.5,  EventType.DEPARTURE));
        eventList.add(new Event(1.0,  EventType.ARRIVAL));
        eventList.add(new Event(10.0, EventType.ARRIVAL));

        System.out.println("--- Initial event list ---");
        eventList.print();

        // b) Remove next event
        Event next = eventList.removeNext();
        System.out.println("\n--- Removed next event ---");
        System.out.println("  Removed: " + next);

        // c) Print remaining
        System.out.println("\n--- Remaining event list ---");
        eventList.print();
    }
}