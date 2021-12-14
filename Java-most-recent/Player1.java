import java.util.InputMismatchException;
import java.util.Scanner;

public class Player1 {
    int w,x,y,z;

    public Player1(int newW, int newX,int newY,int newZ){
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
            System.out.println("\nPlayer A - Select a Number");
            System.out.println("1 - Hit, 2 - Split, 3 - Swap: ");

            //store input
            Scanner scanObj = new Scanner(System.in);
            String actionOption = scanObj.nextLine();  

            //validate action option input
            switch (actionOption) {
                //hit
                case "1":
                    //loop to reget combined input
                    boolean run = true;
                    while (run) {

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
                                if (w == 0 || y == 0) {
                                    System.out.println("\nERRORa1");
                                } else {
                                    //send and receive values
                                    Actions hit = new Actions();
                                    int[] temp = hit.hitSelect(w, y);

                                    //package up returning values
                                    hold[0] = temp[0];
                                    hold[1] = x;
                                    hold[2] = temp[1];
                                    hold[3] = z;

                                    //end Player 1 turn
                                    run = false;
                                    exit = true;
                                }
                                break;
                            case "12":
                                //cant attack or attacked 0
                                if (w == 0 || z == 0) {
                                    System.out.println("\nERRORb1");
                                } else {
                                    //send and receive values
                                    Actions hit1 = new Actions();
                                    int[] temp1 = hit1.hitSelect(w, z);

                                    //package up returning values
                                    hold[0] = temp1[0];
                                    hold[1] = x;
                                    hold[2] = y;
                                    hold[3] = temp1[1];

                                    //end Player 1 turn
                                    run = false;
                                    exit = true;
                                }
                                break;
                            case "21":
                                //cant attack or attacked 0
                                if (x == 0 || y == 0) {
                                    System.out.println("\nERRORc1");
                                } else {
                                    //send and receive values
                                    Actions hit2 = new Actions();
                                    int[] temp2 = hit2.hitSelect(x, y);

                                    //package up returning values
                                    hold[0] = w;
                                    hold[1] = temp2[0];
                                    hold[2] = temp2[1];
                                    hold[3] = z;

                                    //end Player 1 turn
                                    run = false;
                                    exit = true;
                                }
                                break;
                            case "22":
                                //cant attack or attacked 0
                                if (x == 0 || z == 0) {
                                    System.out.println("\nERRORd1");
                                } else {
                                    //send and receive values
                                    Actions hit3 = new Actions();
                                    int[] temp3 = hit3.hitSelect(x, z);

                                    //package up returning values
                                    hold[0] = w;
                                    hold[1] = temp3[0];
                                    hold[2] = y;
                                    hold[3] = temp3[1];

                                    //end Player 1 turn
                                    run = false;
                                    exit = true;
                                }
                                break;
                            default:
                                //combined input error
                                System.out.println("\nERRORe1");
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

                            //validate takeaway input
                            switch (takeFrom){
                                case "1":
                                    //validate amount can be applied
                                    if (amount <= w && !(w == 0)){
                                        //send and receive values
                                        Actions split = new Actions();
                                        int[] temp = split.splitSelect(w,x,amount);

                                        //package array with new values
                                        hold[0] = temp[0];
                                        hold[1] = temp[1];
                                        hold[2] = y;
                                        hold[3] = z;

                                        //End Player 1 turn
                                        again = false;
                                        exit = true;
                                    }
                                    break;
                                case "2":
                                    //validate amount can be applied
                                    if (amount <= x && !(x == 0)){
                                        //send and receive values
                                        Actions split = new Actions();
                                        int[] temp = split.splitSelect(x,w,amount);

                                        //package array with new values
                                        hold[0] = temp[1];
                                        hold[1] = temp[0];
                                        hold[2] = y;
                                        hold[3] = z;

                                        //end player 1 turn
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
                            System.out.println("Int Input error");
                        }
                    }
                    break;
                //Swap
                case "3":
                    //send and receive values
                    Actions swap = new Actions();
                    int[] temp1 = swap.swapSelect(w, x);

                    //package array with new values
                    hold[0] = temp1[0];
                    hold[1] = temp1[1];
                    hold[2] = y;
                    hold[3] = z;

                    //end player 1 turn
                    exit = true;

                    break;
                default:
                    //action option input error
                    System.out.println("\nERROR");
                    Display showing = new Display(w, x, y, z);
                    showing.displayBoard();
                    break;
            }
        }
        return hold;
    }
}
