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
        if (args.length < 2){
            System.out.println("Mistmatched entry. Usage: java.lucas_number <seq_type> <n> ");
            System.out.println("<seq_type> can be either 'artem' or 'lucas'");
            return;
        }

        String seqType = args[0].toLowerCase();
        int n = Integer.parseInt(args[1]);

        System.out.println("Calcing " + seqType + " seq up to" + seqType + "( " + n + ")\n" );
        System.out.printf("%-5s %-15s %20s %-15s %10s%n", "Index", "Number", "Time Taken (ns)", "Value Ratio", "Time Ratio");
    

        long lastTime = 0;
        int lastValue = 0;

        for (int i = 0; i <= n; i++){
            long startTime = System.nanoTime();
            int value = (seqType.equals("lucas")) ? lucas_num(i) : artem_num(i);
            long endTime = System.nanoTime();
            long timeTaken = endTime - startTime;

            double valueRatio = (i > 0) ? (double) value / lastValue : 0;
            double timeRatio = (i > 0) ? (double) timeTaken / lastTime : 0;

            System.out.printf("%-5d %-15s %-20d %-15.4f %-10.4f%n", i, seqType + "(" + i + ")", timeTaken, valueRatio, timeRatio);

            lastTime = timeTaken;
            lastValue = value;
        }
    }
}