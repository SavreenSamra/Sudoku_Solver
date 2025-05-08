// Concrete class representing the whole Sudoku puzzle

package Model; 

public class Puzzle {
    private Section[] row; 
    private Section[] column; 
    private Section[] box; 
    private boolean complete; 

    //Constructors:
    public Puzzle() {
        complete = false; //empty puzzle 

        row = new Section[Constants.GRID_SIZE]; 
        column = new Section[Constants.GRID_SIZE]; 
        box = new Section[Constants.GRID_SIZE]; 

        for (int i = 0; i < Constants.GRID_SIZE; i++) {
            

        }
    }

    public Puzzle(int[][] input) {


    }



    //Getters
    public boolean isComplete() { return complete; }


    //Others:
    public boolean takeInput() {
        return true; 
    }

    public boolean edit() {
        return true; 
    }

    private boolean checkInput() {
        return true; 
    }

    public boolean clear() {
        return true; 
    }

    public boolean solve() {
        return true; 
    }

    public String toString() {
        return ""; 
    }





}