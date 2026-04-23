
package OrientationTask1_5;


public class CustomerGenerator {


    public static void generate(ServicePoint servicePoint, int count) {
        System.out.println("Generating " + count + " customer(s)...");
        for (int i = 0; i < count; i++) {
            Customer c = new Customer();
            servicePoint.addToQueue(c);
            System.out.println("  Added " + c + " to queue.");
        }
    }
}
