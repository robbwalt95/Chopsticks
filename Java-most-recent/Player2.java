import java.util.InputMismatchException;
import java.util.Scanner;

public class Player2 {
    int w,x,y,z;

    public Player2(int newW, int newX,int newY,int newZ){
        w = newW;
        x = newX;
        y = newY;
        z = newZ;
    }

    public int[] turnSelect() {

        //array to hold returning value
        int[] hold;
        hold = new int[4];

        //loop to reget action option input
        boolean exit = false;
        while (!exit) {

            //Instructions
            System.out.println("\nPlayer B - Select a Number");
            System.out.println("1 - Hit, 2 - Split, 3 - Swap: ");

            //store input
            Scanner scanObj = new Scanner(System.in);
            String actionOption = scanObj.nextLine();

            //validate action option input
            switch (actionOption) {
                //hit
                case "1":
                    //loop to reget combined input
                    boolean run = false;
                    while (!run) {

                        //prompt and get which is to attack
                        Scanner scanObj1 = new Scanner(System.in);
                        System.out.println("1 - Left Attacker, 2 - Right Attacker");
                        String attacker = scanObj1.nextLine();

                        //prompt and get which is to get attacked
                        Scanner scanObj2 = new Scanner(System.in);
                        System.out.println("1 - Left Attacked, 2 - Right Attacked");
                        String attacked = scanObj2.nextLine();

                        //combined input
                        String combined = attacker + attacked;

                        //validate combined input
                        switch (combined) {
                            case "11":
                                //cant attack or attacked 0
                                if (y == 0 || w == 0) {
                                    System.out.println("\nERRORa2");
                                } else {
                                    //send and receive values
                                    Actions hit = new Actions();
                                    int[] temp = hit.hitSelect(y, w);

                                    //package up returning values
                                    hold[0] = temp[1];
                                    hold[1] = x;
                                    hold[2] = temp[0];
                                    hold[3] = z;

                                    //end Player 2 turn
                                    run = true;
                                    exit = true;

                                }
                                break;
                            case "12":
                                //cant attack or attacked 0
                                if (y == 0 || x == 0) {
                                    System.out.println("\nERRORb2");
                                } else {
                                    //send and receive values
                                    Actions hit1 = new Actions();
                                    int[] temp1 = hit1.hitSelect(y, x);

                                    //package up returning values
                                    hold[0] = w;
                                    hold[1] = temp1[1];
                                    hold[2] = temp1[0];
                                    hold[3] = z;

                                    //end Player 2 turn
                                    run = true;
                                    exit = true;
                                }
                                break;
                            case "21":
                                //cant attack or attacked 0
                                if (z == 0 || w == 0) {
                                    System.out.println("\nERRORc2");
                                } else {
                                    //send and receive values
                                    Actions hit2 = new Actions();
                                    int[] temp2 = hit2.hitSelect(z, w);

                                    //package up returning values
                                    hold[0] = temp2[1];
                                    hold[1] = x;
                                    hold[2] = y;
                                    hold[3] = temp2[0];

                                    //end Player 2 turn
                                    run = true;
                                    exit = true;

                                }
                                break;
                            case "22":
                                //cant attack or attacked 0
                                if (z == 0 || x == 0) {
                                    System.out.println("\nERRORd2");
                                } else {
                                    //send and receive values
                                    Actions hit3 = new Actions();
                                    int[] temp3 = hit3.hitSelect(z, x);

                                    //package up returning values
                                    hold[0] = w;
                                    hold[1] = temp3[1];
                                    hold[2] = y;
                                    hold[3] = temp3[0];

                                    //end Player 2 turn
                                    run = true;
                                    exit = true;
                                }
                                break;
                            default:
                                //combined input error
                                System.out.println("\nERRORe2");
                                Display showing = new Display(w, x, y, z);
                                showing.displayBoard();
                                break;
                        }
                    }
                    break;
                //Split
                case "2":
                    //reloop to get amount and taking from input
                    boolean again = true;
                    while(again) {
                        //prompt and store takefrom input
                        System.out.println("Split - which hand to take from ");
                        System.out.println("1 - left, 2 right");
                        Scanner scanObj1 = new Scanner(System.in);
                        String takeFrom = scanObj1.nextLine();

                        //try to get only an int
                        try {
                            //prompt and store int amount
                            System.out.println("Split - How many to take away: ");
                            Scanner scanObj2 = new Scanner(System.in);
                            int amount = scanObj2.nextInt();

                            //validating takefrom input
                            switch (takeFrom){
                                case "1":
                                    //validate amount can be applied
                                    if (amount <= y && !(y == 0)){
                                        //send and receive values
                                        Actions split = new Actions();
                                        int[] temp = split.splitSelect(y,z,amount);

                                        //package array with new values
                                        hold[0] = w;
                                        hold[1] = x;
                                        hold[2] = temp[0];
                                        hold[3] = temp[1];

                                        //End Player 2 turn
                                        again = false;
                                        exit = true;
                                    }
                                    break;
                                case "2":
                                    //validate amount can be applied
                                    if (amount <= z && !(z == 0)){
                                        //send and receive values
                                        Actions split = new Actions();
                                        int[] temp = split.splitSelect(z,y,amount);

                                        //package array with new values
                                        hold[0] = w;
                                        hold[1] = x;
                                        hold[2] = temp[1];
                                        hold[3] = temp[0];

                                        //End Player 2 turn
                                        again = false;
                                        exit = true;
                                    }
                                    break;
                                default:
                                    //takeFrom input error
                                    System.out.println("\n\nTake From Input Error");
                            }
                        }
                        //did not get an int
                        catch (InputMismatchException ex) {
                            System.out.println("Input error");
                        }
                    }
                    break;
                //Swap
                case "3":
                    //send and receive values
                    Actions swap = new Actions();
                    int[] temp = swap.swapSelect(y,z);

                    //package array with new values
                    hold[0] = w;
                    hold[1] = x;
                    hold[2] = temp[0];
                    hold[3] = temp[1];

                    //end player 2 turn
                    exit = true;
                    break;
                default:
                    //action option input error
                    System.out.println("\nERROR");
                    Display showing = new Display(w, x, y, z);
                    showing.displayBoard();
                    break ;
            }
        }
        return hold;
    }
}
