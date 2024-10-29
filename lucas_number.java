import java.util.Scanner;
//current ideas: validation
//trivia fact, Lucas is known also for the Fibonacci Sequence
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



    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter n for the lucas numbers: ");
        int n = scanner.nextInt();

        System.out.println("Calculating Lucas Sequence up to L of " + n);

        for (int i = 0; i <= n; i++){
            System.out.println(lucas_num(i) + " ");
        }
        scanner.close();
    }
}