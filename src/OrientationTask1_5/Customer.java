package OrientationTask1_5;


public class Customer {

    private static int nextId = 1;

    private final int id;
    private final long arrivalTime;   // when the customer joined the queue (ns)
    private long serviceStartTime;    // when service began (ns)
    private long departureTime;       // when service finished (ns)

    public Customer() {
        this.id = nextId++;
        this.arrivalTime = System.nanoTime();
    }


    public void setServiceStartTime(long t) { this.serviceStartTime = t; }
    public void setDepartureTime(long t)    { this.departureTime = t; }


    public int    getId()              { return id; }
    public long   getArrivalTime()     { return arrivalTime; }
    public long   getServiceStartTime(){ return serviceStartTime; }
    public long   getDepartureTime()   { return departureTime; }


    public long getWaitTime()    { return serviceStartTime - arrivalTime; }


    public long getServiceTime() { return departureTime - serviceStartTime; }


    public long getResponseTime(){ return departureTime - arrivalTime; }


    public static void resetIdCounter() { nextId = 1; }

    @Override
    public String toString() {
        return String.format("Customer #%d", id);
    }
}
