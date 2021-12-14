public class Display {
    int w,x,y,z;

    public Display(int newW, int newX,int newY,int newZ){
        w = newW;
        x = newX;
        y = newY;
        z = newZ;
    }

    public void displayBoard(){
        //board to display
        String string1 = String.format("Team A---%o %o---------\n", w, x);
        String string2 = String.format("---------%o %o---Team B", y, z);
        System.out.print("\n\n");
        System.out.print(string1);
        System.out.print(string2);



    }
}
