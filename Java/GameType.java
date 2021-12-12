import java.util.Scanner;

public class GameType {

    public String selectType() {

        String diffSelect = "";
        //loop for error
        boolean exit = false;
        //Loop screen
        while(!exit) {

            //Startup
            System.out.println("Chopsticks - Type Selection");
            System.out.println("1 - Player Vs Player");
            System.out.println("2 - Player Vs Easy Comp");
            System.out.println("3 - Player Vs Medium Comp");
            System.out.println("4 - Player Vs Hard Comp");


            Scanner scanObj = new Scanner(System.in);  // Create a Scanner object
            System.out.println("Enter Option Number");

            String diffOption = scanObj.nextLine();  // Read user input
            diffSelect = diffOption;

            //make sure we got a valid input and continue
            switch (diffOption) {
                case "1":

                    exit = true;
                    break;
                case "2":
                    exit = true;
                    break;
                case "3":
                    exit = true;
                    break;
                case "4":
                    exit = true;
                    break;
                default:
                    System.out.println("\nERROR");
            }

        }
        return diffSelect;



    }

}






