import java.util.Scanner;

public class GameLoop {
    int w, x, y, z;
    String diff;

    public GameLoop(int newW, int newX, int newY, int newZ, String newDiff) {
        w = newW;
        x = newX;
        y = newY;
        z = newZ;
        diff = newDiff;
    }

    public void runningLoop() {

        //alternate turns
        int turn = 0;

        //While someone has not lost
        while ( !(w==0 && x==0) || !(y==0 && z==0)) {
            //loop can skip over so double check with the below if
            if ((x == 0 && w == 0) || (y == 0 && z == 0)) {
                break;
            }

            //Player vs Player
            if (diff.equals("1")) {
                Display showing = new Display(w, x, y, z);
                showing.displayBoard();

                //even turns player 1 goes
                if (turn % 2 == 0) {
                    //create-call-store new values from Player 1
                    Player1 action1 = new Player1(w, x, y, z);
                    int[] values1 = action1.turnSelect();
                    w = values1[0];
                    x = values1[1];
                    y = values1[2];
                    z = values1[3];
                //odd turns player 2
                } else {
                    //create-call-store new values from Player 2
                    Player2 action2 = new Player2(w, x, y, z);
                    int[] values2 = action2.turnSelect();
                    w = values2[0];
                    x = values2[1];
                    y = values2[2];
                    z = values2[3];
                }
            }
            //Player versus Computer
            else {
                Display showing = new Display(w, x, y, z);
                showing.displayBoard();

                //even turns player 1 goes
                if (turn % 2 == 0) {
                    //create-call-store new values from Player 1
                    Player1 action1 = new Player1(w, x, y, z);
                    int[] values1 = action1.turnSelect();
                    w = values1[0];
                    x = values1[1];
                    y = values1[2];
                    z = values1[3];
                //odd turns bot goes
                } else {
                    //create-call-store new values from bot
                    Bot action2 = new Bot(w, x, y, z, diff);
                    int[] values2 = action2.turnSelect();
                    w = values2[0];
                    x = values2[1];
                    y = values2[2];
                    z = values2[3];
                }
            }
            turn += 1;
        }

        //turn doesnt inclement player 1 first turn
        turn += 1;


        //display final board
        Display showing = new Display(w, x, y, z);
        showing.displayBoard();

        //Check who won - display who - have user input to continue
        if (x == 0 && w == 0) {
            System.out.println("\nPLAYER B WINS!\nTurns=" + turn +"\nhit enter to go to the title screen\n");
        } else if (y==0 && z==0){
            System.out.println("\nPLAYER A WINS!\nTurns=" + turn +"\nhit enter to go to the title screen\n");
        }
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

    }
}


