/*
 * Runs the Prey and Predator Game
 @author Jio Hong and Alyssa Trapp
 */

public class PlayGame {

    // +--------+------------------------------------------------------
    // | Main |
    // +--------+
    public static void main(String[] args) {
        // initializes the grid and variables 
        NewGrid.initializeGrid();
        NewPrey.placePrey();
        NewPredator.placePredators();
        int count = 0;
        System.out.println("Count: " + count);
        NewGrid.printGrid();
        while (count < 20) {
            while (!NewPrey.isPreySurrounded()) {
                // makes sure it always only runs 20 iterations
                if (count == 20) {
                    break;
                } // if
                NewPrey.movePrey();
                for (int i = 0; i < NewPredator.predators.length; i++) {
                    NewPredator.movePredator(i);
                } // for
                count++;
                System.out.println("Count: " + count);
                NewGrid.printGrid();
                if (NewPrey.isPreySurrounded()) {
                    System.out.println("The prey is surrounded!");
                    if (count != 20) {
                        // Resets the game back to its original state
                        System.out.println("Start new game");
                        NewGrid.clearGrid();
                        NewPredator.clearPredators();
                        NewPrey.resetPrey();
                        NewPredator.resetPredators();
                        NewGrid.printGrid();
                    } // if
                } // if
            } // while
        } // while
    } // main
} // class PlayGame
