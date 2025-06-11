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

    /**
     * For any Cell in our Puzzle with an unknown value, fill their poentialValue set with all the possible numbers they could possibly be.
     * 
     * @return true if task was completed successfully. 
     */
    public boolean fillPotentalValues() {
        for (int i = 0; i < Constants.GRID_SIZE; i++) {
            if (!row[i].isComplete()) {
                //There must be >= 1 Cell that has an unknown value in this row, find them all and fill their potentialValues
                Cell curCell; 

                for (int l = 0; l < Constants.GRID_SIZE; l++) {
                    curCell = row[i].getCell(l); 
                    curCell.fillPotentalValues(row[curCell.getRowNumber()], column[curCell.getColumnNumber()], box[curCell.getBoxNumber()]); 
                }
            }
        }

        return true; 
    }

    /**
     * Solve the puzzle, meaning give all Cell their final value. 
     * 
     * @return true if task completed successfully. 
     */
    public boolean solve() {
        boolean completed = false; 
        fillPotentalValues(); 
        Cell curCell; 
        int value; 

        while (!completed) {
            //Find a Cell that has a potentialValue set of size 1 
            for (int i = 0; i < Constants.GRID_SIZE; i++) {
                for (int l = 0; l < Constants.GRID_SIZE; l++) {
                    curCell = row[i].getCell(l); 
                    value = curCell.finalValue(); 

                    if (value != 0) {
                        curCell.setValue(value);

                        row[i].removePotentialValue(value); 
                        column[curCell.getColumnNumber()].removePotentialValue(value); 
                        box[curCell.getBoxNumber()].removePotentialValue(value); 
                    }
                }
            }
          
            if (checkCompletion()) {
                completed = true; 
                complete = true; 

            }

        }

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