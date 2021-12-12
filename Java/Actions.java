public class Actions {

    public int[] swapSelect(int a, int b) {
        //swap a and b values with a temp variable
        int temp = a;
        a = b;
        b = temp;
        //
        int[] toReturn = new int[2];
        toReturn[0] = a;
        toReturn[1] = b;
        return toReturn;
    }

    public int[] hitSelect(int a, int b) {
        b += a;
        if (b>=5){
            b = 0;
        }
        int[] toReturn = new int[2];
        toReturn[0] = a;
        toReturn[1] = b;
        return toReturn;
    }

    public int[] splitSelect(int a, int b, int c) {
        a -= c;
        b += c;
        int [] toReturn = new int[2];
        toReturn[0] = a;
        toReturn[1] = b;

        return toReturn;
    }

}
