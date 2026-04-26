package OrientationTask3;

import eduni.distributions.Negexp;
import OrientationTask2.EventList;
import OrientationTask2.EventType;

public class ArrivalProcessTest {

    public static void main(String[] args) {
        System.out.println("=== ArrivalProcess Test ===\n");

        Clock clock = Clock.getInstance();
        EventList eventList = new EventList();


        ArrivalProcess arrivalProcess = new ArrivalProcess(
                new Negexp(10), EventType.ARRIVAL
        );


        for (int i = 0; i < 10; i++) {
            arrivalProcess.generateNextEvent(eventList);

            clock.setTime(clock.getTime() + new Negexp(10).sample());
        }

        System.out.println("Generated event list:");
        eventList.print();
    }
}
