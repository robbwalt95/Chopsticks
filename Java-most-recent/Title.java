import java.util.Scanner;

public class Title {
    public static void main(String[] args) {

        //loop and only exit if prompted
        boolean exit = false;
        while(!exit) {

            //Display options
            System.out.println("\nChopsticks - Equal Swaps Edition");
            System.out.println("1 - Start");
            System.out.println("2 - Rules");
            System.out.println("3 - Exit");

            //Prompt and store user input
            Scanner scanObj = new Scanner(System.in);
            System.out.println("Enter Option Number");
            String userOption = scanObj.nextLine();
            System.out.println("\n");

            //check user input
            switch(userOption) {

                case "1":
                    //Go to GameType to get difficulty
                    GameType config = new GameType();
                    String difficulty = config.selectType();

                    // Setup and go to GameLoop
                    GameLoop start = new GameLoop(1,1,1,1, difficulty);
                    start.runningLoop();
                    break;
                case "2":
                    Rules.TellRules();
                    break;
                //End program
                case "3":
                    exit = true;
                    break;

                //User input error + reloop
                default:
                    System.out.println("\nERROR");
            }

        }
    }
}
