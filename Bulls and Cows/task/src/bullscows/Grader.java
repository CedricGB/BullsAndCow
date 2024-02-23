package bullscows;

public class Grader {

    private String guess;
    private SecretCode secretCode;
    private int bulls;
    private int cows;

    public Grader( SecretCode secretCode){
        this.guess = "";
        this.secretCode = secretCode;
        this.bulls = 0;
        this.cows = 0;
    }

    public void setDigits(String digits){

        this.guess =  digits;
    }
    public boolean gradeTheInput(){

        if(secretCode.getFullDigits().equals(this.guess)){
            this.bulls = secretCode.getFullDigits().length();
            return printGrade();
        }
        for(int i = 0  ; i < this.secretCode.getFullDigits().length(); i++){
            if(secretCode.getFullDigits().contains(Character.toString(this.guess.charAt(i)))){
                if(isDigitABull(secretCode.getSingleDigit(i), Character.toString(this.guess.charAt(i)) )){
                    this.guess = this.guess.replace(Character.toString(this.guess.charAt(i)), "-");
                    this.bulls++;
                }
            }
        }
        for(int i = 0  ; i < this.secretCode.getFullDigits().length(); i++){
            if(secretCode.getFullDigits().contains(Character.toString(this.guess.charAt(i))) && this.guess.charAt(i) != '-' ){
                if(isDigitABull(secretCode.getSingleDigit(i), Character.toString(this.guess.charAt(i)) )){
                    this.guess = this.guess.replace(Character.toString(this.guess.charAt(i)), "-");
                    this.cows++;
                }
            }
        }

        return printGrade();
    }

    private boolean printGrade(){
        if(this.cows == 0 && this.bulls == 0){
            System.out.println("Grade: None.");
        } else if(this.bulls == this.secretCode.getFullDigits().length()){
            System.out.printf("Grade: %d bulls \n", this.bulls);
            System.out.println("Congratulations! You guessed the secret code.");
            return true;
        }else if(this.cows > 0 && this.bulls == 0){
            System.out.printf("Grade: %d cow(s).\n", this.cows );
        } else if(this.cows == 0 && this.bulls > 0){
            System.out.printf("Grade: %d bull(s).\n", this.bulls );
        } else {
            System.out.printf("Grade: %d bull(s) and %d cow(s).\n", this.bulls,this.cows );

        }
        resetCowAndBull();
        return false;
    }
    private void resetCowAndBull(){
        this.bulls = 0;
        this.cows = 0;
    }
    private boolean isDigitABull(String secret, String grader){

        if(secret.equals(grader)){
            return true;
        }
        return false;
    }




}
