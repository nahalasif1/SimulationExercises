package OrientationTask1_3;


public class CustomerTest {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== OrientationTask1_3: Customer class test ===\n");


        Customer c1 = new Customer();
        Thread.sleep(50); // simulate some time passing
        Customer c2 = new Customer();
        Thread.sleep(30);
        Customer c3 = new Customer();


        Thread.sleep(100);
        c1.setEndTime(System.nanoTime());
        Thread.sleep(20);
        c2.setEndTime(System.nanoTime());
        Thread.sleep(10);
        c3.setEndTime(System.nanoTime());


        System.out.println(c1);
        System.out.printf("  -> Time spent: %.3f ms%n%n", c1.getTimeSpent() / 1_000_000.0);

        System.out.println(c2);
        System.out.printf("  -> Time spent: %.3f ms%n%n", c2.getTimeSpent() / 1_000_000.0);

        System.out.println(c3);
        System.out.printf("  -> Time spent: %.3f ms%n%n", c3.getTimeSpent() / 1_000_000.0);


        System.out.printf("Customer IDs: %d, %d, %d (expected 1, 2, 3)%n",
                c1.getId(), c2.getId(), c3.getId());
    }
}
