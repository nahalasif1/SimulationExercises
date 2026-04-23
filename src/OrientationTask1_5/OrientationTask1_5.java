package OrientationTask1_5;


public class OrientationTask1_5 {

    private static final int N_RUNS           = 3;   // number of test runs
    private static final int CUSTOMERS_PER_RUN = 5;  // customers per run

    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("  Service Point Simulation");
        System.out.println("  Runs: " + N_RUNS + " | Customers/run: " + CUSTOMERS_PER_RUN);
        System.out.println("========================================\n");

        ServicePoint servicePoint = new ServicePoint();

        for (int run = 1; run <= N_RUNS; run++) {
            System.out.println("╔══════════════════════════════╗");
            System.out.println("║          RUN " + run + " of " + N_RUNS + "           ║");
            System.out.println("╚══════════════════════════════╝");

            // Reset ID counter and stats for a clean run
            Customer.resetIdCounter();
            servicePoint.resetStats();

            // Task 1_5: generate customers into the queue
            CustomerGenerator.generate(servicePoint, CUSTOMERS_PER_RUN);

            // Task 1_5: serve all customers
            servicePoint.serve();

            // Task 1_6: report average service time
            System.out.printf(
                    ">>> Run %d summary: %d customers served | Avg service time: %.1f ms%n%n",
                    run,
                    servicePoint.getServedCount(),
                    servicePoint.getAverageServiceTime()
            );
        }

        System.out.println("========================================");
        System.out.println("  Simulation complete.");
        System.out.println("========================================");
    }
}