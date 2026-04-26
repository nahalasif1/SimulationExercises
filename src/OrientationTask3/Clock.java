package OrientationTask3;

public class Clock {


    private static Clock instance;

    private double time;


    private Clock() {
        this.time = 0;
    }


    public static Clock getInstance() {
        if (instance == null) {
            instance = new Clock();
        }
        return instance;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public void advance(double amount) {
        this.time += amount;
    }
}