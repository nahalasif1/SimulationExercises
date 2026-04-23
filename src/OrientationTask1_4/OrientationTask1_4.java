package OrientationTask1_4;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * OrientationTask1_4 – Interactive FIFO queue demo.
 *
 * The user can:
 *   q  – enqueue a new customer (addFirst)
 *   d  – dequeue the oldest customer (removeLast) and print time spent in queue
 *   x  – exit
 *
 * FIFO is achieved with LinkedList:
 *   new customers → addFirst (head)
 *   served customer ← removeLast (tail, the one that has been waiting longest)
 */
public class OrientationTask1_4 {


    static int nextId = 1;

    static class Customer {
        private final int id;
        private final long arrivalTime; // nanoseconds

        Customer() {
            this.id = nextId++;
            this.arrivalTime = System.nanoTime();
        }

        int getId() { return id; }
        long getArrivalTime() { return arrivalTime; }
    }

    public static void main(String[] args) {
        System.out.println("=== OrientationTask1_4: Interactive FIFO Queue ===");
        System.out.println("Commands:  q = enqueue new customer | d = dequeue (serve) | x = exit\n");

        LinkedList<Customer> queue = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Action (q/d/x): ");
            String input = scanner.nextLine().trim().toLowerCase();

            switch (input) {
                case "q":
                    Customer newCustomer = new Customer();
                    queue.addFirst(newCustomer);  // FIFO: newest at head
                    System.out.printf("  Enqueued Customer #%d. Queue size: %d%n%n",
                            newCustomer.getId(), queue.size());
                    break;

                case "d":
                    if (queue.isEmpty()) {
                        System.out.println("  Queue is empty — nobody to serve.\n");
                    } else {
                        Customer served = queue.removeLast(); // oldest at tail
                        long waitNs = System.nanoTime() - served.getArrivalTime();
                        System.out.printf("  Dequeued Customer #%d | Time in queue: %.3f ms | Queue size: %d%n%n",
                                served.getId(), waitNs / 1_000_000.0, queue.size());
                    }
                    break;

                case "x":
                    System.out.println("Exiting. Remaining in queue: " + queue.size());
                    scanner.close();
                    return;

                default:
                    System.out.println("  Unknown command. Use q, d, or x.\n");
            }
        }
    }
}