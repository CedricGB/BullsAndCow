package bullscows;

import java.util.LinkedList;

public class SecretCode {

    private String fullCode;
    private int numberOfPossibleSymbols;
    public SecretCode(int length, int numberOfPossibleSymbols){
        this.fullCode = "";
        this.numberOfPossibleSymbols = numberOfPossibleSymbols;
        setFullDigits(length);

    }
    public String getFullDigits(){
        return this.fullCode;
    }

    public void setFullDigits(int length){

            while(this.fullCode.length() < length){
                String memberOfSecretCode = String.valueOf((char) createDigits());
                if(!this.fullCode.contains(memberOfSecretCode)){
                    this.fullCode = this.fullCode + memberOfSecretCode;
                }
            }

    }
    // a to z ASCII range [97 to 122]
    // 0 to 9 ASCII range [48 to 57]
    private int createDigits(){
        int min = 1;
        int max = 2;
        // random to decide if we are going for ASCII alphabet or numerical
        int digitToReturn = 0;
        while(true){
            if(this.numberOfPossibleSymbols < 11){
                min = 48;
                max = min + this.numberOfPossibleSymbols -1 ;
                digitToReturn = (int)Math.floor(Math.random()* (max - min +1) + min);
            } else {
                if((int)Math.floor(Math.random()* (max - min +1) + min) == 1){
                    // alphabet , we choose the max by soustracting 10 because it's the value of the number
                    min = 97;
                    max = min + this.numberOfPossibleSymbols - 10 ;
                    digitToReturn = (int)Math.floor(Math.random()* (max - min +1) + min);
                } else {
                    min = 48;
                    max = min + 9;
                    digitToReturn = (int)Math.floor(Math.random()* (max - min +1) + min);

                }
            }
            char digitToChar = (char) digitToReturn;

            // To keep unique symbols
            if(!this.fullCode.contains(String.valueOf(digitToChar))){

                return digitToReturn;
            }
        }
    }
    public String getSingleDigit(int i){
        return this.fullCode.substring(i,i +1);
    }
    public void start(){

        System.out.print("The secret is prepared: " + generatedStar());
        if(this.numberOfPossibleSymbols <11){
            byte asciiValue = (byte) (47 + this.numberOfPossibleSymbols);
            char maxNumber = (char) asciiValue;
            System.out.printf(" (0-%s). \nOkay, let's start a game!\n", maxNumber );

        } else {
            byte asciiValue = (byte) (96 +  this.numberOfPossibleSymbols - 10);
            char maxNumber = (char) asciiValue;
            System.out.printf(" (0-9, a-%s). \nOkay, let's start a game!\n", maxNumber );
        }

    }

    public String generatedStar(){

         StringBuilder star = new StringBuilder();

         for(int i = 0; i < this.fullCode.length();i++ ){
             star.append("*");
         }

         return star.toString();
    }

}
