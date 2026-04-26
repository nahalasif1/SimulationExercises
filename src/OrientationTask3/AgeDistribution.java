package OrientationTask3;

public class AgeDistribution {

    public static void main(String[] args) {
        final int REITERATIONS = 1000;
        final int MAXAGE = 35;


        int[][] agedistribution = {
                {5,  20},   // 5%  age 20
                {20, 21},   // 15% age 21
                {45, 22},   // 25% age 22
                {65, 23},   // 20% age 23
                {80, 24},   // 15% age 24
                {90, 25},   // 10% age 25
                {96, 26},   // 6%  age 26
                {98, 28},   // 2%  age 28
                {100,30},   // 2%  age 30
        };

        int[] generatedAges = new int[MAXAGE + 1];


        for (int i = 1; i <= REITERATIONS; i++) {
            int x = (int)(Math.random() * 100) + 1;
            int j = 0;
            while (x > agedistribution[j][0]) j++;
            generatedAges[agedistribution[j][1]]++;
        }

        System.out.println("Age  Count     %-share");
        System.out.println("----------------------");
        for (int age = 0; age <= MAXAGE; age++) {
            if (generatedAges[age] != 0) {
                System.out.printf("%-4d %-8d %.2f%%%n",
                        age,
                        generatedAges[age],
                        ((double) generatedAges[age]) / REITERATIONS * 100);
            }
        }
    }
}