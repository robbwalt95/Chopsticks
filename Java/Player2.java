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
        int[] hold;
        hold = new int[4];
        //loop for error
        boolean exit = false;

        while (!exit) {

            //Instructions
            System.out.println("\nPlayer B - Select a Number");
            Scanner scanObj = new Scanner(System.in);  // Create a Scanner object
            System.out.println("1 - Hit, 2 - Split, 3 - Swap: ");

            String turnOption = scanObj.nextLine();  // Read user input


            switch (turnOption) {
                case "1":
                    //bypass user input error
                    boolean run = false;
                    while (!run) {



                        Scanner scanObj1 = new Scanner(System.in);  // Create a Scanner object
                        System.out.println("1 - Left Attacker, 2 - Right Attacker");

                        String Aattacker = scanObj1.nextLine();  // Read user input

                        Scanner scanObj2 = new Scanner(System.in);  // Create a Scanner object
                        System.out.println("1 - Left Attacked, 2 - Right Attacked");

                        String Battacked = scanObj2.nextLine();  // Read user input

                        String combined = Aattacker + Battacked;

                        switch (combined) {
                            case "11":
                                if (y == 0 || w == 0) {
                                    System.out.println("\nERRORa2");
                                } else {
                                    Actions hit = new Actions();
                                    int[] temp = hit.hitSelect(y, w);
                                    hold[0] = temp[1];
                                    hold[1] = x;
                                    hold[2] = temp[0];
                                    hold[3] = z;
                                    run = true;
                                    exit = true;

                                }
                                break;
                            case "12":
                                if (y == 0 || x == 0) {
                                    System.out.println("\nERRORb2");

                                } else {
                                    Actions hit1 = new Actions();
                                    int[] temp1 = hit1.hitSelect(y, x);
                                    hold[0] = w;
                                    hold[1] = temp1[1];
                                    hold[2] = temp1[0];
                                    hold[3] = z;
                                    run = true;
                                    exit = true;

                                }
                                break;
                            case "21":
                                if (z == 0 || w == 0) {
                                    System.out.println("\nERRORc2");

                                } else {
                                    Actions hit2 = new Actions();
                                    int[] temp2 = hit2.hitSelect(z, w);
                                    hold[0] = temp2[1];
                                    hold[1] = x;
                                    hold[2] = y;
                                    hold[3] = temp2[0];
                                    run = true;
                                    exit = true;

                                }
                                break;
                            case "22":
                                if (z == 0 || x == 0) {
                                    System.out.println("\nERRORd2");

                                } else {
                                    Actions hit3 = new Actions();
                                    int[] temp3 = hit3.hitSelect(z, x);
                                    hold[0] = w;
                                    hold[1] = temp3[1];
                                    hold[2] = y;
                                    hold[3] = temp3[0];
                                    run = true;
                                    exit = true;


                                }
                                break;
                            default:
                                System.out.println("\nERRORe2");
                                break;
                        }


                    }
                    break;
                case "2":
                    boolean again = true;
                    while(again) {

                        Scanner scanObj1 = new Scanner(System.in);  // Create a Scanner object
                        System.out.println("Split - which hand to take away from ");
                        System.out.println("1 - left, 2 right");

                        String takeFrom = scanObj1.nextLine();  // Read user input


                        try {

                            System.out.println("Split - How many to take away: ");
                            Scanner scanObj2 = new Scanner(System.in);  // Create a Scanner object
                            int amount = scanObj2.nextInt();
                            switch (takeFrom){
                                case "1":
                                    if (amount <= y && !(y == 0)){
                                        Actions split = new Actions();
                                        int[] temp = split.splitSelect(y,z,amount);
                                        hold[0] = w;
                                        hold[1] = x;
                                        hold[2] = temp[0];
                                        hold[3] = temp[1];
                                        again = false;
                                        exit = true;
                                    }
                                    break;
                                case "2":
                                    if (amount <= z && !(z == 0)){
                                        Actions split = new Actions();
                                        int[] temp = split.splitSelect(z,y,amount);
                                        hold[0] = w;
                                        hold[1] = x;
                                        hold[2] = temp[1];
                                        hold[3] = temp[0];
                                        again = false;
                                        exit = true;
                                    }

                                    break;
                                default:
                                    System.out.println("\n\nInput Error - Try Again");
                            }
                        } catch (InputMismatchException ex) {
                            System.out.println("Input error");
                        }
                    }
                    break;
                case "3":
                    Actions swap = new Actions();
                    int[] temp = swap.swapSelect(y,z);
                    hold[0] = w;
                    hold[1] = x;
                    hold[2] = temp[0];
                    hold[3] = temp[1];
                    exit = true;
                    break;
                default:
                    System.out.println("\nERROR");
                    break ;
            }


        }

        return hold;

    }
}
