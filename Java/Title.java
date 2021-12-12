import java.util.Scanner;

public class Title {
    public static void main(String[] args) {

        boolean exit = false;
        //Loop screen
        while(!exit) {

            //Title
            System.out.println("\nChopsticks - Equal Swaps Edition");
            //Start
            System.out.println("1 - Start");
            //Rules
            System.out.println("2 - Rules");
            //Exit
            System.out.println("3 - Exit");

            //Get user input
            Scanner scanObj = new Scanner(System.in);  // Create a Scanner object
            System.out.println("Enter Option Number");

            String userOption = scanObj.nextLine();  // Read user input
            System.out.println("\n");

            switch(userOption) {
                case "1":

                    GameType config = new GameType();
                    String difficulty = config.selectType();

                    // GameLoop file
                    GameLoop start = new GameLoop(1,1,1,1, difficulty);
                    start.runningLoop();
                    break;
                case "2":
                    // print rules
                    Rules.TellRules();
                    break;
                case "3":
                    //end program endless loop
                    exit = true;
                    break;
                default:
                    System.out.println("\nERROR");
            }

        }
    }
}
