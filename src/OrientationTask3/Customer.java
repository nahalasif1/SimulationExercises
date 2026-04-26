package OrientationTask3;

public class Customer {

    private static int nextId = 1;
    private final int id;
    private double arrivalTime;
    private double departureTime;

    public Customer() {
        this.id = nextId++;
    }

    public int getId() { return id; }

    public double getArrivalTime() { return arrivalTime; }
    public void setArrivalTime(double t) { this.arrivalTime = t; }

    public double getDepartureTime() { return departureTime; }
    public void setDepartureTime(double t) { this.departureTime = t; }

    public double getTimeInSystem() { return departureTime - arrivalTime; }

    public static void resetIdCounter() { nextId = 1; }
}