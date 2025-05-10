// Concrete class representing the whole Sudoku puzzle

package Model; 

public class Puzzle {
    private Section[] row; 
    private Section[] column; 
    private Section[] box; 
    private boolean complete; 

    //Constructors:
    /**
     * Constructor for an empty puzzle, where all Cells have a value of 0. 
     * 
     * @throws IllegalArguementException If Section constructor throws an IllegalArguementException
     */
    public Puzzle() {
        complete = false; //empty puzzle 

        row = new Section[Constants.GRID_SIZE]; 
        column = new Section[Constants.GRID_SIZE]; 
        box = new Section[Constants.GRID_SIZE]; 

        int[] values = {0, 0, 0, 0, 0, 0, 0, 0, 0}; //9 zeros  

        for (int i = 0; i < Constants.GRID_SIZE; i++) {
            row[i] = new Section("R", i, values); 
            column[i] = new Section("C", i, values); 
            box[i] = new Section("B", i, values); 
        }
    }

    //Getters
    public boolean isComplete() { return complete; }


    //Others:
    /**
     * Edit the value of a single Cell in the Puzzle. Only possible if the puzzle is not already solved. 
     * 
     * @param value An int representing the new value of the Cell. 
     * @param rowNumber An int representing the index of the row the Cell is located in.
     * @param columnNumber  An int representing the index of the column the Cell is located in. 
     * @return  true if the task was successfully completed. 
     * @throws IllegalArguementException If Constants.checkValue(int), Constants.checkRowIndex(int), or Constants.checkColumnIndex(int) throws an IllegalArguementException
     */
    public boolean edit(int value, int rowNumber, int columnNumber) {
        if (complete) {
            return false; 
        }

        //First check validity of all inputs: 
        Constants.checkValue(value);
        Constants.checkRowIndex(rowNumber);
        Constants.checkColumnIndex(columnNumber);

        //If valid inputs, continue:
        row[rowNumber].edit(value, columnNumber); 
        column[columnNumber].edit(value, rowNumber); 

        int boxNumber = Constants.calculateBoxIndex(rowNumber, columnNumber); 
        /*
         * The following section calculates the index within the box Section that the Cell is located at. 
         * 
         * Since we have narrowed the possible Cell choices down to 9 and each Cell stores it's row and column number, 
         * we will simply loop through all 9 Cells and check their row and column number until we have found the correct Cell. 
         * 
         * This approach is using brute-force, which can be inefficient, but since our sample size is small it is fine for now. 
         */
        int boxIndex = -1; 
        Cell currentCell; 

        for (int i = 0; i < Constants.GRID_SIZE; i++) {
            currentCell = box[boxNumber].getCell(i); 

            if (currentCell.getRowNumber() == rowNumber && currentCell.getColumnNumber() == columnNumber) {  
                boxIndex = i; 
                break; 
            }
        }

        box[boxNumber].edit(value, boxIndex); 

        checkCompletion(); 
        return true; 
    }

    /**
     * Check if all Cells in our Puzzle have their final value, in which case our Puzzle is complete. 
     * 
     * @return true if Puzzle is complete, and false otherwise. 
     */
    public boolean checkCompletion() {
        for (int i = 0; i < Constants.GRID_SIZE; i++) {
            if (!row[i].isComplete()) {
                complete = false; 
                return false; 
            }
        }

        complete = true; 
        return true; 
    }

    /**
     * Clear all Cells in our Puzzle by removing their values. 
     *
     * @return true if task was completed successfully. 
     */
    public boolean clear() {
        for (int i = 0; i < Constants.GRID_SIZE; i++) {
            row[i].clear(); 
        }
        complete = false; 
        return true; 
    }

    public boolean solve() {
        /*
         * Last function to complete.. main algorithm. 
         * Make sure to consider all details and edge cases. 
         * 
         * Also write the algorithm in pseudocode before coding it. 
         */

        /* Algorithm in psuedocode (fast, to be refractors for better clarification): 
         * 
         * 
         * We will iterate through all the cells. Therefore, perhaps simply iterate through all the cells in each row. 
         * 
         * We will look for the first row that is not complete. There must be a Cell in this row without its final value. 
         * 
         * We iterate through the row to find the Cell that is incomplete. 
         *  This cell should have it's row, column, and box filled with potential values. 
         *      Perhaps seperate this process into it's own fillPotentialValues() function in Puzzle. 
         *      The main problem is perhaps the column.fillPotentalValues() will give it a potential value that is not possible based on the row it exists in. 
         *      Solution --> move fillPotentialValues() function here, so it can fill a Cell based on all 3. Same code, but our unusedValue set is checked by the row, column, and box (instead of singularly) -- it should only fill a singular cell with each call tho. 
         * 
         * Once that is done, the idea is:
         * We can now fill a Cell with its potential values. We check if there is only 1 element in potential value (in which case this must be the only value it can be and thus it's final value)
         *      In this case, we must edit the cell, which can be done with previous function. 
         *      Edit will check completion status, so each time we edit a Cell check if it complete, at which point exit the loop. 
         * 
         * Otherwise, keep iterating through the Cells.
         * 
         * NOTE, perhaps, the first time we saw a Cell we did fillPotentialValues() and gave it a set. 
         * The second time we saw it, it now has a value that is in its potential values but has already been set (i.e., between the first and second time we land on this Cell)
         * So not that potential value still exists, as we never removed it from the potential value of this cell. 
         * 
         * IDEA: we only run fillPotentialValues ONCE the first thru every cell. We know how many iterations this will be and can control that. 
         *       Then, we start go through the puzzle over and over again, checking if each unsolved cell has only 1 element in the fillPOtentialValues. 
         *              If there si only 1 potential value, we have a helper function that removes this value as a potentialValue for all unsolved cells in it's row, column, and box
         *                  This can either be done in edit, or simply a helper function we call only here. 
         *                  Probably better to keep it seperate to ensure seperation of duty (i.e., we edit when user it changing an unsolved puzzle too, not just when solving ; but this helper function is specifically when we are solving a puzzle)
         *             This way, we ensure potentialValues are maintained correctly, and we only fill it once. From there, we simply remove it. 
         *              This loop is also the one where it needs to be terminated via a condition because we dont know how many iterations this will take. 
         * 
         */

        return true; 
    }

    /**
     * Represents the Puzzle as a String. 
     * 
     * @return The value at all Cells in the Puzzle in string format, maintaining the 3x3 blocks seen in a Sudoku puzzle by including a 4-space gap between each subsection. 
     */
    public String toString() {
        String toReturn = ""; 

        for (int i = 0; i < Constants.GRID_SIZE; i++) {
            if (i % 3 == 0 && i != 0) {
                toReturn += "\n"; 
            }
            toReturn += row[i].toString(); 
        }

        return toReturn; 
    }

}