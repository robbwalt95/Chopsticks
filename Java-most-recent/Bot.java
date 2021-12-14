import java.util.Arrays;

public class Bot {
    int w,x,y,z;
    String diff;

    public Bot(int wNew,int xNew,int yNew, int zNew, String diffNew) {
        w = wNew;
        x = xNew;
        y = yNew;
        z = zNew;
        diff = diffNew;

    }



    public int[] turnSelect() {


        int[] hold = new int[4];

        //difficulty
        if (diff.equals("2")){
            hold = easyDiff();
        } else if ((diff.equals("3"))){
            hold = medDiff();
        } else if ((diff.equals("4"))) {
            hold = hardDiff();
        }
        return hold;
    }
    //easy - hit
    public int[] easyDiff() {

        int[] hold = new int[4];;
        //hit y to x
        if(!(x == 0) && !(y == 0)){
            Actions hit = new Actions();
            int[] temp = hit.hitSelect(y, x);

            hold[0] = w;
            hold[1] = temp[1];
            hold[2] = temp[0];
            hold[3] = z;
            System.out.print("\nComputer left attacked your right\n");

            //hit y to w
        }else if(!(w == 0) && !(y == 0)) {
            Actions hit = new Actions();
            int[] temp = hit.hitSelect(y, w);

            hold[0] = temp[1];
            hold[1] = x;
            hold[2] = temp[0];
            hold[3] = z;
            System.out.print("\nComputer left attacked your left\n");
        }

        //hit z to x
        else if(!(x == 0) && !(z == 0)){
            Actions hit = new Actions();
            int[] temp = hit.hitSelect(z, x);

            hold[0] = w;
            hold[1] = temp[1];
            hold[2] = y;
            hold[3] = temp[0];
            System.out.print("\nComputer right attacked your right\n");

            //hit y to w
        }else if(!(w == 0) && !(z == 0)) {
            Actions hit = new Actions();
            int[] temp = hit.hitSelect(z, w);

            hold[0] = temp[1];
            hold[1] = x;
            hold[2] = y;
            hold[3] = temp[0];
            System.out.print("\nComputer right attacked your left\n");
        }
        return hold;
    }

    //medium - hit + split
    public int[] medDiff() {

        int[] hold = new int[4];
        //split z to y
        if (y == 0 && z >= 2) {
            Actions split = new Actions();
            int[] temp = split.splitSelect(z,y,1);
            hold[0] = w;
            hold[1] = x;
            hold[2] = temp[1];
            hold[3] = temp[0];
            System.out.print("\nComputer split\n");

        } else if (z == 0 && y >= 2) {
            Actions split = new Actions();
            int[] temp = split.splitSelect(y,z,1);
            hold[0] = w;
            hold[1] = x;
            hold[2] = temp[0];
            hold[3] = temp[1];
            System.out.print("\nComputer split\n");
        }

        //hit y to x
        else if(!(x == 0) && !(y == 0)){
            Actions hit = new Actions();
            int[] temp = hit.hitSelect(y, x);

            hold[0] = w;
            hold[1] = temp[1];
            hold[2] = temp[0];
            hold[3] = z;
            System.out.print("\nComputer left attacked your right\n");

            //hit y to w
        }else if(!(w == 0) && !(y == 0)) {
            Actions hit = new Actions();
            int[] temp = hit.hitSelect(y, w);

            hold[0] = temp[1];
            hold[1] = x;
            hold[2] = temp[0];
            hold[3] = z;
            System.out.print("\nComputer left attacked your left\n");
        }

        //hit z to x
        else if(!(x == 0) && !(z == 0)){
            Actions hit = new Actions();
            int[] temp = hit.hitSelect(z, x);

            hold[0] = w;
            hold[1] = temp[1];
            hold[2] = y;
            hold[3] = temp[0];
            System.out.print("\nComputer right attacked your right\n");

            //hit y to w
        }else if(!(w == 0) && !(z == 0)) {
            Actions hit = new Actions();
            int[] temp = hit.hitSelect(z, w);

            hold[0] = temp[1];
            hold[1] = x;
            hold[2] = y;
            hold[3] = temp[0];
            System.out.print("\nComputer right attacked your left\n");
        }
        return hold;


    }
    //hard - hit + split + knockouts
    public int[] hardDiff() {


        int[] hold = new int[4];
        //check for knockout z to w
        if(w+z>=5){
            Actions hit = new Actions();
            int[] temp = hit.hitSelect(z, w);

            hold[0] = temp[1];
            hold[1] = x;
            hold[2] = y;
            hold[3] = temp[0];
            System.out.print("\nComputer went for a KNOCKOUT\n");

            //check for knockout z to x
        } else if(x+z>=5){
            Actions hit = new Actions();
            int[] temp = hit.hitSelect(z, x);

            hold[0] = w;
            hold[1] = temp[1];
            hold[2] = y;
            hold[3] = temp[0];
            System.out.print("\nComputer went for a KNOCKOUT\n");

            //check for knockout y to x
        } else if(x+y>=5){
            Actions hit = new Actions();
            int[] temp = hit.hitSelect(y, x);

            hold[0] = w;
            hold[1] = temp[1];
            hold[2] = temp[0];
            hold[3] = z;
            System.out.print("\nComputer went for a KNOCKOUT\n");

            //check for knockout y to w
        } else if(w+y>=5){
            Actions hit = new Actions();
            int[] temp = hit.hitSelect(y, w);

            hold[0] = w;
            hold[1] = temp[1];
            hold[2] = temp[0];
            hold[3] = z;
            System.out.print("\nComputer went for a KNOCKOUT\n");
        }

        //split z to y
        else if (y == 0 && z >= 2) {
            Actions split = new Actions();
            int[] temp = split.splitSelect(z,y,1);
            hold[0] = w;
            hold[1] = x;
            hold[2] = temp[1];
            hold[3] = temp[0];
            System.out.print("\nComputer split\n");

        } else if (z == 0 && y >= 2) {
            Actions split = new Actions();
            int[] temp = split.splitSelect(y,z,1);
            hold[0] = w;
            hold[1] = x;
            hold[2] = temp[0];
            hold[3] = temp[1];
            System.out.print("\nComputer split\n");
        }

        //hit y to x
        else if(!(x == 0) && !(y == 0)){
            Actions hit = new Actions();
            int[] temp = hit.hitSelect(y, x);

            hold[0] = w;
            hold[1] = temp[1];
            hold[2] = temp[0];
            hold[3] = z;
            System.out.print("\nComputer left attacked your right\n");

            //hit y to w
        }else if(!(w == 0) && !(y == 0)) {
            Actions hit = new Actions();
            int[] temp = hit.hitSelect(y, w);

            hold[0] = temp[1];
            hold[1] = x;
            hold[2] = temp[0];
            hold[3] = z;
            System.out.print("\nComputer left attacked your left\n");
        }

        //hit z to x
        else if(!(x == 0) && !(z == 0)){
            Actions hit = new Actions();
            int[] temp = hit.hitSelect(z, x);

            hold[0] = w;
            hold[1] = temp[1];
            hold[2] = y;
            hold[3] = temp[0];
            System.out.print("\nComputer right attacked your right\n");

            //hit y to w
        }else if(!(w == 0) && !(z == 0)) {
            Actions hit = new Actions();
            int[] temp = hit.hitSelect(z, w);

            hold[0] = temp[1];
            hold[1] = x;
            hold[2] = y;
            hold[3] = temp[0];
            System.out.print("\nComputer right attacked your left\n");
        }
        return hold;


    }
}
