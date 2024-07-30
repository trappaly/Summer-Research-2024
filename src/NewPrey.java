import java.util.Random;

/*
 * Stores the prey as the agent that is to be captured
 @author Jio Hong and Alyssa Trapp
 */

public class NewPrey {

    // +--------+------------------------------------------------------
    // | Fields |
    // +--------+
    static final char PREY = 'P';
    static Random rand = new Random(System.currentTimeMillis());

    static int preyX = NewGrid.GRID_SIZE / 2;
    static int preyY = NewGrid.GRID_SIZE / 2;
    static int ogPreyX = preyX;
    static int ogPreyY = preyY;

    // +--------+------------------------------------------------------
    // | Methods |
    // +--------+

    /*
     * Stores prey location and places prey
     */
    static void placePrey() {
        NewGrid.grid[preyX][preyY] = PREY;
    } // placePrey()

    /*
     * Resets the prey to its original location
     */
    static void resetPrey() {
        NewGrid.grid[preyX][preyY] = NewGrid.EMPTY;
        preyX = ogPreyX;
        preyY = ogPreyY;
        placePrey();
    } // resetPrey()

    /*
     * Gets a random number from the array inputs
     */
    public static int getRandomNumber(int[] numbers) {
        Random rand = new Random();
        int index = rand.nextInt(numbers.length);
        return numbers[index];
    } // getRandomNumber (int[])


    /*
     * Adds direction value to the array
     */

     static int[] addVal(int [] arr, int direction) {
        int [] newArr = new int [arr.length + 1];
        //newArr[newArr.length] = direction;
        for (int i = 0; i < arr.length; i++) {
            newArr [i] = arr[i];
            }
            newArr[newArr.length - 1] = direction;
            return newArr;
        } // addVal (int, int)

    /*
     * Removes value from array if its the direction
     */

    static int[] removeVal(int [] arr, int direction) {
        //int[] arr = new int[] { 0, 1, 2, 3 };
        int[] newArr = new int[arr.length - 1];
        for (int i = 0, k = 0; i < arr.length; i++) {
            if (i != direction) {
                newArr[k] = arr[i];
                // System.out.println(arr[i]);
                k++;
            } // if
        } // for
        return newArr;
    } // removeVal (int, int [])

    /*
     * Returns array containing valid moves
     */

    static int[] validMoves(int [] arr) {
        int direction = rand.nextInt(4);
        // int[] arr = {};
        if (direction == 0) {
            if (!NewGrid.isEmpty(preyX - 1, preyY)) {
                removeVal (arr, 0);
            } // if 
            else {
                addVal(arr, 0);
            } // else
        } // if
        else if (direction == 1) {
            if (!NewGrid.isEmpty(preyX + 1, preyY)) {
                removeVal (arr, 1);
            } // if
            else {
                addVal(arr, 1);
            } // else
        } // else if
        else if (direction == 2) {
            if (!NewGrid.isEmpty(preyX, preyY - 1)) {
                removeVal (arr, 2);
            } // if
            else {
                addVal (arr, 2);
            } // else
        } // else if
        else {
            if (!NewGrid.isEmpty(preyX, preyY + 1)) {
                removeVal (arr, 3);
            } // if
            else {
                addVal (arr, 3);
            } // else
        } // else
        return arr;
    } // validMoves (int, int, int)


    /*
     * Moves the Prey
     */
    static void movePrey() {
        int oldX = preyX;
        int oldY = preyY;
        int[] arr = {0, 1, 2, 3};
        int randIndex = rand.nextInt(arr.length);
    // Generate a random direction based on valid moves: 0 = up, 1 = down, 2 = left, 3 = right
        int direction = validMoves(arr)[randIndex];
        switch (direction) {
            case 0: // move up
                if ((preyX > 0) && NewGrid.isEmpty(preyX - 1, preyY))
                    //arr = validMoves(0);
                    preyX--;
                    //direction = getRandomNumber(validMoves(0));
                break;
            case 1: // move down
                if ((preyX < NewGrid.GRID_SIZE - 1) && NewGrid.isEmpty(preyX + 1, preyY))
                    preyX++;
                    //direction = getRandomNumber(validMoves(1));
                break;
            case 2: // move left
                if ((preyY > 0) & NewGrid.isEmpty(preyX, preyY - 1))
                    preyY--;
                    // direction = getRandomNumber(validMoves(2));
                break;
            case 3: // move right
                if (preyY < NewGrid.GRID_SIZE - 1 && NewGrid.isEmpty(preyX, preyY + 1))
                    preyY++;
                    // direction = getRandomNumber(validMoves(3));
                break;
        } // switch
          // Update the grid
        NewGrid.grid[oldX][oldY] = NewGrid.EMPTY;
        NewGrid.grid[preyX][preyY] = PREY;
    } // movePrey()

    /*
     * Tells us if the prey is surrounded
     */
    static boolean isPreySurrounded() {
        int[][] directions = {
                { 0, -1 }, // left
                { 0, 1 }, // right
                { -1, 0 }, // up
                { 1, 0 } // down
        };

        for (int[] dir : directions) {
            int newX = preyX + dir[0];
            int newY = preyY + dir[1];

            if (newX >= 0 && newX < NewGrid.GRID_SIZE && newY >= 0 && newY < NewGrid.GRID_SIZE
                    && NewGrid.grid[newX][newY] == NewGrid.EMPTY) {
                return false;
            } // if
        } // for
        return true;
    } // isPreySurrounded

    /*
     * Makes a new prey // might not need this if it goes to same place every time,
     * but might need it if we want it to go different places
     */
    static void makePrey() {
        // Random rand = new Random(System.currentTimeMillis());
        int xDirection = rand.nextInt(NewGrid.GRID_SIZE);
        int yDirection = rand.nextInt(NewGrid.GRID_SIZE);
        NewGrid.grid[preyX][preyY] = NewGrid.EMPTY;
        NewGrid.grid[xDirection][yDirection] = PREY;
        placePrey();
    } // makePrey ()
} // class NewPrey
