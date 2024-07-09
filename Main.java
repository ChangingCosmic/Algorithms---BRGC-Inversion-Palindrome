import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What string do you want check for palindrome? ");
        String input = scanner.nextLine();

        Palindrome userString = new Palindrome(input);
        System.out.println("Is the string \"" + userString.printString() + "\" a palindrome? " + userString.palindromecheck());

        Palindrome p1 = new Palindrome("NEVER OdD or even!!!!!$@%^$%$!");
        System.out.println("Is the string \"" + p1.printString() + "\" a palindrome? " + p1.palindromecheck());

        Palindrome p2 = new Palindrome("Able was I ere I saw Elba.");
        System.out.println("Is the string \"" + p2.printString() + "\" a palindrome? " + p2.palindromecheck());

        Palindrome p3 = new Palindrome("A man, a plan, a canal: Panama!");
        System.out.println("Is the string \"" + p3.printString() + "\" a palindrome? " + p3.palindromecheck());

        Palindrome p4 = new Palindrome("123!!!!!!!@#!@#!@321");
        System.out.println("Is the string \"" + p4.printString() + "\" a palindrome? " + p4.palindromecheck());

        System.out.println("\n* * * * * * * * * * * * *  * * * * * *");

        Inversion inv1;
        System.out.println("Do you want to enter a list of numbers? y/n");
        input = scanner.nextLine();
        if(input.equals("y")){
            System.out.println("How many numbers? ");
            int userNum = scanner.nextInt();
            int[] userArr = new int[userNum];

            for(int i = 0; i < userNum; i++) {
                System.out.println("Enter a number: ");
                int userInputNum = scanner.nextInt();
                userArr[i] = userInputNum;
            }

            System.out.println("Making object...");

            inv1 = new Inversion(userArr);
        } else {
            inv1 = new Inversion();
        }

        System.out.println("The easyInversionCount function counted: " + inv1.easyInversionCount() + " inversions.");
        System.out.println("The fastInversionCount function counted: " + inv1.fastInvCount() + " inversions... but faster.");

        System.out.println("\n* * * * * * * * * * * * *  * * * * * *");

        // ask if want fitz and giggles or not
        System.out.print("Do you want (1) without Fitz and Giggles, or (2) with Fitz and Giggles? ");
        int userNum = scanner.nextInt();
        BRGC b1 = new BRGC();
        b1.printBRGCandManiacStuff(userNum);

    }
}

// 3 5 9 1 6 7 2 0