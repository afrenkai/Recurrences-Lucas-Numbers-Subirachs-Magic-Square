import java.util.Scanner;
//current ideas: order of growth approaches golden ratio. rest are fibonacci seq i thiunk
//TODO: implement custom sequence (artem_num) and add an arg for it using args[]. potentially remove the calcs from main to reduce code bloat in main to allow me to use any number of custom sequences.
//trivia fact, Lucas is known also for the Fibonacci Sequence and the tower of hanoi
public class lucas_number{
    
    public static int lucas_num (int n){
        if (n == 0){
            return 2; //L(0) = 2
        }
        else if (n == 1){
            return 1; //L(1) = 1
        }
        else {
            return lucas_num(n-1) + lucas_num(n-2); //L(n) = L(n-1) + L(n-2) for n > 1
        }
    }

    public static int artem_num (int n){
        if ( n == 0){
            return 1;
        }
        else if (n == 1) {
            return 19;
        }
        else {
            return artem_num(n-2) - artem_num(n-1); //A(n) = A(n-2) - A(n-1) for n > 1 
        }
    }


    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter n for the lucas numbers: ");
        int n = scanner.nextInt();

        System.out.println("Calculating Lucas Sequence up to L of " + n + "\n");

        long last_time = 0;
        int last_val = 0;

        for (int i = 0; i <= n; i++){
            long start = System.nanoTime();
            int lucas_val = lucas_num(i);
            long end = System.nanoTime();
            long time_took = end -start;

            System.out.println("L(" + i + ") = " + lucas_val + ", Time Taken: " + time_took + " ns");

            if (i > 0){
                double value_ratio = (double) lucas_val / last_val;
                double time_ratio = (double) time_took / last_time;

                System.out.println("L(" + i + ")/L(" + (i - 1) + ") = " + value_ratio);
                System.out.println("Time(L(" + i + ")) / Time(L(" + (i - 1) + ")) = " + time_ratio);
            }

            last_time = time_took;
            last_val = lucas_val;
        }
        
        scanner.close();
    }
}