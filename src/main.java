import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        Scanner sc = new Scanner(System.in);
        int sizeArray = 0;
        int counter = 0;
        double euroPerLiter = 0;
        double maxKm = 0;
        double maxLiters = 0;

        System.out.println("Price of diesel/bensin: ");
        euroPerLiter = sc.nextDouble();
        System.out.println("Range when fully fueled: ");
        maxKm = sc.nextDouble();
        System.out.println("Max size of tank: ");
        maxLiters = sc.nextDouble();
        System.out.println("How many values are you going to register?: ");
        sizeArray = sc.nextInt();
        counter = sizeArray;
        double[] array = new double[sizeArray];
        int[] values = new int[sizeArray];

        System.out.println("Type in the values to insert into the array");
        for (int i = 0; i < sizeArray; i++) {
            System.out.println("Values remaining:" + counter);
            counter--;
            double arrayValue = sc.nextDouble();
            array[i] = arrayValue;
            values[i] = i;
        }

        printOut(array, values, euroPerLiter, maxKm, maxLiters);
    }
    public static void printOut(double[] array, int[] values, double euroPerLiter,
                                double maxKm, double maxLiters) {
        System.out.println("***************************************");
        algorithm(array, values, euroPerLiter, maxKm, maxLiters);
        System.out.println("***************************************");
    }
    public static void algorithm(double[] array, int[] values,
                                 double euroPerLiter, double maxKm, double maxLiters) {
        for (int j = 0; j < values.length; j++) {
            int initial = values[j];
            for (int i = 0; i < values.length - 1; i++) {
                int target = values[i + 1];
                if (target != values.length && initial < target) {
                    calculate(initial, target, array, euroPerLiter, maxKm, maxLiters);
                }
            }
        }
    }
    public static void calculate(int initial, int target, double[] array,
                                 double euroPerLiter, double maxKm, double maxLiters) {
        // a2 - a1 = a1->2
        int tar = target;
        int ini = initial;
        double sum = 0;
        double km = 0;
        double sum_price = 0;

        sum = array[tar] - array[ini];
        km = maxKm * array[target - initial] / maxLiters;
        sum_price = euroPerLiter * array[target - initial];

        System.out.println("a" + ini + "->"
                + "a" + tar + ": " + sum + " Liters " + km + "km " + sum_price + "€ ");
    }
}