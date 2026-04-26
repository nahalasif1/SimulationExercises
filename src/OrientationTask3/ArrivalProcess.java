package OrientationTask3;

import eduni.distributions.ContinuousGenerator;
import OrientationTask2.Event;
import OrientationTask2.EventList;
import OrientationTask2.EventType;

public class ArrivalProcess {

    private ContinuousGenerator generator;
    private EventType eventType;

    public ArrivalProcess(ContinuousGenerator generator, EventType eventType) {
        this.generator = generator;
        this.eventType = eventType;
    }

    public void generateNextEvent(EventList eventList) {
        double interval = generator.sample();
        double eventTime = Clock.getInstance().getTime() + interval;
        eventList.add(new Event(eventTime, eventType));
    }
}