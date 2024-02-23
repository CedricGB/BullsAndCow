package bullscows;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        int length = 0;
        int numberOfPossibleSymbols = 0;

        Scanner scanner = new Scanner(System.in);
        // ---
        System.out.println("Input the length of the secret code:\n");
        String input = scanner.nextLine();
        if(isInputAnInteger(input) && !input.isEmpty()){
            length = Integer.parseInt(input);
            if(length == 0){
                System.out.println("Error");
                System.exit(0);
            }
        } else {
            System.exit(0);
        }
        // ---
        System.out.println("Input the number of possible symbols in the code:\n");
        input = scanner.nextLine();
        if(isInputAnInteger(input) && !input.isEmpty()){
            numberOfPossibleSymbols = Integer.parseInt(input);
        } else {
            System.exit(0);
        }
        // ---
        if(numberOfPossibleSymbols < length  ){
            System.out.printf("Error: it's not possible to generate a code with a length of %d with %d unique symbols.\n", length, numberOfPossibleSymbols);
            System.exit(0);
        } else if(numberOfPossibleSymbols > 36){
            System.out.println("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).\n");
            System.exit(0);
        }

        SecretCode secretCode = new SecretCode(length, numberOfPossibleSymbols);
        secretCode.start();

        Grader grader = new Grader(secretCode);
        int turn = 1;
        while(true){
            System.out.printf("Turn %d \n", turn);
            grader.setDigits(scanner.nextLine());
            if(grader.gradeTheInput()){
                break;
            }
            turn++;
        }
    }

    public static boolean isInputAnInteger(String input){
        try{
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException  e){
            System.out.printf("Error: \"%s\" isn't a valid number.", input);
            return false;
        }

    }

}
