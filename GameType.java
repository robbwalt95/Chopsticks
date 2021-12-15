import java.util.Scanner;

public class GameType {

    public String selectType() {

        String diffOption = "";
        //loop for error
        boolean exit = false;
        while(!exit) {

            //Display options
            System.out.println("Chopsticks - Type Selection");
            System.out.println("1 - Player Vs Player");
            System.out.println("2 - Player Vs Easy Comp");
            System.out.println("3 - Player Vs Medium Comp");
            System.out.println("4 - Player Vs Hard Comp");

            //Prompt and store difficulty option input
            Scanner scanObj = new Scanner(System.in);
            System.out.println("Enter Option Number");
            diffOption = scanObj.nextLine();

            //Validate input
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
        return diffOption;



    }

}






