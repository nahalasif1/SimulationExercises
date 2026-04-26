package OrientationTask3;

public class ClockTest {

    public static void main(String[] args) {
        // Get the single instance
        Clock clock = Clock.getInstance();

        System.out.println("=== Clock Singleton Test ===\n");

        // Check initial time
        System.out.println("Initial time: " + clock.getTime());

        // Set time
        clock.setTime(10.0);
        System.out.println("After setTime(10.0): " + clock.getTime());

        // Advance time
        clock.advance(5.0);
        System.out.println("After advance(5.0): " + clock.getTime());

        // Verify it's a singleton — both variables point to same object
        Clock clock2 = Clock.getInstance();
        clock2.setTime(99.0);
        System.out.println("\nSet time to 99.0 via clock2");
        System.out.println("clock.getTime(): " + clock.getTime());
        System.out.println("Same instance? " + (clock == clock2));
    }
}