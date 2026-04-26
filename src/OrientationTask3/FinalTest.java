package OrientationTask3;

import eduni.distributions.Negexp;
import OrientationTask2.Event;
import OrientationTask2.EventList;
import OrientationTask2.EventType;

public class FinalTest {

    public static void main(String[] args) {
        System.out.println("=== P7 Final Test ===\n");

        Clock clock = Clock.getInstance();
        clock.setTime(0);

        EventList eventList = new EventList();
        ArrivalProcess arrivalProcess = new ArrivalProcess(
                new Negexp(10), EventType.ARRIVAL
        );
        ServicePoint servicePoint = new ServicePoint();


        System.out.println("--- Generating 10 arrival events ---");
        for (int i = 0; i < 10; i++) {
            arrivalProcess.generateNextEvent(eventList);
            clock.setTime(clock.getTime() + new Negexp(10).sample());
        }
        System.out.println("Clock after generating events: " + clock.getTime());
        eventList.print();


        System.out.println("\n--- Processing events, adding customers to ServicePoint ---");
        Customer.resetIdCounter();
        while (!eventList.isEmpty()) {
            Event e = eventList.removeNext();
            Customer c = new Customer();
            c.setArrivalTime(e.getTime());
            servicePoint.addToQueue(c);
            System.out.printf("Customer #%d added, arrival time: %.1f%n",
                    c.getId(), e.getTime());
        }



        clock.advance(5);
        System.out.println("\nClock advanced by 5 → " + clock.getTime());


        System.out.println("\n--- Serving customers ---");
        while (!servicePoint.isQueueEmpty()) {
            Customer c = servicePoint.removeFromQueue();
            c.setDepartureTime(clock.getTime());
            System.out.printf("Customer #%d | Arrival: %.1f | Departure: %.1f | Time in system: %.1f%n",
                    c.getId(), c.getArrivalTime(), c.getDepartureTime(), c.getTimeInSystem());
        }
    }
}