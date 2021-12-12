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

        int turn = 0;


        while ( !(w==0 && x==0) || !(y==0 && z==0)) {
            if ((x == 0 && w == 0) || (y == 0 && z == 0)) {
                break;
            }
            if (diff.equals("1")) {

                Display showing = new Display(w, x, y, z);
                showing.displayBoard();

                if (turn % 2 == 0) {

                    Player1 action1 = new Player1(w, x, y, z);

                    int[] values1 = action1.turnSelect();

                    w = values1[0];
                    x = values1[1];
                    y = values1[2];
                    z = values1[3];
                } else {
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
                if (turn % 2 == 0) {

                    Player1 action1 = new Player1(w, x, y, z);

                    int[] values1 = action1.turnSelect();

                    w = values1[0];
                    x = values1[1];
                    y = values1[2];
                    z = values1[3];
                } else {
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

        turn += 1;
        Display showing = new Display(w, x, y, z);
        showing.displayBoard();
        if (x == 0 && w == 0) {
            System.out.println("\nPLAYER B WINS!\nTurns=" + turn +"\nhit enter to go to the title screen\n");


        } else if (y==0 && z==0){
            System.out.println("\nPLAYER A WINS!\nTurns=" + turn +"\nhit enter to go to the title screen\n");
        } else {
            System.out.println("w = " + w);
            System.out.println("x = " + x);
            System.out.println("y = " + y);
            System.out.println("z = " +z);
        }

        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

    }
}


